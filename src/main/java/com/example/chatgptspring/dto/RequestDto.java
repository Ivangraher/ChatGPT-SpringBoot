package com.example.chatgptspring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDto {

    private String model;
    private List<MessageDto> messages;

    public RequestDto(String model, String prompt) {
        this.model = model;
        messages = new ArrayList<>();
        messages.add(new MessageDto("user", prompt));
    }
}
