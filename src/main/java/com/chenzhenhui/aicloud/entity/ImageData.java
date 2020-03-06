package com.chenzhenhui.aicloud.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ImageData implements Serializable {
    private String imageId;
    private Byte[] data;
}
