package io.muic.ooc.thienthai.zork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map{

    private int levelCleared;
    private ArrayList<Character> listChar = new ArrayList<Character>();
    private ArrayList<Item> listItem = new ArrayList<Item>();
    private ArrayList<Monster> listMonster = new ArrayList<Monster>();
    private ArrayList<LikedQuest> listLinkedQuest = new ArrayList<LikedQuest>();
    private Status player;
    private String[] map;
    private boolean insideStatus;

    public Map(int lvc,Status your){

        levelCleared = lvc;
        player = your;
        insideStatus = Boolean.FALSE;

        if(levelCleared == 1){
            String[] set = {
                    "=====######",
                    "=C  =    I#",
                    "=   =     #",
                    "=   =  M  #",
                    "#=DD=     #",
                    "#         #",
                    "#         #",
                    "#   M   =Q=",
                    "#       = =",
                    "#S      =C=",
                    "###########"
            };
            setMap(set);
            Character Einstein = new Character("Einstein",1,1);
            Character Plunk = new Character(    "Plunk",9,9);
            Einstein.setQuestactive(Boolean.FALSE);
            Plunk.setQuestactive(Boolean.FALSE);
            listChar.add(Einstein);
            listChar.add(Plunk);
            Item Handgun = new Item("Handgun",1,9,25,"weapon", "Normal gun high attack use for combat");
            listItem.add(Handgun);
            Monster Fatman = new Monster("Fatman",15,7,4,false,null);
            Monster littleBoy = new Monster("Little Boy",19,3,7,true,new Item("Cage Key",null,null,0,"questitem","Use this key to unlock the cage to free Plunk"));
            listMonster.add(Fatman);
            listMonster.add(littleBoy);
            LikedQuest PlunkHLP = new LikedQuest(Plunk,7,9,null);
            listLinkedQuest.add(PlunkHLP);


        }else if(levelCleared == 2){
            String[] set = {
                    "###########",
                    "#I       Q#",
                    "#===      #",
                    "#     M   #",
                    "#         #",
                    "#  M      #",
                    "#       M #",
                    "==Q=      #",
                    "=  =      #",
                    "= I= C S  #",
                    "====#######"
            };
            setMap(set);
            //public Monster(String nme, Integer attack, Integer posx, Integer posy, Boolean dropItem, Item item)
            //Item(String nme, Integer POSx, Integer POSy, Integer attk, String tpe, String descrip)
            Character darwin = new Character("Darwin",9,5);
            LikedQuest keyCardDoor = new LikedQuest(darwin,7,2,'D');
            LikedQuest Center = new LikedQuest(darwin,1,9,null);
            Monster Erectus = new Monster("Erectus",20,5,3,true,new Item("Passcode1",null,null,0,"questitem","A paper which contain number 3 in it"));
            Monster Naenderthal = new Monster("Naenderthal",25,3,6,true,new Item("Passcode2",null,null,0,"questitem", "A paper which contain number 5 in it"));
            Monster Sapiens = new Monster("Sapiens",30,6,8,true,new Item("Passcode3",null,null,0,"questitem","A paper which contain number 7 in it"));
            Item Chainsaw = new Item("Chainsaw",1,1,35,"weapon","Big chainsaw high attackrate destroy everything");
            Item keyCard = new Item("Key Card",9,2,0,"questitem","key card use to open the radiation center");
            listLinkedQuest.add(keyCardDoor);
            listLinkedQuest.add(Center);
            listChar.add(darwin);
            listMonster.add(Erectus);
            listMonster.add(Naenderthal);
            listMonster.add(Sapiens);
            listItem.add(Chainsaw);
            listItem.add(keyCard);
        }else if(levelCleared == 3){
            String[] set = {
                    "###########",
                    "#I    M  C#",
                    "#         #",
                    "#    M   S#",
                    "#         #",
                    "#         #",
                    "#      M  #",
                    "==Q=I     #",
                    "=  =      #",
                    "= I=     I#",
                    "====#######"
            };
            setMap(set);
            Character kroc = new Character("Kroc",1,9);
            listChar.add(kroc);
            Monster mcdonald = new Monster("mcdonald",1,6,7,true,new Item("radKeyCard",null,null,0,"questitem","The key card that use to open antidote room"));
            listMonster.add(mcdonald);
            listMonster.add(new Monster("mccarthy",1,1,6,false,null));
            listMonster.add(new Monster("mcintyre",1,3,5,false,null));
            listItem.add(new Item("paper1",1,1,0,"questitem","A paper which have a word 'french fries'"));
            listItem.add(new Item("paper2",7,4,0,"questitem","A paper which have a word 'cheese burger'"));
            listItem.add(new Item("paper3",9,9,0,"questitem","A paper which have a word 'Big Mac'"));
            listLinkedQuest.add(new LikedQuest(kroc,7,2,'D'));
            listItem.add(new Item("antidote",9,2,0,"questitem","A antidote"));
        }

    }

    public void setMap(String[] set){
        map = set;
    }

    public posObject getStartingPoint(){
        int count = 0;
        for(String i : map){
            for(int j = 0;j<i.length();j++){
                if(i.charAt(j) == 'S'){
                    return new posObject(count,j);
                }
            }
            count +=1;
        }
        return null;
    }

    public LikedQuest getLinkedQuestbyPos(Integer posX,Integer posY){
        for(LikedQuest linkedQuest:listLinkedQuest){
            if(linkedQuest.getPosX().equals(posX) && linkedQuest.getPosY().equals(posY)){
                return linkedQuest;
            }
        }
        return null;
    }

    public Monster getMonbyPos(Integer posX,Integer posY){
        for(Monster monster:listMonster){
            if(monster.getPosX().equals(posX) && monster.getPosY().equals(posY)){
                return monster;
            }
        }
        return null;
    }

    public Character getCharbyPos(Integer posX,Integer posY){
        for(Character chr:listChar){
            //System.out.println(posX+" "+posY);
            if(chr.getxPos().equals(posX) && chr.getyPos().equals(posY)){
                return chr;
            }
        }
        return null;
    }

    public Item getItembyPos(Integer posX,Integer posY){
        for(Item item:listItem){
            if(item.posX.equals(posX) && item.posY.equals(posY)){
                return item;
            }
        }
        return null;
    }

    public String[] getMap(){

        return map;
    }

    public void deleteChar(Integer xPos,Integer yPos){
        StringBuilder newOne = new StringBuilder(map[xPos]);
        newOne.setCharAt(yPos,' ');
        map[xPos] = newOne.toString();
    }


    public posObject verifyToken(Map map,posObject posOb,String token,Status youStat) throws IOException{
        if(map.getMap()[posOb.getX()].charAt(posOb.getY()) == '#'){
            System.out.println("I found the big giant wall I cannot pass");
            System.out.println("========================================");
            return chngToken(posOb,token);
        }else if(map.getMap()[posOb.getX()].charAt(posOb.getY()) == ' '){
            System.out.println("####  Sucessfully walk " + token + " ####");
            System.out.println("========================================");
            return posOb;
        }else if(map.getMap()[posOb.getX()].charAt(posOb.getY()) == '='){
            if(insideStatus == Boolean.FALSE) {
                System.out.println("you: I found some kind of wall I cannot pass but it look like a place to live it would have door somewhere here");
                System.out.println("========================================");
            }else{
                System.out.println("you: I found a wall I cant get through");
                System.out.println("========================================");
            }
            return chngToken(posOb,token);
        }else if(map.getMap()[posOb.getX()].charAt(posOb.getY()) == 'D'){
            if(insideStatus == Boolean.FALSE){
                System.out.println("Found a door do you want to get in (yes/no) :");
            }else{
                System.out.println("Found a door do you want to get out (yes/no) :");
            }
            Scanner read = new Scanner(System.in);
            if(insideStatus == Boolean.FALSE){
                insideStatus = Boolean.TRUE;
            }else if(insideStatus == Boolean.TRUE){
                insideStatus = Boolean.FALSE;
            }
            if(read.nextLine().toLowerCase().equals("yes")){
                System.out.println("### You already pass through door ###");
                System.out.println("========================================");
                if(token.toLowerCase().equals("up")){
                    posOb.setX(posOb.getX()-1);
                    return posOb;
                }else if(token.toLowerCase().equals("down")){
                    posOb.setX(posOb.getX()+1);
                    return posOb;
                }else if(token.toLowerCase().equals("left")){
                    posOb.setY(posOb.getY()-1);
                    return posOb;
                }else if(token.toLowerCase().equals("right")){
                    posOb.setY(posOb.getY()+1);
                    return posOb;
                }
            }else if(read.nextLine().toLowerCase().equals("no")){
                System.out.println("Im not going to this door");
                System.out.println(" ");
                System.out.println("========================================");
                System.out.println(" ");
                return chngToken(posOb,token);
            }else {
                System.out.println("Im not understand what I should do");
                System.out.println(" ");
                System.out.println("========================================");
                System.out.println(" ");
                return chngToken(posOb, token);
            }
        }else if(map.getMap()[posOb.getX()].charAt(posOb.getY()) == 'C'){
            Character myChar = getCharbyPos(posOb.getX(),posOb.getY());
            QuestFactory getQuest = new QuestFactory();
            getQuest.questStart(myChar,youStat,posOb);
            return chngToken(posOb,token);
        }else if(map.getMap()[posOb.getX()].charAt(posOb.getY()) == 'I'){
            System.out.println("you: This " + getItembyPos(posOb.getX(),posOb.getY()).getName() + " might be useful");
            System.out.println(" ");
            System.out.println("#### Get it or not (yes/no) ####");
            System.out.println(" ");
            Scanner read = new Scanner(System.in);
            if(read.nextLine().toLowerCase().equals("yes")){
                player.addInverntory(getItembyPos(posOb.getX(),posOb.getY()));
                deleteChar(posOb.getX(),posOb.getY());
                if(player.getIteminInventory2("antidote") == true){
                    player.setLvc(4);
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("### Contgratulation you already clear this game ###");
                    System.out.println("===================================================");
                }
                return chngToken(posOb,token);
            }else{
                System.out.println("I don't want to get this item");
                System.out.println("");
                return chngToken(posOb,token);
            }


        }else if(map.getMap()[posOb.getX()].charAt(posOb.getY()) == 'M'){

            Monster monster = getMonbyPos(posOb.getX(),posOb.getY());
            System.out.println("##### You found a Monster #####");
            System.out.println("");
            System.out.println("Name: "+monster.getName() + "| Attack Rate: "+ monster.getAttk());
            System.out.println(" ");
            System.out.println("##### Do you want to fight with it (yes/no)");
            Scanner read = new Scanner(System.in);
            if(read.nextLine().toLowerCase().equals("yes")){
                System.out.println("you: come on I will crush you");
                if(monster.getName().equals("mcintyre") || monster.getName().equals("mccarthy")){
                    System.out.println("Worm explode");
                    System.out.println("You got killed by "+ monster.getName());
                    System.out.println("#### GAME OVER ####");
                    player.setGameover(true);
                    System.out.println();
                    return null;
                }
                if(player.getAtk_Rate() > monster.getAttk()){
                    System.out.println("You have killed " + monster.getName());
                    deleteChar(posOb.getX(),posOb.getY());
                    if(monster.getDroppedItem()){
                        player.addInverntory(monster.getItemInMonster());
                    }
                    return chngToken(posOb,token);
                }else if(player.getAtk_Rate() < monster.getAttk()){
                    System.out.println("You got killed by "+ monster.getName());
                    System.out.println("#### GAME OVER ####");
                    player.setGameover(true);
                }else if(player.getAtk_Rate() == monster.getAttk()){
                    System.out.println("You and the monster cannot do anything to each other because the attacking rate are equal");
                    return chngToken(posOb,token);
                }
            }else if(read.nextLine().toLowerCase().equals("no")){
                System.out.println("you: I think I will not fight with it at this time");
                return chngToken(posOb,token);
            }else{
                System.out.println("you: I am not understand what I should do");
                return chngToken(posOb,token);
            }

        }else if(map.getMap()[posOb.getX()].charAt(posOb.getY()) == 'Q'){
            LikedQuest myChar = getLinkedQuestbyPos(posOb.getX(),posOb.getY());
            QuestFactory getQuest = new QuestFactory();
            getQuest.questStart(myChar.getLinkedChar(),youStat,posOb);
            if(posOb.getX().equals(7) && posOb.getY().equals(2) && myChar.getLinkedChar().isQuesSucess() == true && myChar.getLinkedChar().getName().equals("Darwin")) {
                StringBuilder newOne = new StringBuilder(getMap()[posOb.getX()]);
                newOne.setCharAt(posOb.getY(), 'D');
                getMap()[posOb.getX()] = newOne.toString();
            }else if(posOb.getX().equals(7) && posOb.getY().equals(2) && myChar.getLinkedChar().isQuesSucess() == true && myChar.getLinkedChar().getName().equals("Kroc")){
                StringBuilder newOne = new StringBuilder(getMap()[posOb.getX()]);
                newOne.setCharAt(posOb.getY(), 'D');
                getMap()[posOb.getX()] = newOne.toString();
            }
            return chngToken(posOb,token);
        }

        return null;
    }

    public posObject chngToken(posObject posOb,String token){
        if(token.toLowerCase().equals("up")){
            posOb.setX(posOb.getX()+1);
            return posOb;
        }else if(token.toLowerCase().equals("down")){
            posOb.setX(posOb.getX()-1);
            return posOb;
        }else if(token.toLowerCase().equals("left")){
            posOb.setY(posOb.getY()+1);
            return posOb;
        }else if(token.toLowerCase().equals("right")){
            posOb.setY(posOb.getY()-1);
            return posOb;
        }

        return null;
    }


}