package com.Beroeps_product_groep6;

import java.sql.*;
import java.util.Scanner;

public class ScoreSystem {
    static final String URL = "jdbc:mysql://localhost/memory_game";
    static final String USER = "root";
    static final String PASS = "root";

    static int i = 0;
    static int j = 0;
    static int score;
    static Scanner src = new Scanner(System.in);
    //Score points for matched cards
    public static void correctAnswer(){
        ScoreSystem.i += 1;
    }
    //Score points for unmatched cards
    public static void falseAnswer(){
        ScoreSystem.j += 1;
    }
    //Total score
    public static void scoreAnswer(){
        /*1 matched card = 2p
        all matched = 3p + (10 - sum(false))*/
        System.out.println("false answers: " + ScoreSystem.j);
        System.out.println("correct answers:" + ScoreSystem.i);
        ScoreSystem.score = (ScoreSystem.i * 2) + ((10 - ScoreSystem.j)+3);
        System.out.println("Total score: " + score);
        ScoreCounter();
    }
    //Send score to database
    public static void ScoreCounter(){
        try (Connection conn = DriverManager.getConnection(URL,USER, PASS)
        ) {
            System.out.println("insert username: ");
            String input_name = src.nextLine();
            int scoreValue = ScoreSystem.score;
            String sql = "INSERT INTO game_info (user_id,user_score) " +
                    "SELECT user_id,? FROM User_info WHERE user_name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, scoreValue);
            pstmt.setString(2, input_name);
            pstmt.executeUpdate();
            System.out.println();
            System.out.println(" Successfully added score to record!");
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    //Shows score of the top 10 players
    public static void ScoreBoard(){
        try (Connection conn = DriverManager.getConnection(URL,USER, PASS)
        ) {
            String sql = "SELECT gam.user_score, gam.user_id, us.user_name " +
                    "FROM game_info gam " +
                    "JOIN User_info us on gam.user_id = us.user_id " +
                    "ORDER BY gam.user_score DESC LIMIT 10";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("id|     User name   |Score  ");
            while(rs.next()){
                int scoreBoard = rs.getInt("user_score");
                int userId = rs.getInt("user_id");
                String userName = rs.getNString("user_name");
                System.out.println(userId+"        "+userName+"        "+scoreBoard);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
