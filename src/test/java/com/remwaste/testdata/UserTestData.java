package com.remwaste.testdata;

import com.github.javafaker.Faker;
import com.remwaste.entity.LoginDetails;
import com.remwaste.entity.UserDetails;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class UserTestData {

    private static final PodamFactory FACTORY = new PodamFactoryImpl();

    private UserTestData() {
    }

    public static UserDetails getValidUserDetails() {
        return FACTORY.manufacturePojo(UserDetails.class);
    }

}
