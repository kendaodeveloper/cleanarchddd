package org.example.infraestructure;

import org.example.infraestructure.configuration.WebServerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication {
  public static void main(String[] args) {
    SpringApplication.run(WebServerConfiguration.class, args);
  }
}