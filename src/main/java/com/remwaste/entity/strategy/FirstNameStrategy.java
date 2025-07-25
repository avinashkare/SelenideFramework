package com.remwaste.entity.strategy;

import com.github.javafaker.Faker;
import uk.co.jemos.podam.common.AttributeStrategy;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.IntStream;

public class FirstNameStrategy implements AttributeStrategy<String> {
    private static final Faker FAKER = new Faker();

    @Override
    public String getValue(Class<?> aClass, List<Annotation> list) {
       return FAKER.name().firstName();
    }
}
