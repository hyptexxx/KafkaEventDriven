package com.example.firsteventdriven.processor;

import com.example.firsteventdriven.processor.base.EventMessage;
import com.example.firsteventdriven.processor.base.EventType;

import java.util.Set;

public interface EventProcessor {
    /**
     * Типы событий поддерживаемых процессором.
     *
     * @return Список событий поддерживаемых процессором.
     */
    Set<EventType> supportEventTypes();

    /**
     * Основная точка входа в процессор.
     *
     * @param eventMessage
     */
    void perform(EventMessage eventMessage);
}
