package com.example.register.models.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_form")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotBlank
    String login;
    @NotBlank
    String password;
    @NotBlank
    @Email
    String email;
    @NotBlank
    String name;
    @NotBlank
    String surname;
    @NotBlank
    String patronymic;


}
