package com.chenzhenhui.aicloud;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.JFrame;

@SpringBootTest
public class JavaCVTests {

    @Test
    public void testJavaCV() throws FrameGrabber.Exception, InterruptedException {
        System.setProperty("java.awt.headless", "false");  // 更改虚拟机参数，修复java.awt.HeadlessException

        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.start();  //开始获取摄像头数据
        CanvasFrame canvas = new CanvasFrame("摄像头");  //新建一个窗口
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setAlwaysOnTop(true);

        while(true) {
            if(!canvas.isDisplayable()) {  //窗口是否关闭
                grabber.stop();  //停止抓取
                System.exit(2);  //退出
            }
            //获取摄像头图像并放到窗口上显示
            Frame frame=grabber.grab();
            canvas.showImage(frame);

            Thread.sleep(50);  //50毫秒刷新一次图像
        }
    }

}
