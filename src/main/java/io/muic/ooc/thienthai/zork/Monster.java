package io.muic.ooc.thienthai.zork;

public class Monster {
    private Integer attk;
    private Integer posX;
    private Integer posY;
    private String Name;
    private Boolean DroppedItem;
    private Item itemInMonster;

    public Monster(String nme, Integer attack, Integer posx, Integer posy, Boolean dropItem, Item item){
        Name = nme;
        setAttk(attack);
        setPosX(posx);
        setPosY(posy);
        DroppedItem = dropItem;
        itemInMonster = item;
    }

    public Integer getAttk() {
        return attk;
    }

    public void setAttk(Integer attk) {
        this.attk = attk;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Boolean getDroppedItem() {
        return DroppedItem;
    }

    public Item getItemInMonster() {
        return itemInMonster;
    }
}