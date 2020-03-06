package com.chenzhenhui.aicloud;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class AiCloudApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

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

}
