package com.davefarrelly.baggage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class BaggageExample {

  public static void main(String[] args) {
    SpringApplication.run(BaggageExample.class, args);
  }

}
