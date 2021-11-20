package com.example.firsteventdriven.processor;

import com.example.firsteventdriven.processor.base.EventMessage;
import com.example.firsteventdriven.processor.base.EventType;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.EnumSet.of;

@Component
public class NlpMessageEventProcessor implements EventProcessor {
    @Override
    public Set<EventType> supportEventTypes() {
        return of(EventType.NLP_EVENT);
    }

    @Override
    public void perform(EventMessage eventMessage) {

    }
}