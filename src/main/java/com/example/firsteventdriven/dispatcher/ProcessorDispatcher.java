package com.example.firsteventdriven.dispatcher;

import com.example.firsteventdriven.processor.EventProcessor;
import com.example.firsteventdriven.processor.base.EventMessage;
import com.example.firsteventdriven.processor.base.EventType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class ProcessorDispatcher {

    private final Map<EventType, EventProcessor> processorMap = new EnumMap<>(EventType.class);

    public ProcessorDispatcher(List<EventProcessor> eventProcessors) {
        eventProcessors.forEach(this::fillProcessorsMap);
    }

    public void dispatchMessage(EventMessage eventMessage) {
        processorMap.get(eventMessage.getEventType())
                .perform(eventMessage);
    }

    private void fillProcessorsMap(EventProcessor eventProcessor) {
        eventProcessor.supportEventTypes()
                .forEach(eventType -> processorMap.put(eventType, eventProcessor));
    }
}