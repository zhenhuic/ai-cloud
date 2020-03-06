package com.chenzhenhui.aicloud.utils;

public class BytesUtil {
    public static Byte[] byteArrayBoxing(byte[] bytes) {
        Byte[] boxedBytes = new Byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            boxedBytes[i] = bytes[i];
        }
        return boxedBytes;
    }
}
