package com.remwaste.testdata;

import com.github.javafaker.Faker;
import com.remwaste.entity.LoginDetails;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class LoginTestData {

    private static final PodamFactory FACTORY = new PodamFactoryImpl();
    private static final Faker FAKER = new Faker();

    private LoginTestData() {
    }

    public static LoginDetails getValidLoginDetails() {
        return FACTORY.manufacturePojo(LoginDetails.class);
    }

    public static LoginDetails getInvalidLoginDetails() {
        LoginDetails details = new LoginDetails();
        details.setUserName(FAKER.name().username());
        details.setPassword(FAKER.internet().password(8, 16));
        return details;
    }
}
