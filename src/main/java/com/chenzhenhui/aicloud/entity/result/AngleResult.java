package com.chenzhenhui.aicloud.entity.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 工件角度检测结果包装类
 */
@Data
public class AngleResult implements Serializable {
    private String imageId;
    private Float angle;
    private Boolean qualified;
}
