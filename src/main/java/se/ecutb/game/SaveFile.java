package se.ecutb.game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveFile {
    //public static final String TEXTID = "text_id";
    private static List<String> stringList;
    public static final File FILE = new File("textFile/games.txt");

    public SaveFile() {
        stringList = new ArrayList<>();
    }

    public static void writeText(File file, List<String> strings) {
        try (FileWriter writer = new FileWriter(file)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            writer.append("Hello");
            for (String s : strings) {
                writer.write(s);
                System.out.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String readText(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        //Properties properties = new Properties();
        try (FileReader reader = new FileReader(file)) {
            int i;
            while ((i = reader.read()) != -1) {
                char letter = (char) i;
                stringBuilder.append(letter);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }








}
