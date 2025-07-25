package com.remwaste.tests.web;

import com.remwaste.entity.LoginDetails;
import com.remwaste.pages.LoginPage;
import com.remwaste.tags.testtype.WebTest;
import com.remwaste.testdata.LoginTestData;
import com.remwaste.tests.base.WebTestSetup;

public class LoginTest extends WebTestSetup {

    private final LoginDetails loginDetails = LoginTestData.getValidLoginDetails();
    private final LoginDetails invalidLoginDetails = LoginTestData.getInvalidLoginDetails();

    @WebTest
    void testValidLogin() {
        LoginPage.getInstance()
                .validLogin(loginDetails)
                .verifyUserLoggedInSuccessfully(loginDetails.getUserName())
                .logout();
    }

    @WebTest
    void testInvalidLogin() {
        LoginPage.getInstance()
                .verifyInvalidCredentials(invalidLoginDetails);
    }
}
