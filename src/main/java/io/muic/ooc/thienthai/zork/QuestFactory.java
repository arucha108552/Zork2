package io.muic.ooc.thienthai.zork;

import java.util.Scanner;

public class QuestFactory {
    public QuestFactory() {
    }

    public void questStart(Character yourChar, Status yourStatus, posObject poOb) {
        Scanner pause = new Scanner(System.in);
        Scanner read = new Scanner(System.in);
        String pauseRead;
        String read2;
        if (yourChar.getName().equals("Einstein")) {
            if (yourChar.getQuestactive().equals(Boolean.FALSE)) {
                System.out.println("Einstein: Who are you why are you here what do you want");
                System.out.println(" ");
                System.out.println("#### Please select your choice to answer a b ####");
                System.out.println("a. Please I need to find an antidote to cure me from radiation do you know where can I get it");
                System.out.println("b. You look so furious do you have any problem");
                System.out.println("Type in your number: ");
                read2 = read.nextLine();
                if (read2.equals("a")) {
                    System.out.println("Einstein: I cannot help you now I have other thing to do get lost..!!");
                } else if (read2.equals("b")) {
                    System.out.println("Einstein: My friend Plunk have been capture by the mutant");
                    System.out.println("#### Please select your choice to answer a b ####");
                    System.out.println("a. Ok calm down I can help you to get my friend back");
                    System.out.println("b. Sorry to hear that hope your friend will be safe");
                    //read = new Scanner(System.in);
                    read2 = read.nextLine();
                    if (read2.equals("a")) {
                        System.out.println("Einstein: Really..!! great I heard that he was captured on the south east of my house");
                        System.out.println("Einstein: I need him back he is my best friend here is the only weapon that I have");
                        System.out.println("### Knife have been added in your inventory you can start using it by use the command 'equip' and type the name of your weapon ###");
                        yourStatus.addInverntory(new Item("Knife", null, null, 17, "weapon", "Normal knife use veru sharp easy to use"));
                        yourChar.setQuestactive(Boolean.TRUE);
                        yourStatus.setQueslist(yourChar.getName());
                    } else if (read2.equals("b")) {
                        return;
                    }
                } else {
                    System.out.println(" ");
                    System.out.println("Einstein: I don't understand what you mean");
                    System.out.println("press enter...");
                    pauseRead = pause.nextLine();
                    return;
                }

            } else if (yourChar.getQuestactive().equals(Boolean.TRUE)) {
                if (yourStatus.getIteminInventory("Plunk Massage")) {
                    System.out.println("Einstein: Thank god my friend is already safe thank you very much");
                    System.out.println("Einstein: As an exchange I will tell you everything that you want to know");
                    System.out.println("#### Please select your choice to answer a b ####");
                    System.out.println("a. I want to know where can I get radiation cure can you tell me?");
                    System.out.println("b. Thats all right I just want to help you");
                    read2 = read.nextLine();
                    if (read2.equals("a")) {
                        System.out.println("Umm...I think you have to go radiation center. I've heard before nuclear war. We try to develop an anti" +
                                " radiation. That the best place for you to try your luck. I cannot think of anything else");
                        System.out.println("It have a lot of mutant around that center so be careful GOOD LUCK...!!!");
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("YOU HAVE COMPLETED LEVEL 1");
                        System.out.println("===============================================");
                        yourStatus.setLvc(2);
                        return;
                    } else {
                        System.out.println("Einstein: Ok see you later");
                        return;
                    }
                } else {
                    System.out.println("Einstein: Go find him what do you waiting for...!!!");
                    pause = new Scanner(System.in);
                    System.out.println("press enter...");
                    return;
                }
            }
        } else if (yourChar.getName().toLowerCase().equals("plunk")) {
            if (yourStatus.getQueslist().containsKey("Einstein") && !yourChar.getQuestactive()) {
                System.out.println("Plunk: Help me anybody here");
                System.out.println("### Please select your choice a b ###");
                System.out.println("a. Are you Plunk Einstein ask me to find you");
                System.out.println("b. Ignored him");
                read2 = read.nextLine();
                if (read2.equals("a")) {
                    System.out.println("Plunk: Thank god..!! I thought im gonna die here");
                    System.out.println("Plunk: I got caught by mutant name Little boy when I try to fight him");
                    System.out.println("Plunk: Can you help me the key is with Little Boy you need to get it from him");
                    System.out.println("### Type in the number that you want to response a b ###");
                    System.out.println("a. Hang in there I will get the key for you");
                    System.out.println("b. That is your problem now I can't fight with him Im out");
                    read2 = read.nextLine();
                    if (read2.equals("a")) {
                        System.out.println("Plunk: Great Im counting on you");
                        System.out.println("Plunk: By the way I put my weapon on the north side of your position" +
                                " it will help you to defeat Little Boy for sure and the Little boy is staying around near" +
                                " my weapon don't let him get it");
                        yourChar.setQuestactive(Boolean.TRUE);
                    } else {

                        System.out.println("T_T");
                        pauseRead = pause.nextLine();
                        return;

                    }
                } else {
                    return;
                }
            } else if (yourChar.getQuestactive() == Boolean.TRUE) {
                for (Item item : yourStatus.getInventory()) {
                    if (item.getName().equals("Cage Key")) {
                        System.out.println("Plunk: Thank you very much I thought im gonna die here");
                        System.out.println("Plunk: Take this message to Einstein so he will know that i am safe now. See you later");
                        System.out.println("### 'Plunk Massage have been added to your inventory'");
                        yourChar.setQuesSucess(Boolean.TRUE);
                        yourStatus.addInverntory(new Item("Plunk Massage", null, null, 0, "questitem", "Get this message to Einstein so he will know that Pluck is safe"));
                        return;
                    }
                }
                System.out.println("Plunk: Help me find the key from little boy. I put my weapon on the north side of your position" +
                        " it will help you to defeat Little Boy for sure and the Little boy is staying around near" +
                        " my weapon don't let him get it");
                return;
            }
        }

        if (yourChar.getName().equals("Darwin") && poOb.getX().equals(9) && poOb.getY().equals(5)) {

            if (yourChar.getQuestactive() == false) {
                System.out.println("Darwin: This place is surround by mutant run...!!");
                System.out.println("### Please select your answer choice a or b ###");
                System.out.println("a. Help help somebody help us");
                System.out.println("b. Hey..!! calm down I need to get in to the center is it have anyway to be in there");
                read2 = read.nextLine();
                if (read2.equals("b")) {
                    System.out.println("Darwin: Im afraid that it would be impossible the mutant already control the center");
                    System.out.println("Darwin: The only way to get in the center by getting the key card from the lab and bring it to the center which locate on the north east side");
                    System.out.println("Darwin: You must get the clue from I think they keep all the password the pass word is 3 digit and it separate to each mutant");
                    System.out.println("Darwin: The monster located zero to six step to the north");
                    System.out.println("Darwin: I leave my weapon on the north west side. I gotta go now good luck");
                    yourChar.setQuestactive(true);
                } else {
                    return;
                }
            } else if (yourChar.getQuestactive() == true && poOb.getX().equals(9) && poOb.getY().equals(5)) {
                System.out.println("Darwin: Just get out of here it is impossible to get in to the center");
                System.out.println("press enter...");
            }
        } else if (yourChar.getName().equals("Darwin") && poOb.getX().equals(7) && poOb.getY().equals(2)) {

            if (yourChar.getQuestactive() == true) {
                System.out.println("you: This seems to be the lab for key card I need to type in three digit password");
                System.out.println("### Please type 3 digit password ###");
                read2 = read.nextLine();
                if (read2.length() == 3) {
                    try {

                        if (Integer.parseInt(read2) == 573) {
                            System.out.println("### Your password is correct you can go into the room ###");
                            yourChar.setQuesSucess(true);
                        } else {
                            System.out.println("### Your password is wrong ###");
                        }

                    } catch (Exception e) {
                        System.out.println("### Your password is wrong ###");
                    }
                } else {
                    System.out.println("### Your password is wrong ###");
                }
            } else {
                System.out.println("This seems to be somekind of electric pad");
            }
        } else if (yourChar.getName().equals("Darwin") && poOb.getX().equals(1) && poOb.getY().equals(9)) {
            if (yourStatus.getIteminInventory("Key Card") == true) {
                System.out.println("### You can access to the radiation center");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("YOU HAVE COMPLETED LEVEL 2");
                System.out.println("===============================================");
                yourStatus.setLvc(3);
            } else {
                System.out.println("you: This is the radiation center I have to find a way to get in");
            }
        } else if (yourChar.getName().equals("Kroc")) {
            if (yourChar.getQuestactive() == false) {
                System.out.println("Kroc: So disgusting these mutant worm trying to get through antidote room");
                System.out.println(" ");
                System.out.println("### Please select your choice to answer a or b ###");
                System.out.println("a. I need to get a radiation cure could you help me please");
                System.out.println("b. Argh..!! I hate worm i am gonna throw up");
                read2 = read.nextLine();
                if (read2.equals("a")) {
                    System.out.println("Kroc: I need that too but the thing is I don't know which worm is keep the key card");
                    System.out.println("Kroc: This worm is very sensitive it will explode when you trying to attack them");
                    System.out.println("Kroc: You need to find a right worm to kill and you will get the key card");
                    System.out.println("Kroc: After you get the key card you use that to open the door in the south west side");
                    yourChar.setQuestactive(true);
                } else {
                    System.out.println("Kroc: Go away don't throw up in front of me");
                }
            } else if (yourChar.getQuestactive() == true && poOb.getX().equals(9) && poOb.getY().equals(1)) {
                System.out.println("Kroc: Can you get it or not or you just scared of worms");
            } else if (yourChar.getQuestactive() == true && poOb.getX().equals(7) && poOb.getY().equals(2)) {
                if (yourStatus.getIteminInventory("radKeyCard")) {
                    System.out.println("### Antidote Room is open get the cure in this room ###");
                    yourChar.setQuesSucess(true);
                }
            } else if (yourChar.getQuestactive() == false && poOb.getX().equals(7) && poOb.getY().equals(2)) {
                System.out.println("you: its look like some kind of medicine room look like many cure is keep in here");
            }
        }
    }
}