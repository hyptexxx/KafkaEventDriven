package com.example.firsteventdriven.kafka;

import com.example.firsteventdriven.dispatcher.ProcessorDispatcher;
import com.example.firsteventdriven.processor.base.EventContent;
import com.example.firsteventdriven.processor.base.EventMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerService implements EventContent {
    private final ProcessorDispatcher processorDispatcher;

    @KafkaListener(topics = "messages", groupId = "message_group_id")
    public void consume(EventMessage eventMessage) {
        log.debug("received message: {}", eventMessage);
        processorDispatcher.dispatchMessage(eventMessage);
    }
}
