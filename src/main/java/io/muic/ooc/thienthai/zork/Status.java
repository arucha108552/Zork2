package io.muic.ooc.thienthai.zork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Status {
    private ArrayList<Item> Inventory = new ArrayList<Item>();
    private Integer Atk_Rate;
    private HashMap<String, Boolean> Queslist = new HashMap<String, Boolean>();
    private Item EquipedWeapon;
    private Integer lvc;
    private Boolean isGameover;

    public Status(Integer level){
        EquipedWeapon = null;
        setLvc(level);
        isGameover = false;
    }

    public boolean getIteminInventory(String name) {
        Item thisItem = null;
        for (Item myItem : Inventory) {
            if (myItem.getName().toLowerCase().equals(name.toLowerCase())) {
                thisItem = myItem;
                return true;
            }
        }
        if (thisItem == null) {
            System.out.println("cant find this Item");
            return false;
        }
        return Boolean.parseBoolean(null);
    }

    public boolean getIteminInventory2(String name) {
        Item thisItem = null;
        for (Item myItem : Inventory) {
            if (myItem.getName().toLowerCase().equals(name.toLowerCase())) {
                thisItem = myItem;
                return true;
            }
        }
        if (thisItem == null) {
            return false;
        }
        return Boolean.parseBoolean(null);
    }

    public Item getEquipedWeapon() {
        return EquipedWeapon;
    }

    public void setLvc(Integer lvc) {
        this.lvc = lvc;
    }

    public Integer getLvc() {
        return lvc;
    }

    public Boolean getGameover() {
        return isGameover;
    }

    public void setGameover(Boolean gameover) {
        isGameover = gameover;
    }

    public void setEquipedWeapon(String equip) {
        Item thisItem = null;
        Scanner pause = new Scanner(System.in);
        for (Item myItem : Inventory) {
            if (myItem.getName().toLowerCase().equals(equip.toLowerCase())) {
                thisItem = myItem;
            }
        }
        if (thisItem == null) {
            System.out.println("cant find this weapon");
            return;
        } else if (thisItem.getType().equals("weapon")) {
            EquipedWeapon = thisItem;
            System.out.println("You have equiped " + equip);
        }
    }

    public void setQueslist(String name) {
        Queslist.put(name, Boolean.TRUE);
    }

    public HashMap<String, Boolean> getQueslist() {
        return Queslist;
    }

    public Integer getAtk_Rate() {
        if (EquipedWeapon == null) {
            return 10;
        } else {
            return EquipedWeapon.Attk;
        }
    }

    public void setAtk_Rate(Integer atk_rate) {
        Atk_Rate = atk_rate;
    }

    public ArrayList<Item> getInventory() {
        return Inventory;
    }

    public void addInverntory(Item additem) {
        System.out.println(additem.getName() + " have been added to your inventory");
        Inventory.add(additem);
    }
}