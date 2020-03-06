package com.chenzhenhui.aicloud.controller;

import com.chenzhenhui.aicloud.entity.ImageData;
import com.chenzhenhui.aicloud.service.impl.ObjectDetectionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/det")
public class DetectionController {

    final ObjectDetectionService objectDetectionService;

    public DetectionController(ObjectDetectionService objectDetectionService) {
        this.objectDetectionService = objectDetectionService;
    }

    @PostMapping("/obj")
    public String detectObjects(@RequestParam("imageFile") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "文件上传失败！";
        }
        String contentType = file.getContentType();
        if (contentType != null && !contentType.startsWith("image")){
            return "请上传图片格式文件！";
        }

        String originalFilename = file.getOriginalFilename();

        byte[] bytes = file.getBytes();
        System.out.println(originalFilename);
        System.out.println(bytes.length);

        ImageData imageData = new ImageData();
        imageData.setImageId("1");
        Byte[] pBytes = new Byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            pBytes[i] = bytes[i];
        }
        imageData.setData(pBytes);

        return objectDetectionService.detect(imageData);

    }

    @PostMapping("/angle")
    public String detectAngle() {
        return "angle";
    }
}
