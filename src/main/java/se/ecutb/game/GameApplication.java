package se.ecutb.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static se.ecutb.game.SaveFile.FILE;
import static se.ecutb.game.SaveFile.readText;


@SpringBootApplication
public class GameApplication {
   // File file = new File("textFile/games.txt");

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GameApplication.class, args);


        List<String> list = new ArrayList<>();

        System.out.println("Välcommen till spelet Fyra I Rad ");

        PlayGame game = new PlayGame();



        game.start();

        list.add(game.winnerGame() + " " + game.winner + game);

            System.out.println("spelet vinnare ");
            /*for (int i = 0; i < list.size(); i++) {
                System.out.println(i + " " +readText(file));
            }*/
        System.out.println(SaveFile.readText(FILE));




    }

}
