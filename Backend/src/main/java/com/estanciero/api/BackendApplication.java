package com.estanciero.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner probarConexion(DataSource dataSource) {
        return args -> {
            try (Connection conn = dataSource.getConnection()) {
                System.out.println("----------------------------------------");
                System.out.println("¡CONEXIÓN EXITOSA!");
                System.out.println("Conectado a la base de datos: " + conn.getCatalog());
                System.out.println("----------------------------------------");
            } catch (Exception e) {
                System.err.println("----------------------------------------");
                System.err.println("ERROR DE CONEXIÓN : " + e.getMessage());
                System.err.println("----------------------------------------");
            }
        };
    }
}
