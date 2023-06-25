package com.ccs.Beroeps_product;

import java.util.ArrayList;
import java.util.*;

public class The_Game_Hard {

    public static void main(String[] args) {

        ArrayList<String> card_1= new ArrayList<String>();
        card_1.add("A♥");
        card_1.add("K♦");
        card_1.add("Q♣");
        card_1.add("J♠");
        ArrayList<String> card_2= new ArrayList<String>();
        card_2.add("A♥");
        card_2.add("K♦");
        card_2.add("Q♣");
        card_2.add("J♠");
        ArrayList<String> card_3= new ArrayList<String>();
        card_3.add("A♥");
        card_3.add("K♦");
        card_3.add("Q♣");
        card_3.add("J♠");
        ArrayList<String> card_4= new ArrayList<String>();
        card_4.add("A♥");
        card_4.add("K♦");
        card_4.add("Q♣");
        card_4.add("J♠");


        Collections.shuffle(card_1);
        Collections.shuffle(card_2);
        Collections.shuffle(card_3);
        Collections.shuffle(card_4);

        System.out.println(card_1);
        System.out.println(card_2);
        System.out.println(card_3);
        System.out.println(card_4);

       /* System.out.println(cards);
        Collections.shuffle(cards);
        System.out.println(cards);

        String[][] board = new String[5][2];

        for (int z = 0; z < board.length; z++){

            for (String i : cards){
            System.out.print(i);
            }

        System.out.println(z);
        }*/
    }
}
