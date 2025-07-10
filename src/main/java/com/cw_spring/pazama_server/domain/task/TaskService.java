package com.cw_spring.pazama_server.domain.task;

import com.cw_spring.pazama_server.infrastructure.event.redis.RedisTaskPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final RedisTaskPublisher redisTaskPublisher;

    public void insertTask(TaskVo taskVo) {
        // TODO: DB 저장 로직이 들어갈 자리 (예: taskRepository.save())

        // 알림 전송
        redisTaskPublisher.sendTaskVo(taskVo);
    }
}