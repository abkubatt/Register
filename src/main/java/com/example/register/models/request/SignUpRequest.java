package com.example.register.models.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class SignUpRequest {
    @NotBlank(message = "Login must not be empty")
    String login;
    @NotBlank(message = "Password must not be empty")
    String password;
    @NotBlank(message = "Email must not be empty")
    @Email(message = "Invalid email format")
    String email;
    @NotBlank(message = "Name must not be empty")
    String name;
    @NotBlank(message = "Surname must not be empty")
    String surname;
    @NotBlank(message = "Patronymic must not be empty")
    String patronymic;
}
