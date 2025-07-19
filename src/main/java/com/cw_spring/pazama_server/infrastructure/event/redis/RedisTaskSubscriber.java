package com.cw_spring.pazama_server.infrastructure.event.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisTaskSubscriber implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String topic = new String(pattern);
        String body = new String(message.getBody());

        System.out.println("🔔 수신됨: [" + topic + "] → " + body);
    }
}
