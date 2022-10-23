package com.example;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

    int x = 100;
    int y = 100;

    // 定义初始坦克位置方向
    Dir dir  = Dir.DOWN ;

    // 速度定义
    final  int SPEED  = 10;


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

        switch (dir) {
            case LEFT:
               x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
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
                    tflag = true;
                    break;
                case KeyEvent.VK_DOWN:
                    dflag = true;
                    break;
                case KeyEvent.VK_LEFT:
                    lflag = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    rflag = true;
                    break;
                default:
                    break;
            }

            setDirTankMain();
        }

        /**
         * 键盘按下焦点释放后
         */
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    tflag = false;
                    break;
                case KeyEvent.VK_DOWN:
                    dflag = false;
                    break;
                case KeyEvent.VK_LEFT:
                    lflag = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    rflag = false;
                    break;
                default:
                    break;
            }

            setDirTankMain();
        }


        private void setDirTankMain() {
            if(tflag) {dir = Dir.UP;}
            if(dflag) {dir = Dir.DOWN;}
            if(lflag) {dir = Dir.LEFT;}
            if(rflag) {dir =Dir.RIGHT;}
        }
    }
}
