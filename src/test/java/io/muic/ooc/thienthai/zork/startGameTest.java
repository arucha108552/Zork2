package io.muic.ooc.thienthai.zork;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.*;
import java.lang.Character;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by thienthai on 2/1/17.
 */
public class startGameTest {
    @Test
    public void test() throws IOException {
        /**
        //Test when we face the Big Wall '#'
         **/
        Map map = new Map(1,new Status(1));
        Status testStatus = new Status(1);
        startGame eqW = new startGame();
        posObject tesPosob = new posObject(9,1);
        tesPosob.setY(tesPosob.getY()-1);
        posObject newOne = map.verifyToken(map,tesPosob,"left",testStatus);
        assertTrue(newOne.getX() == 9 && newOne.getY() == 1);
        /**
        //Test when we meet with Character 'C'
         **/
        tesPosob = new posObject(2,1);
        tesPosob.setX(tesPosob.getX()-1);
        String data = "b"+"\na";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        newOne = map.verifyToken(map,tesPosob,"up",testStatus);
        assertTrue(newOne.getX() == 2 && newOne.getY() == 1);
        /**
        //Test when we find 'M'
         **/
        tesPosob = new posObject(7,3);
        tesPosob.setY(tesPosob.getY()+1);
        Item rand = new Item("blah",null,null,30,"weapon","testing");
        testStatus.addInverntory(rand);
        data = "equip" + "\nblah" + "\nexit";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        eqW.runLvl(tesPosob,map,testStatus,1);
        data = "yes";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        newOne = map.verifyToken(map,tesPosob,"right",testStatus);

        /**
        //Test If we pass the game or not by change the level of the character
         **/
        testStatus.setLvc(2);
        eqW.runLvl(tesPosob,map,testStatus,1);

        /**
        // Test get the Starting point
         **/
        String[] set = {
                "################S#######"
        };
        tesPosob = new posObject(0,16);
        map.setMap(set);
        posObject result = map.getStartingPoint();
        assertTrue(tesPosob.getX() == result.getX() && tesPosob.getY() == result.getY());

        /**
        //Test find each Object by Pos
         **/
        map = new Map(1,testStatus);
        io.muic.ooc.thienthai.zork.Character charName = map.getCharbyPos(1,1);
        Item itemName = map.getItembyPos(1,9);
        Monster monsterName = map.getMonbyPos(7,4);
        assertTrue(charName.getName().equals("Einstein") && itemName.getName().equals("Handgun") && monsterName.getName().equals("Fatman"));
        /**
        //Test equiped weapon
         **/
        assertTrue(testStatus.getEquipedWeapon().getName().equals("blah"));
        /**
        //Test Get the Item
         **/
        tesPosob = new posObject(1,8);
        tesPosob.setY(tesPosob.getY()+1);
        data = "yes";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        newOne = map.verifyToken(map,tesPosob,"right",testStatus);
        assertTrue(testStatus.getIteminInventory("Handgun") == true);




        /**
        //Test Get into the Door
         **/
        tesPosob = new posObject(5,2);
        tesPosob.setX(tesPosob.getX()-1);
        data = "yes";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        newOne = map.verifyToken(map,tesPosob,"up",testStatus);
        assertTrue(newOne.getX().equals(3) && newOne.getY().equals(2));




    }


}
