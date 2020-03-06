package com.chenzhenhui.aicloud.service.impl;

import com.chenzhenhui.aicloud.amqp.RabbitOperation;
import com.chenzhenhui.aicloud.entity.ImageData;
import com.chenzhenhui.aicloud.service.IDetectionService;
import org.springframework.stereotype.Service;

@Service
public class ObjectDetectionService implements IDetectionService {

    final RabbitOperation rabbitOperation;

    public ObjectDetectionService(RabbitOperation rabbitOperation) {
        this.rabbitOperation = rabbitOperation;
    }

    @Override
    public String detect(ImageData imageData) {
        rabbitOperation.sendToRabbit("aicloud.direct", "aicloud.img", imageData);
        return "发送至消息队列";
    }
}
