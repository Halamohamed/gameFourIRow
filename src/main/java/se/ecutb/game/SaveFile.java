package se.ecutb.game;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaveFile {
    public static List<String> stringList;
    public static final File FILE = new File("textFile/games.txt");

    public SaveFile() {
        stringList = new ArrayList<>();
    }

    public static void writeText(File file, List<String> games) {
        Date date = new Date();
        try (FileWriter writer = new FileWriter(file,true)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            for (String s : games) {
                writer.append( ('\n'));
                writer.write("h: " + date.getHours()+ " m: " + date.getMinutes() + " sec: " + date.getSeconds()+ " " +s);
                System.out.println();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readText(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String i;
            while ((i = reader.readLine()) != null) {
                String  letter =  i;
                  stringList.add(letter);
                System.out.println(letter);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








}
