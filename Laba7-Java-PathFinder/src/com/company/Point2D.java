package com.company;

public class Point2D {
    protected int x;
    protected int y;
    public Point2D(){
        this(0,0);
    }
    public Point2D(int x,int y){
        this.x = x;
        this.y = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEqual(Point2D p){
        if(x == p.x && y == p.y)return true;
        return false;
    }

}
