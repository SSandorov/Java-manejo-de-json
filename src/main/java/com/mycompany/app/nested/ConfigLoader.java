package com.mycompany.app.nested;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConfigLoader {

    public static AppConfig loadConfig(String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, AppConfig.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        
    }
}
