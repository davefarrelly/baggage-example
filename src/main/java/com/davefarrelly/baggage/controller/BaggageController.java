package com.davefarrelly.baggage.controller;

import brave.baggage.BaggageField;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;


@Controller
@Validated
@AllArgsConstructor
@RequestMapping(path = "/users/")
public class BaggageController {

  @Autowired
  private final BaggageField userNameField;


  @GetMapping("user")
  public Mono<ResponseEntity<String>> getCommitStatus() {

    userNameField.updateValue("David");

    return Mono.just(ResponseEntity.ok(userNameField.getValue()));
  }

}
