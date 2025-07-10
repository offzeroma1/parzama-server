package com.cw_spring.pazama_server.infrastructure.event;

public abstract class AbstractEventPublisher<T> {

    protected abstract String getEventType();
    protected abstract Object setMessage(T message);

    protected abstract void publish(String type, Object message);

    public void send(T message){
        String eventType = getEventType();
        Object redisMessage = setMessage(message);
        publish(eventType, redisMessage);
    }
}