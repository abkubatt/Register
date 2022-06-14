package com.example.register.controllers;

import com.example.register.models.request.SignUpRequest;
import com.example.register.models.dtos.FormDto;
import com.example.register.models.entities.Form;
import com.example.register.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {

    @Autowired
    private FormService formService;

    List<String> ans = new ArrayList<>();

    @GetMapping("/")
    public String save(Model model) {
        if (!findAll().isEmpty()){
            model.addAttribute("users",findAll());
            return "saveForm";
        }
        model.addAttribute("users", ans);
        return "saveForm";
    }
    @PostMapping("/saveForm")
    public String saveForm(SignUpRequest signUpRequest){

        formService.saveForm(signUpRequest);

        return "redirect:/";
    }

    @PutMapping("/sendCode")
    public ResponseEntity<?> sendCode(@RequestBody FormDto formDto){
        return formService.sendCode(formDto);
    }

    @GetMapping("/findAll")
    public List<Form> findAll(){
        return formService.findAll();
    }
}


