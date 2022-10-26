package com.tank.day01;

import com.example.Dir;
import com.example.MyFrame;

public class RunTankDemo {
    public static void main(String[] args) throws InterruptedException {

        TankFrame tankFrame = new TankFrame();
        // 死循环
        while (true) {
            // 睡眠1s
            Thread.sleep(100);
            // 画布重新绘制
            tankFrame.repaint();
        }


    }
}
