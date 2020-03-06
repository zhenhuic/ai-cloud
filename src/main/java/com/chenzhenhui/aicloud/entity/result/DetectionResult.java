package com.chenzhenhui.aicloud.entity.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 一张图片的检测结果封装类
 */
@Data
public class DetectionResult implements Serializable {
    private String imageId;
    private Integer objectsNumber;
    private List<ObjectResult> results;
}
