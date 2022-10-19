package com.example;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

    int x = 100;
    int y = 100;

    public MyFrame() {
        setTitle("test");
        setSize(1024, 768);
        // 不可改变窗体大小
        setResizable(false);
        setVisible(true);

        this.addKeyListener(new MyKeyLiner());

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

    /**
     * clear price  new price
     */
    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
    }


    class MyKeyLiner extends KeyAdapter {

        // 上下左右标识
        boolean tflag = false;
        boolean dflag = false;
        boolean lflag = false;
        boolean rflag = false;

        /**
         * 键盘按下获取焦点时
         */
        @Override
        public void keyPressed(KeyEvent e) {
            // System.out.println("key keyPressed ....");
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    y -= 10;
                    tflag = true;
                    break;
                case KeyEvent.VK_DOWN:
                    y += 10;
                    dflag = true;
                    break;
                case KeyEvent.VK_LEFT:
                    x -= 10;
                    lflag = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 10;
                    rflag = true;
                    break;
                default:
                    break;
            }

        }

        /**
         * 键盘按下焦点释放后
         */
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    y -= 10;
                    tflag = false;
                    break;
                case KeyEvent.VK_DOWN:
                    y += 10;
                    dflag = false;
                    break;
                case KeyEvent.VK_LEFT:
                    x -= 10;
                    lflag = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 10;
                    rflag = false;
                    break;
                default:
                    break;
            }
        }
    }


}
