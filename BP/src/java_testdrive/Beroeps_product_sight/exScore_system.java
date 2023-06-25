package java_testdrive.Beroeps_product_sight;

import java.sql.*;
import java.util.Scanner;

public class exScore_system {
    static final String URL = "jdbc:mysql://localhost/memory_game";
    static final String USER = "root";
    static final String PASS = "root";

    static int i = 0;
    static int j = 0;
    static int score;
    static Scanner src = new Scanner(System.in);

    public static void correctAnswer(){
        exScore_system.i += 1;
    }
    public static void falseAnswer(){
        exScore_system.j += 1;
    }
    public static void scoreAnswer(){
        /*1 matched card = 2p
        all matched = 3p + (10 - sum(false))*/
        System.out.println("false answers: " + exScore_system.j);
        System.out.println("correct answers:" + exScore_system.i);
        exScore_system.score = (exScore_system.i * 2) + ((10 - exScore_system.j)+3);
        System.out.println("Total score: " + score);
        ScoreCounter();
    }
    public static void ScoreCounter(){
        try (Connection conn = DriverManager.getConnection(URL,USER, PASS)
        ) {
            System.out.println("insert username: ");
            String input_name = src.nextLine();
            int scoreValue = exScore_system.score;
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
}
