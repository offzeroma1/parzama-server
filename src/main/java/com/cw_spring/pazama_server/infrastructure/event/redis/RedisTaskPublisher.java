package com.cw_spring.pazama_server.infrastructure.event.redis;

import com.cw_spring.pazama_server.domain.common.EventType;
import com.cw_spring.pazama_server.domain.task.TaskVo;
import com.cw_spring.pazama_server.infrastructure.event.AbstractEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisTaskPublisher extends AbstractEventPublisher<TaskVo> {
    //redis
    private final RedisTemplate<String, Object> redisTemplate;

    public void sendTaskVo(TaskVo taskVo) {
        send(taskVo);
    }

    @Override
    protected String getEventType() {
        return EventType.TASK_EVENT.getEventType();
    }
    @Override
    protected Object setMessage(TaskVo taskMessage) {
        return taskMessage;
    }
    @Override
    protected void publish(String eventType, Object message) {
        redisTemplate.convertAndSend(eventType, message);
    }
}
