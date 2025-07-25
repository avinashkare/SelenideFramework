package com.remwaste.tests.base;

import com.remwaste.config.FrameworkConfig;
import com.remwaste.config.factory.ConfigFactory;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class ApiTestSetUp extends TestSetup {

    private static final FrameworkConfig CONFIG = ConfigFactory.config();

    @BeforeEach
    void apiSetUp() {
        RestAssured.baseURI = CONFIG.apiBaseUrl();
    }
}