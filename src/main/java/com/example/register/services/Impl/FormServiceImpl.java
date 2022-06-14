package com.example.register.services.Impl;



import com.example.register.config.EmailSender;
import com.example.register.daos.FormDao;
import com.example.register.mappers.FormMapper;
import com.example.register.models.request.SignUpRequest;
import com.example.register.models.dtos.FormDto;
import com.example.register.models.entities.Form;
import com.example.register.models.response.Message;
import com.example.register.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private EmailSender emailSender;


    @Autowired
    private FormDao formDao;
    private FormMapper formMapper = FormMapper.INSTANCE;


    @Override
    public ResponseEntity<?> saveForm(SignUpRequest signUpRequest) {
        Form form = new Form();
        form.setLogin(signUpRequest.getLogin());
        form.setPassword(signUpRequest.getPassword());
        form.setEmail(signUpRequest.getEmail());
        form.setName(signUpRequest.getName());
        form.setSurname(signUpRequest.getSurname());
        form.setPatronymic(signUpRequest.getPatronymic());


        try {
            Form form2 = formDao.save(form);
            boolean res = response(form2.getLogin());

            if (res){
                ResponseEntity<?> sendMessage = sendCode(formMapper.toDto(form2));
                return new ResponseEntity<>(sendMessage,HttpStatus.OK);
            }else{
                ResponseEntity<?> sendMessage = sendCode2(formMapper.toDto(form2));
                return new ResponseEntity<>(sendMessage,HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(Message.of("Form not saved"), HttpStatus.EXPECTATION_FAILED);
        }

    }


    @Override
    public ResponseEntity<?> sendCode(FormDto formDto) {
        try {
            emailSender.sendSimpleMessage(formDto.getEmail(), "You are successfully signUp", ".");
        } catch (Exception ex) {
            return new ResponseEntity<>(Message.of("Ошибка в процессе отправки кода на почту"), HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>(Message.of("Success"), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> sendCode2(FormDto formDto) {
        try {
            emailSender.sendSimpleMessage(formDto.getEmail(), "You are not accepted", ".");
        } catch (Exception ex) {
            return new ResponseEntity<>(Message.of("Ошибка в процессе отправки кода на почту"), HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>(Message.of("Success"), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<?> findAllForm(Pageable pageable) {
        Page<Form> form = formDao.findAll(pageable);
        if(!form.isEmpty()){
            return new ResponseEntity<>(form, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(Message.of("Failed when calling findAll method"), HttpStatus.NOT_FOUND);
        }
    }
    List<Form> res = new ArrayList<>();

    @Override
    public List<Form> findAll() {
        List<Form> forms  = formDao.findAll();
        if (!forms.isEmpty()){
            return forms;
        }else{
            return res;
        }
    }

    Random rd = new Random();
    public boolean response(String login) {
        boolean ans = rd.nextBoolean();

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8081/api/saveForm";
        return ans;

    }
}
