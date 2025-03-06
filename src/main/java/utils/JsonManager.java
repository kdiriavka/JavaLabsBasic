package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveToJson(University university, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(university, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static University loadFromJson(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, University.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
