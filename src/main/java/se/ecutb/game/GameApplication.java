package se.ecutb.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class GameApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GameApplication.class, args);
        Scanner read = new Scanner(System.in);

        FourIRow game = new FourIRow();

       while (!game.GameOver()){
           String player2, player1 = game.nextPlayer();
           System.out.println("Player1 : " + player1);

           //game.boardGame();
           System.out.println("set in a column ");
           for (int i = 1; i < 8; i++) {
               System.out.print( i + "  ");
           }
           int colP1 = read.nextInt();

           game.setIColumn(colP1-1, player1);

           player2 = game.nextPlayer();
           System.out.println("Player2 : " + player2);
           System.out.println("set in a column ");
           for (int i = 1; i < 8; i++) {
               System.out.print( i + "  ");
           }
           int colP2 = read.nextInt();

           game.setIColumn(colP2-1, player2);



           game.boardGame();
           System.out.println(game.winnerGame());



       }
        System.out.println("winner : " + game.winnerGame());



    }

}
