package com.example.firsteventdriven.processor;

import com.example.firsteventdriven.processor.base.EventMessage;
import com.example.firsteventdriven.processor.base.EventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.EnumSet.of;

@Slf4j
@Component
public class SystemMessageProcessor implements EventProcessor {
    @Override
    public Set<EventType> supportEventTypes() {
        return of(EventType.CORE_EVENT,
                EventType.NLP_EVENT);
    }

    @Override
    public void perform(EventMessage eventMessage) {
        log.debug("received message: {}", eventMessage.getEventPayload());
    }
}
