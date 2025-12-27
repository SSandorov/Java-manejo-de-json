package com.mycompany.app;

import java.util.List;

public class Person {
    private String name;
    private Integer age;
    private Boolean student;
    private String email;
    private List<String> hobbies;
    
    public Person(String name, Integer age, Boolean student) {
        this.name = name;
        this.age = age;
        this.student = student;
    }

    public Person(String name, Integer age, Boolean student, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.student = student;
        this.hobbies = hobbies;
    }

    

    public Person(String name, Integer age, Boolean student, String email, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.student = student;
        this.email = email;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getStudent() {
        return student;
    }

    public void setStudent(Boolean student) {
        this.student = student;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", student=" + student + ", email=" + email + ", hobbies="
                + hobbies + "]";
    }

    
}
