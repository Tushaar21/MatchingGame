package com.Beroeps_product_groep6;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TheGameHard {

    public static String[][] board = new String[4][5];
    public static String[][] cards = new String[4][5];
    public static Scanner src = new Scanner(System.in);

    public static void printBoard() {

        for (int i = 0; i < 4; i++) {
            System.out.print("");
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j]);
                System.out.print("");
            }
            System.out.println();
        }
    }

    public static void shuffleCards() {
        Random random = new Random();
        ArrayList<String> letters = new ArrayList<>();

        letters.add("🐕‍🦺");
        letters.add("🐤");
        letters.add("🌵");
        letters.add("💀");
        letters.add("🦅");
        letters.add("🌺");
        letters.add("🎯");
        letters.add("🍔");
        letters.add("🍦");
        letters.add("🎃");

        letters.add("🐕‍🦺");
        letters.add("🐤");
        letters.add("🌵");
        letters.add("💀");
        letters.add("🦅");
        letters.add("🌺");
        letters.add("🎯");
        letters.add("🍔");
        letters.add("🍦");
        letters.add("🎃");

        int index;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                index = random.nextInt(letters.size());
                cards[i][j] = letters.get(index);
                letters.remove(index);
            }
        }
    }

    public static void checkInput(String[][] cards) {
        int False = 0;
        while (true) {
            if (False < 10) {
                    System.out.print("row-1 : ");
                    int row1 = src.nextInt();
                    System.out.print("column-1 : ");
                    int column1 = src.nextInt();

                    if (!board[row1 - 1][column1 - 1].equals(" 🎴 ")) {
                        System.out.println("Already entered!!!");
                        System.out.println();

                        printBoard();
                        continue;
                    } else {
                        board[row1 - 1][column1 - 1] = " " + cards[row1 - 1][column1 - 1] + " ";
                        printBoard();
                    }

                    System.out.print("row-2 : ");
                    int row2 = src.nextInt();
                    System.out.print("column-2 : ");
                    int column2 = src.nextInt();

                    if (!board[row2 - 1][column2 - 1].equals(" 🎴 ")) {
                        System.out.println("Already entered!!!");
                        board[row1 - 1][column1 - 1] = " 🎴 ";
                        System.out.println();

                        printBoard();
                    } else {
                        board[row2 - 1][column2 - 1] = " " + cards[row2 - 1][column2 - 1] + " ";
                        printBoard();

                        if (board[row1 - 1][column1 - 1].equals(board[row2 - 1][column2 - 1])) {
                            System.out.println();
                            printBoard();
                            System.out.println("Correct!");
                            ScoreSystem.correctAnswer();
                        } else {
                            System.out.println();
                            printBoard();
                            System.out.println("False!");
                            board[row1 - 1][column1 - 1] = " 🎴 ";
                            board[row2 - 1][column2 - 1] = " 🎴 ";
                            False = False + 1;
                            ScoreSystem.falseAnswer();
                        }

                }

            }else{
            System.out.println("Game over!!");
            ScoreSystem.scoreAnswer();
            TheGameHard.gameMode();
            }
        }
    }

    public static void startMenu(){
        while (true){
            System.out.println(" press e to exit and n for new game");
            System.out.print(" => ");
            Scanner scr = new Scanner(System.in);
            String ng = scr.nextLine();
            if(ng.equals("e")){
                System.out.println("Exit");
            }else if(ng.equals("n")){
                shuffleCards();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 5; j++) {
                        TheGameHard.board[i][j] = " 🎴 ";
                    }
                }
                printBoard();
                checkInput(TheGameHard.cards);
                break;
            }else {
                System.out.println("invalid character");
            }
        }
    }

    public static void gameMode(){
        System.out.println("Welcome to the Memory game");
        System.out.println("choose a mode \n pres 1 to play the default mode \n pres 2 to play the difficult mode ");
        int input = src.nextInt();
        switch (input){
            case 1: TheGameDefault.startMenu();
            case 2: TheGameHard.startMenu();
        }
    }
}


