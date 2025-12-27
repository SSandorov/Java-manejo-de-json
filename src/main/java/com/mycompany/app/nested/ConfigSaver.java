package com.mycompany.app.nested;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConfigSaver {
    public static void saveConfig(AppConfig config, String filePath) {
        //* GsonBuilder permite configuran el JSON antes de crearlo, y el setPrettyPrinting
        //* anade los saltos de linea y las tabulaciones
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(config, writer);
            System.out.println("Configuracion guardada");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        AppConfig config = ConfigLoader.loadConfig("config.json");

        if (config != null) {
            config.getSettings().setTheme("light");
            saveConfig(config, "config.json");
        }
    }
}
