package com.example.firsteventdriven.kafka;

import com.example.firsteventdriven.processor.base.EventMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerService {
    private final KafkaTemplate<String, EventMessage> kafkaTemplate;

    public void produce(EventMessage eventMessage) {
        kafkaTemplate.send("messages", eventMessage);
    }
}
