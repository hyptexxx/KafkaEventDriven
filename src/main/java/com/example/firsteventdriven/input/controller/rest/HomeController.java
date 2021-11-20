package com.example.firsteventdriven.input.controller.rest;


import com.example.firsteventdriven.processor.base.EventMessage;
import com.example.firsteventdriven.kafka.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.firsteventdriven.processor.base.EventOwner.SYSTEM_CORE;
import static com.example.firsteventdriven.processor.base.EventType.CORE_EVENT;


@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController {

    private final ProducerService producerService;

    @GetMapping("/generate")
    public String generate(@RequestParam String message) {
        producerService.produce(EventMessage.builder()
                .eventType(CORE_EVENT)
                .eventOwner(SYSTEM_CORE)
                .eventPayload(message)
                .build());
        return "OK";
    }
}
