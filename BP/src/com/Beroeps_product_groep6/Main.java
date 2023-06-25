package com.Beroeps_product_groep6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Pres 0 to exit
                Pres 1 to continue
                Pres 2 to open game info / the top 3 players""");
        Scanner src = new Scanner(System.in);
        System.out.print("=> ");
        int UI = src.nextInt();

        switch (UI) {
            case 0 -> System.out.println("EXIT");

            case 1 ->
                myn();
            case 2 -> {
                System.out.println("game info");
                ScoreSystem.ScoreBoard();
                System.out.println("1. The deck consists of a 4x5 grid with 5 duplicates");
                System.out.println("2. Choose to open 2 cards by selecting the row and column");
                System.out.println("3. Try to guess all the matching cards");
                System.out.println();
                System.out.println("pres 1 to exit");
                System.out.println("pres 2 to go back");
                int oi = src.nextInt();
                if (oi == 1) {
                    System.out.println("EXIT!!!");
                } else if (oi ==2) {
                    myn();
                }
            }
        }
    }
    public static void myn(){
        System.out.println("""
                Pres 0 to exit
                Pres 1 to create new user
                Pres 2 to login
                Pres 3 to change user data""");
        Scanner src = new Scanner(System.in);
        System.out.print("=>");
        int UI = src.nextInt();

        switch (UI) {
            case 0 -> {
                System.out.println("EXIT!!!");
                break;
            }
            case 1 -> Login.insertData();
            case 2 -> Login.loginData();
            case 3 -> Login.settings();
        }
    }
}
