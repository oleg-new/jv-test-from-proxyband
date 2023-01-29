package com.olegnew.jvtestfromproxyband.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank
    private String name;
    @Email(message = " \"Email\" must be a valid email address ")
    private String email;
}
