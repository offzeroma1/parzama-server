package com.cw_spring.pazama_server.domain.common;

public enum EventType {
    TASK_EVENT("task_event");

    private final String eventType;
    EventType(String eventType){
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}
