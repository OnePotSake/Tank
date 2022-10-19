package com.example;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Demo {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setTitle("test");
        frame.setSize(1024, 768);
        frame.setResizable(false);
        frame.setVisible(true);

        // 监听 窗体 事件
        // listen in windows event
        frame.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // 非正常退出，就是说无论程序正在执行与否，都退出
                // system.exit(1)

                // 正常退出
                System.exit(0);
            }
        });

    }


    public void paint(Graphics g) {
        System.out.println("2q3");
        g.fillRect(200, 200, 50, 50);
    }




}