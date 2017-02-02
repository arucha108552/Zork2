package io.muic.ooc.thienthai.zork;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by thienthai on 2/3/17.
 */
public class Item{

    private String Name;
    public Integer posX;
    public Integer posY;
    public Integer Attk;
    public String type;
    public String description;

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Item(String nme, Integer POSx, Integer POSy, Integer attk, String tpe, String descrip){
        Name = nme;
        posX = POSx;
        posY = POSy;
        Attk = attk;
        type = tpe;
        description = descrip;
    }

    public String getName(){
        return Name;
    }
}
