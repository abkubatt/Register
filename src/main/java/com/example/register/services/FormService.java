package com.example.register.services;


import com.example.register.models.request.SignUpRequest;
import com.example.register.models.dtos.FormDto;
import com.example.register.models.entities.Form;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FormService {

    ResponseEntity<?> saveForm(SignUpRequest signUpRequest);

    ResponseEntity<?> sendCode(FormDto formDto);
    ResponseEntity<?> sendCode2(FormDto formDto);

    ResponseEntity<?> findAllForm(Pageable pageable);

    List<Form> findAll();

    boolean response(String login);
}