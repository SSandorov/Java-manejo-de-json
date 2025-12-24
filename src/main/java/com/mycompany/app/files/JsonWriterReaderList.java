package com.mycompany.app.files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.app.Person;

public class JsonWriterReaderList {
    public static void main(String[] args) {
        Gson gson = new Gson();

        List<Person> people = new ArrayList<>();

        try(FileReader reader = new FileReader("person.json")) {
            //! Hay que memorizar esta definicion cuando queramos leer arreglos desde un Json
            //* TypeToken es una clase de GSON que se usa para mantener la informacion de los
            //* tipos genericos en tiempo de ejecucion
            //* Necesitamos hacerlo porque en tiempo de ejecucion se pierde el tipo de dato de
            //* la lista y GSON no lo reconoce. Por tanto, con esta definicion podemos aclarar
            //* que tipo de dato recibe
            Type listType = new TypeToken<List<Person>>() {}.getType();
            people = gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (Person person: people) {
            System.out.println(person.toString());
            System.out.println("-------------");
        }

        people.add(new Person("Fernando", 35, false));

        try(FileWriter write = new FileWriter("person.json")) {
            gson.toJson(people, write);
            System.out.println("Guardado con exito");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
