package com.remwaste.entity.strategy;

import com.github.javafaker.Faker;
import uk.co.jemos.podam.common.AttributeStrategy;

import java.lang.annotation.Annotation;
import java.util.List;

public class EmailStrategy implements AttributeStrategy<String> {

    private static final Faker FAKER = new Faker();

    @Override
    public String getValue(Class<?> aClass, List<Annotation> list) {
        return FAKER.internet().emailAddress();
    }
}
