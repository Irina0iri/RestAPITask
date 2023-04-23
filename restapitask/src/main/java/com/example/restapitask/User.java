package com.example.restapitask;

import lombok.Data;

@Data
public class User {
    String firstName;
    String lastName;
    int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName is '" + firstName + '\'' +
                ", lastName is '" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
