package com.ccs.Beroeps_product;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TheGame {

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

        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        letters.add("F");
        letters.add("G");
        letters.add("H");
        letters.add("I");
        letters.add("J");

        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        letters.add("F");
        letters.add("G");
        letters.add("H");
        letters.add("I");
        letters.add("J");

        int index;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                index = random.nextInt(letters.size());
                cards[i][j] = letters.get(index);
                letters.remove(index);
            }
        }
    }

    public static boolean gameOver () {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j].equals(" 🎴 ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void checkInput (String[][]cards){
        while (true) {
            if (!gameOver()) {
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
                        printBoard();
                        System.out.println("Correct!");
                        Score_system.correctAnswer();
                    } else {
                        System.out.println();
                        printBoard();
                        System.out.println("False!");
                        board[row1 - 1][column1 - 1] = " 🎴 ";
                        board[row2 - 1][column2 - 1] = " 🎴 ";
                        Score_system.falseAnswer();
                    }
                }
            } else {
                System.out.println("Game over!!");
                Score_system.scoreAnswer();
                break;
            }
        }
    }

    public static void startMenu(){
        while (true){
            System.out.println(" press q to quit and n for new game");
            System.out.print(" => ");
            String ng = src.nextLine();
            if(ng.equals("q")){
                System.out.println("Exit");
                break;
            }else if(ng.equals("n")){
                TheGame.shuffleCards();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 5; j++) {
                        TheGame.board[i][j] = " 🎴 ";
                    }
                }
                TheGame.printBoard();
                TheGame.checkInput(TheGame.cards);
                break;
            }else {
                System.out.println("invalid character");
            }
        }
    }
}
