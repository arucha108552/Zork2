package io.muic.ooc.thienthai.zork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
    Help Einstein to find his friend Plunk and he will tell how to get
    antidote
    Help plunk from the prison get the key by defeat little boy
    # # # # # # # # # # #
    #C      #  M      I #
    #       #           #
    #       #           #
    # D D # #           #
    #               # Q #
    #     M         #   #
    # S             # C #
    # # # # # # # # # # #
    Darvin tell me to defeat all three monster to get the verification code to get id card and go in to the
    antidote radiation center
    # # # # # # # # # # #
    # I   # Q Q #   M   #
    # =                 #
    #         M         #
    # Q #               #
    #   #           M   #
    #   #               #
    # I # C   S         #
    # # # # # # # # # # #
    Issac seems to know which worm in this room keep the keycard to get antidote you
    you need to make sure you kill the right worm or else you will die
    french fries
    mc nugget
    double cheese burger
    big mac
    # # # # # # # # # # #
    # I         M     C #
    #      M            #
    #                 S #
    #    I              #
    # Q #       M       #
    #   # I           I #
    # # # # # # # # # # #
 */

public class startGame {

    public static void main(String[] args) throws IOException {

        // TEST FOR LVL1
        Integer level = 1;
        System.out.println("#### After the nuclear out break all of the people have died you have been crush by the bombing radiation ####");
        System.out.println("#### Luckily you still survive but still have radiation in your body you must find a way to get cured before you will be mutation ####");
        System.out.println("You: Oh how long did I passed out I have to find a way to get rid of my radiation");
        System.out.println("You: On the north is still have a living place and may be I can find someone to help me over there");
        Status myStatus = new Status(level);
        Map map = new Map(level,myStatus);
        posObject posOb = map.getStartingPoint();
        runLvl(posOb,map,myStatus,level);

        // TEST FOR LVL2
        level = 2;
        System.out.println("### After you know that the cure is in the radiation center you reach on the entrance ###");
        System.out.println("you: I have to find a way to get in there on my west side have someone there I should ask him");
        map = new Map(level,myStatus);
        posOb = map.getStartingPoint();
        runLvl(posOb,map,myStatus,level);

        // TEST FOR LVL3
        level = 3;
        System.out.println("you: finally im can access to radition center oh someone on the north side may be he can help me");
        map = new Map(level,myStatus);
        posOb = map.getStartingPoint();
        runLvl(posOb,map,myStatus,level);

    }

    public static void runLvl(posObject posOb,Map map,Status myStatus,Integer lvc) throws IOException {
        Scanner reader = new Scanner(System.in);
        String command;

        while (Boolean.TRUE && myStatus.getLvc() == lvc && myStatus.getGameover() == false) {
            System.out.println("Enter the command: ");
            command = reader.nextLine();
            if (command.toLowerCase().equals("up")) {
                System.out.println("you: I want to go up");
                posOb.setX(posOb.getX() - 1);
                map.verifyToken(map, posOb, command,myStatus);
            } else if (command.toLowerCase().equals("down")) {
                System.out.println("you: I want to go down");
                System.out.println(" ");
                posOb.setX(posOb.getX() + 1);
                map.verifyToken(map, posOb, command,myStatus);
            } else if (command.toLowerCase().equals("left")) {
                System.out.println("you: I want to go left");
                System.out.println(" ");
                posOb.setY(posOb.getY() - 1);
                map.verifyToken(map, posOb, command,myStatus);
            } else if (command.toLowerCase().equals("right")) {
                System.out.println("you: I want to go right");
                System.out.println(" ");
                posOb.setY(posOb.getY() + 1);
                map.verifyToken(map, posOb, command,myStatus);
            } else if (command.toLowerCase().equals("help")) {
                System.out.println("help");
                System.out.println(" ");
                BufferedReader br = new BufferedReader(new FileReader("readme-instruction.txt"));
                try {
                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();

                    while (line != null) {
                        sb.append(line);
                        sb.append(System.lineSeparator());
                        line = br.readLine();
                    }
                    String everything = sb.toString();
                    System.out.println(everything);
                } finally {
                    br.close();
                }
            } else if (command.toLowerCase().equals("exit")) {
                System.out.println("exit");
                System.out.println(" ");
                break;
            } else if (command.toLowerCase().equals("status")) {
                System.out.println("Your Attack Rate is: " + myStatus.getAtk_Rate());
                System.out.println(" ");
                System.out.println("###### This is your inventory ######");
                System.out.println(" ");
                if (myStatus.getInventory().isEmpty()) {
                    System.out.println("You not have anything in your inventory");
                    System.out.println(" ");
                }
                for (Item inven : myStatus.getInventory()) {
                    System.out.println("Weapon name: "+inven.getName() + "| Attack Rate: " + inven.Attk + " | Item type: " + inven.type + " | Description: " + inven.getDescription());
                }
                System.out.println("===================================");
                System.out.println(" ");
                System.out.println("###### This is your Ques list ######");
                System.out.println(" ");
                System.out.println(myStatus.getQueslist());
                System.out.println(" ");
                System.out.println("===================================");
                System.out.println("##### Your equiped weapon #####");
                if(myStatus.getEquipedWeapon() == null){
                    System.out.println("I don't have any equiped weapon");
                }else{
                    System.out.println(myStatus.getEquipedWeapon().getName());
                }
            }else if(command.toLowerCase().equals("equip")){
                System.out.println("What weapon you want to equip");
                command = reader.nextLine();
                myStatus.setEquipedWeapon(command);
            }else{
                System.out.println("you: I am not understand what I should do");
            }
        }
    }
}