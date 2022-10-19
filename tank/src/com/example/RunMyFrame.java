package com.example;

public class RunMyFrame {
    public static void main(String[] args) throws InterruptedException {
        MyFrame myFrame = new MyFrame();
        // 死循环
        while (true) {
            // 睡眠1s
            Thread.sleep(1000);
            // 画布重新绘制
            myFrame.repaint();
        }

    }
}
