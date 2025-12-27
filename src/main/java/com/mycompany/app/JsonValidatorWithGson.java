package com.mycompany.app;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonValidatorWithGson {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Person> people = new ArrayList<>();

        try(
            FileReader jsonReader = new FileReader("person.json");
            FileReader jsonSchemaReader = new FileReader("person-schema.json");
            //* Cuando el fileReader termina de leer el documento se queda en la siguiente linea
            //* Por lo tanto debemos volver a leer el documento para poder aplicar correctamente
            //* el esquema
            FileReader jsonArrayReader = new FileReader("person.json");
        ) {
            Type listType = new TypeToken<List<Person>>() {}.getType();
            people = gson.fromJson(jsonReader, listType);

            //* Cargar el esquema como un JSON Object
            JSONObject schemaObject = new JSONObject(new JSONTokener(jsonSchemaReader));

            //* Cargar el esquema desde el JSONObject
            Schema schema = SchemaLoader.load(schemaObject);

            JSONArray peopleJsonArray = new JSONArray(new JSONTokener(jsonArrayReader));

            schema.validate(peopleJsonArray);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (Person person: people) {
            System.out.println(person.toString());
            System.out.println("-------------");
        }

        System.out.println("Archivo validado corerctamente");
    }
}
