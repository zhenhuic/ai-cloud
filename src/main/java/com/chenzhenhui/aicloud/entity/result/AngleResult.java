package com.chenzhenhui.aicloud.entity.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *  The wrapper class of production Angle detection results
 */
@Accessors(chain = true)
@Data
public class AngleResult implements Serializable {
    private String imageId;
    private Float angle;
    private Boolean qualified;
}
