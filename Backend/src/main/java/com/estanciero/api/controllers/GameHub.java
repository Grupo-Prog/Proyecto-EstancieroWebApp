package com.estanciero.api.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class GameHub {

    private final SimpMessagingTemplate messagingTemplate;

    public GameHub(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/test")
    public void testWebsocket(@Payload Map<String, String> payload) {
        var mensaje = payload.get("content");
        System.out.println("=========================");
        System.out.println("MENSAJE RECIBIDO:" + mensaje);
        System.out.println("=========================");

        Map<String,String> respuesta = Map.of("content", "Mandaste: " + mensaje);
        messagingTemplate.convertAndSend("/topic/test", respuesta);
    }
}
