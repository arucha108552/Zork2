package io.muic.ooc.thienthai.zork;

/**
 * Created by thienthai on 2/3/17.
 */
public class LikedQuest{

    private Character linkedChar;
    private int posX;
    private int posY;
    private java.lang.Character chngChar;

    public Character getLinkedChar() {
        return linkedChar;
    }

    public Integer getPosX() {
        return posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public java.lang.Character getChngChar() {
        return chngChar;
    }

    public LikedQuest(Character link, int posx, int posy, java.lang.Character chng){
        linkedChar = link;
        posX = posx;
        posY = posy;
        chngChar = chng;
    }

}
