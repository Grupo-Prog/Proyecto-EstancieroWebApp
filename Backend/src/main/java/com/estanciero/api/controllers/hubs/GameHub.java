package com.estanciero.api.controllers.hubs;


import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GameHub {

    private final SimpMessagingTemplate messagingTemplate;

    public GameHub(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

}
