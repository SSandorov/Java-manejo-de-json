package com.mycompany.app.files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.mycompany.app.Person;

public class JsonWriter {
    public static void main(String[] args) {
        Person person = new Person("Juan", 25, true);

        Gson gson = new Gson();

        try(FileWriter write = new FileWriter("person.json")) {
            gson.toJson(person, write);
            System.out.println("La persona fue guardada con exito");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try(FileReader reader = new FileReader("person.json")) {
            Person personJson = gson.fromJson(reader, Person.class);
            System.out.println(personJson);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("App finalizada");
    }
}
