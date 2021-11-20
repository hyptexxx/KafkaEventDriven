package com.example.firsteventdriven.processor.base;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class EventMessage {
    EventType eventType;
    EventOwner eventOwner;
    String eventPayload;
}
