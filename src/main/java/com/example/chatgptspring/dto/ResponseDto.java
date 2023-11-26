package com.example.chatgptspring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDto {

    private List<Choice> choiceList;

    @Data
    public static class Choice{
        private MessageDto messageDto;
        private int index;
    }
}
