package com.chenzhenhui.aicloud.entity.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * the wrapper class of the detected results of image
 */
@Accessors(chain = true)
@Data
public class DetectionResult implements Serializable {
    private String imageId;
    private Integer objectsNumber;
    private List<ObjectResult> results;
}
