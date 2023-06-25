package java_testdrive.Beroeps_product_sight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Pres 0 to exit
                Pres 1 to continue
                Pres 2 to open game info""");
        Scanner src = new Scanner(System.in);
        System.out.print("=> ");
        int UI = src.nextInt();

        switch (UI) {

            case 0 -> System.out.println("EXIT!!!");
            case 1 ->
                myn();
            case 2 -> {
                System.out.println("game info");
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
                Pres 3 to open settings""");
        Scanner src = new Scanner(System.in);
        System.out.print("=>");
        int UI = src.nextInt();

        switch (UI) {
            case 0 -> System.out.println("EXIT!!!");
            case 1 -> exLogin.insertData();
            case 2 -> exLogin.loginData();
            case 3 -> exLogin.settings();
        }
    }
}
