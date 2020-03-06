package com.chenzhenhui.aicloud.entity.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 图像分类的结果封装类
 */
@Data
public class ClassificationResult implements Serializable {
    private String imageId;
    private String className;
    private Float score;
}
