package com.olegnew.jvtestfromproxyband.service.impl;

import com.olegnew.jvtestfromproxyband.model.User;
import com.olegnew.jvtestfromproxyband.repository.UserRepository;
import com.olegnew.jvtestfromproxyband.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> finfAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(String id) {
        userRepository.deleteById(id);
    }

}
