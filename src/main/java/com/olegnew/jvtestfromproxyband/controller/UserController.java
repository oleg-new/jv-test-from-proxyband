package com.olegnew.jvtestfromproxyband.controller;

import com.olegnew.jvtestfromproxyband.dto.UserRequestDto;
import com.olegnew.jvtestfromproxyband.dto.UserResponseDto;
import com.olegnew.jvtestfromproxyband.model.User;
import com.olegnew.jvtestfromproxyband.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;

    @GetMapping("/")
    public List<UserResponseDto> findAll() {
        List<User> users = userService.finfAll();
        List<UserResponseDto> userDto = users.stream()
                .map(e -> modelMapper.map(e, UserResponseDto.class))
                .collect(Collectors.toList());
        return userDto;
    }

    @PostMapping("/add")
    public UserResponseDto add(@RequestBody @Valid UserRequestDto userRequestDto) {
        User user = userService.add(modelMapper.map(userRequestDto, User.class));
        return modelMapper.map(user, UserResponseDto.class);
    }

    @PutMapping("/update/{id}")
    public UserResponseDto update(@PathVariable String id,
                                  @RequestBody UserRequestDto userRequestDto) {
        User user = modelMapper.map(userRequestDto, User.class);
        user.setId(id);
        return modelMapper.map(userService.update(user), UserResponseDto.class);
    }

    @DeleteMapping("/remove/{id}")
    public void delete(@PathVariable String id) {
        userService.remove(id);
    }

}
