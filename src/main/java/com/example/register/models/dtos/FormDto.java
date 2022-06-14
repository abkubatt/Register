package com.example.register.models.dtos;

import lombok.Data;

@Data
public class FormDto {
    Long id;
    String login;
    String password;
    String email;
    String name;
    String surname;
    String patronymic;
}