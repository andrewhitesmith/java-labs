package org.example.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.Human;
import org.example.model.Student;
import org.example.model.University;
import org.example.util.RuntimeTypeAdapterFactory;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    private final Gson gson;

    public JsonManager() {
        RuntimeTypeAdapterFactory<Human> adapterFactory = RuntimeTypeAdapterFactory
                .of(Human.class, "type")
                .registerSubtype(Human.class)
                .registerSubtype(Student.class);

        this.gson = new GsonBuilder()
                .registerTypeAdapterFactory(adapterFactory)
                .setPrettyPrinting()
                .create();
    }

    public void writeToFile(University university, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(university, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public University readFromFile(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            return gson.fromJson(reader, University.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
