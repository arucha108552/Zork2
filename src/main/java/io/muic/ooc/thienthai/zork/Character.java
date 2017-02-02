package io.muic.ooc.thienthai.zork;

/**
 * Created by thienthai on 2/3/17.
 */
public class Character{


    private boolean isQuesactive;
    private boolean isQuesSucess;
    private String Quote;
    private String Name;
    private Integer xPos;
    private Integer yPos;

    public boolean isQuesSucess() {
        return isQuesSucess;
    }

    public Character(String Nme, Integer positionX, Integer positionY){
        isQuesactive = Boolean.FALSE;
        isQuesSucess = Boolean.FALSE;
        xPos = positionX;
        yPos = positionY;
        Name = Nme;

    }

    public void setxPos(int x){
        xPos = x;
    }

    public void setyPos(int y){
        yPos = y;
    }

    public Integer getxPos(){
        return xPos;
    }

    public Integer getyPos(){
        return yPos;
    }

    public String getName(){
        return Name;
    }

    public void setName(String Nme){
        Name = Nme;
    }

    public String getQuote(){
        return Quote;
    }

    public void setQuote(String set){
        Quote = set;
    }

    public void setQuestactive(Boolean set){
        isQuesactive = set;
    }

    public Boolean getQuestactive(){
        return isQuesactive;
    }

    public void setQuesactive(){

        isQuesactive = Boolean.TRUE;
    }

    public void setQuesSucess(Boolean set){
        isQuesSucess = set;
    }

}
