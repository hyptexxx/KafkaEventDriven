package com.example.firsteventdriven.input.controller.rest;


import com.example.firsteventdriven.kafka.ProducerService;
import com.example.firsteventdriven.processor.base.EventMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import static com.example.firsteventdriven.processor.base.EventOwner.SYSTEM_CORE;
import static com.example.firsteventdriven.processor.base.EventType.CORE_EVENT;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final TemperatureSensor temperatureSensor;
    private final ProducerService producerService;
    private final RxSseEmitter rxSseEmitter;


    @GetMapping("/test")
    public SseEmitter handleRequestInPool() {


        temperatureSensor.temperatureStream()
                .subscribe(rxSseEmitter.getSubscriber());

        return rxSseEmitter;
    }

    @PostMapping("/put")
    public void put(@RequestParam("test") String test) {
        producerService.produce(EventMessage.builder()
                .eventType(CORE_EVENT)
                .eventOwner(SYSTEM_CORE)
                .eventPayload(test)
                .build());
    }
}
