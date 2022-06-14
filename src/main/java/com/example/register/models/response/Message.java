package com.example.register.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Message {

    final String message;

    public static Message of(String message){
        return new Message(message);
    }
}

