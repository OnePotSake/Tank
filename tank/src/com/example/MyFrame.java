package com.example;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

 int x = 100;
 int y = 100;

    public MyFrame() {
        setTitle("test");
        setSize(1024, 768);
        setResizable(false);
        setVisible(true);

        // 监听 窗体 事件
        // listen in windows event
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 非正常退出，就是说无论程序正在执行与否，都退出
                // system.exit(1)
                // 正常退出
                System.exit(0);
            }
        });

    }

    /*clear price  new price*/
    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);

        x+=100;
        y+=100;

    }
}
