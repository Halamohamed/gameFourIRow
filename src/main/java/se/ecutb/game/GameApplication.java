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


        /*System.out.println("enter how many you want to play: 1, 2, 3, 4, 5");
        play = read.nextInt();*/
        System.out.println("Välcommen till spelet Fyra I Rad ");
        PlayGame game = new PlayGame();


        game.start();


        game.list.forEach(g -> System.out.println(g.toString()));

    }

}
