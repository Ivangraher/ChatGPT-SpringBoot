package com.example.chatgptspring.controller;

import com.example.chatgptspring.dto.MessageDto;
import com.example.chatgptspring.dto.RequestDto;
import com.example.chatgptspring.dto.ResponseDto;
import com.example.chatgptspring.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ChatService chatService;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;


    @PostMapping("/chat")
    public ResponseEntity<MessageDto> chat(@RequestParam String prompt) {
        // create a request
        RequestDto requestDto = new RequestDto(model, chatService.getPrompt(prompt));

        //Call the API
        ResponseDto responseDto = restTemplate.postForObject(apiUrl, requestDto, ResponseDto.class);
;

        if (requestDto == null || responseDto.getChoiceList() == null || responseDto.getChoiceList().isEmpty()) {
            return ResponseEntity.badRequest().body(new MessageDto("user", "fallo en la consulta"));
        }

        // return the first response
        return ResponseEntity.ok(responseDto.getChoiceList().get(0).getMessageDto());
    }
}
