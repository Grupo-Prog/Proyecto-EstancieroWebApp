package com.estanciero.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
/*
* Clase para configurar los websockets
* */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        // Habilita un broker simple en memoria.
        // utiliza el modelo publish/suscribe
        // el servidor envía eventos asi: /topic/game-started
        config.enableSimpleBroker("/topic");

        // Los mensajes/eventos que se envían al servidor empiezan con /app
        // ej: app/roll-dice
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        registry.addEndpoint("/ws-estanciero")
                .setAllowedOriginPatterns("*") // cambiar a la url del frontend
                .withSockJS(); // Permite fallback si el navegador no soporta WebSockets puros
    }
}
