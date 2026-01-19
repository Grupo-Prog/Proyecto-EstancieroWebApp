package com.estanciero.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * Clase de configuración para swagger
 */
@Configuration
public class SwaggerConfig {

    //puerto
    @Value("${server.port:8080}")
    private String serverPort;

    // ruta base de la app
    @Value("${server.servlet.context-path:}")
    private String contextPath;

    //cambia el titulo del swagger
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("El Estanciero API")
                        .version("1.0.0"));
    }

    //muestra la url de swagger
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        // URL dinamica
        String swaggerUrl = String.format("http://localhost:%s%s/swagger-ui/index.html", serverPort, contextPath);


        System.out.println("\n----------------------------------------------------------");
        System.out.println("SWAGGER INICIADO CORRECTAMENTE");
        System.out.println("URL: " + swaggerUrl);
        System.out.println("----------------------------------------------------------\n");
    }
}