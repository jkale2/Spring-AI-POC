package com.springai.example.demo.controller;

import com.springai.example.demo.dto.ChatRequest;
import com.springai.example.demo.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/generate")
    public String generate(@RequestBody ChatRequest request) {
        return chatService.generateText(request.getMessage());
    }
}

