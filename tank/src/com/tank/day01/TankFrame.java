package com.tank.day01;

import com.example.Dir;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 封装坦克基础基础属性
 */
public class TankFrame extends Frame {


    private  Tank myTank = new Tank( 50, 50, Dir.DOWN);

    public TankFrame() {
        setTitle("test");
        setSize(1024, 768);
        // 不可改变窗体大小
        setResizable(false);
        setVisible(true);

        this.addKeyListener(new TankFrame.KeyListener());

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

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
    }

    class KeyListener extends KeyAdapter {
        boolean bl = false;
        boolean bt = false;
        boolean br = false;
        boolean bd = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_UP:
                    bt = true;
                    break;

                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;

                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;

                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
            }

            setMoveing();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bt = false;
                    break;

                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;

                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;

                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                default:
                    break;
            }

            setMoveing();
        }

        private void setMoveing() {
            if(!br && !bt && !bl && !bd) {
                myTank.setMoveing(false);
            } else {
                myTank.setMoveing(true);

                if (bl) {
                    myTank.setDir(Dir.LEFT);
                }
                if (bd) {

                    myTank.setDir(Dir.DOWN);
                }
                if (br) {
                    myTank.setDir(Dir.RIGHT);
                }
                if (bt) {
                    myTank.setDir(Dir.UP);
                }

            }

        }
    }


}
