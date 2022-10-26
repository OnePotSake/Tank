package com.tank.day01;

import com.example.Dir;

import java.awt.*;

import static java.nio.file.Files.move;

/**
 * 封装坦克基础基础属性
 * */
public class Tank {

    private int x = 100,y = 100;
    private Dir dir = Dir.DOWN;
    private boolean moveing = false;

    private final static int SPEED = 20;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoveing() {
        return moveing;
    }

    public void setMoveing(boolean moveing) {
        this.moveing = moveing;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);

        move();

    }


    public Tank(int x, int y, Dir dir) throws HeadlessException {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void move() {
        if(!moveing) {
            return;
        }


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
}
