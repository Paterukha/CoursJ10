package ua.goit.java8.module7.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    public static void writeToFile(String json, String path) throws IOException {
        //System.out.println("Saving data");
        FileWriter writer = new FileWriter(path);
        writer.write(json);
        writer.flush();
        writer.close();
    }

    public static String readFromFile(String path) throws IOException {
        //System.out.println("Loading data");
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String json = reader.readLine();
        return json;
    }
}
