package com.chenzhenhui.aicloud.entity.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * The wrapper class for the detected object
 */
@Accessors(chain = true)
@Data
public class ObjectResult implements Serializable {

    private String className;
    private Float score;

    // The bounding box
    private Integer left;
    private Integer top;
    private Integer width;
    private Integer height;
}
