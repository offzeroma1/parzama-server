package com.cw_spring.pazama_server.config;

import com.cw_spring.pazama_server.domain.common.EventType;
import com.cw_spring.pazama_server.infrastructure.event.redis.RedisTaskSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisConfig {

    @Bean
    public MessageListenerAdapter messageListenerAdapter(RedisTaskSubscriber subscriber) {
        return new MessageListenerAdapter(subscriber);
    }

    /**
     * redis Pub/Sub ListenerContainer
     */
    @Bean
    public RedisMessageListenerContainer redisContainer(RedisConnectionFactory factory, MessageListenerAdapter adapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.addMessageListener(adapter, new PatternTopic(EventType.TASK_EVENT.getEventType())); // 채널 구독

        return container;
    }
}
