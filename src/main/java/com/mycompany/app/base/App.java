package com.mycompany.app.base;

import com.google.gson.Gson;
import com.mycompany.app.Person;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Person person = new Person("Gabriel", 25, true);

        Gson gson = new Gson();

        String json = gson.toJson(person);

        System.out.println(json);

        json = """
        {
            "name":"Gabriel",
            "age":25,
            "student":true
        }
        """;

        Person person2 = gson.fromJson(json, Person.class);

        System.out.println("Nombre: " + person.getName());
        System.out.println("Edad: " + person.getAge());
        System.out.println("Es estudiante: " + person.getStudent());
    }
}
