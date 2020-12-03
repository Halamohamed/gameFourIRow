package se.ecutb.game;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GameIO {
    public static void save(List<PlayGame> games, Path path){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path.toFile()))){
            out.writeObject(games);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<PlayGame> read(Path path){
        List<PlayGame> playGames = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path.toFile()))){
            playGames = (List<PlayGame>) in.readObject();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playGames;
    }

}
