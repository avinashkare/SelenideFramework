package com.remwaste.utils;

import com.github.javafaker.Faker;

public class Utilities {

    private static final Faker FAKER = new Faker();

    public static String generateEmail() {
        return FAKER.internet().emailAddress();
    }
}
