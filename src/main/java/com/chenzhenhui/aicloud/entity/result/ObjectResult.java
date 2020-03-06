package com.chenzhenhui.aicloud.entity.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 检测的物体信息的封装类
 */
@Data
public class ObjectResult implements Serializable {

    private String className;
    private Float score;

    // 物体边界框信息
    private Integer left;
    private Integer top;
    private Integer width;
    private Integer height;
}
