package com.chenzhenhui.aicloud.entity.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * The wrapper class of the classification result of image
 */
@Accessors(chain = true)
@Data
public class ClassificationResult implements Serializable {
    private String imageId;
    private String className;
    private Float score;
}
