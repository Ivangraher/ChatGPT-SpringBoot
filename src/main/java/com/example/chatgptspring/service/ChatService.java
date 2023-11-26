package com.example.chatgptspring.service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public String getPrompt(String album) {
        String prompt = "Si " + album + " no es un disco de algún grupo o artista musical responde: no conozco esa obra y finaliza; " +
                "en caso contrario haz una descripción muy breve y concisa del disco titulado " + album + " y añade la frase: 'Te gustará si te gustan' " +
                "y a continuación cita tres artistas o bandas similares";

        return prompt;
    }
}
