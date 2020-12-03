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



        System.out.println("Välcommen till spelet Fyra I Rad ");

        PlayGame game = new PlayGame();


        game.start();

        if(game.gameOver()){
            System.out.println("spelet vinnare ");
            for (int i = 0; i < game.list.size(); i++) {
                System.out.println(i + " " + game.list.get(i));
            }
        }


    }

}
