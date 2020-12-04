package se.ecutb.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class GameApplication {
   // File file = new File("textFile/games.txt");

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GameApplication.class, args);


        List<String> list = new ArrayList<>();

        System.out.println("Välkommen till spelet Fyra I Rad: " +
                "\n Du får placera dina marker vertikalt, horisontellt eller diagonalt!");

        PlayGame game = new PlayGame();
        game.start();

        list.add(game.winnerGame() + " " + game.winner + game);

            System.out.println("spelet vinnare " + list);




    }

}
