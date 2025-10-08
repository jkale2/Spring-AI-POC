package com.springai.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

@Service
public class ChatService {

    private final Client client;

    public ChatService(@Value("${gemini.api.key}") String apiKeyValue) {
        this.client = Client.builder().apiKey(apiKeyValue).build();
    }

    public String generateText(String message) {
        GenerateContentResponse response = client.models.generateContent(
                "gemini-2.5-flash", // Gemini model ID
                message,
                null // config, can be null for defaults
        );
        return response.text();
    }
}

