package com.chenzhenhui.aicloud;

import com.chenzhenhui.aicloud.entity.result.DetectionResult;
import com.chenzhenhui.aicloud.entity.result.ObjectResult;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

@SpringBootTest
class AiCloudApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

//    StringDetectionResultRedisTemplate stringDetectionResultRedisTemplate;

    @Test

    void contextLoads() {
    }

    @Test
    void testSendRabbit() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "测试消息");
        map.put("data", Arrays.asList("hello", 123, true));
        rabbitTemplate.convertAndSend("aicloud.direct", "aicloud", map);
    }

    @Test
    void testReceiveRabbit() {
        Object aicloud = rabbitTemplate.receiveAndConvert("aicloud");
        if (aicloud != null) {
            System.out.println(aicloud.getClass());
        }
        System.out.println(aicloud);
    }

    @Test
    void testRedis() {
        DetectionResult detectionResult = new DetectionResult();
        detectionResult.setImageId("1");
        detectionResult.setObjectsNumber(1);

        ObjectResult objectResult = new ObjectResult();
        objectResult.setClassName("person").setScore(0.9f).setLeft(20).setTop(10).setHeight(100);
        ArrayList<ObjectResult> objectResults = new ArrayList<>();
        objectResults.add(objectResult);
        detectionResult.setResults(objectResults);
        redisTemplate.opsForValue().set("testo", detectionResult);
    }

    @Test
    void testRedisGet() {
        Object testo = redisTemplate.opsForValue().get("testo");

        System.out.println(testo);
//        DetectionResult test = (DetectionResult) redisTemplate.opsForValue().get("testo");
//        System.out.println(test);
    }

}
