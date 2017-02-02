package io.muic.ooc.thienthai.zork;

public class posObject {
    private Integer posX;
    private Integer posY;

    public posObject(int a,int b){
        posX = a;
        posY = b;
    }

    public Integer getX() {
        return posX;
    }

    public Integer getY() {
        return posY;
    }

    public void setX(Integer newX) {
        posX = newX;
    }

    public void setY(Integer newY) {
        posY = newY;
    }
}