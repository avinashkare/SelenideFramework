package com.remwaste.tests.web;

import com.remwaste.entity.LoginDetails;
import com.remwaste.entity.UserDetails;
import com.remwaste.pages.LoginPage;
import com.remwaste.tags.testtype.WebTest;
import com.remwaste.testdata.LoginTestData;
import com.remwaste.testdata.UserTestData;
import com.remwaste.tests.base.WebTestSetup;

public class RegisterUserTest extends WebTestSetup {

    private final UserDetails userDetails = UserTestData.getValidUserDetails();

    @WebTest
    void testUserRegistration() {
        LoginPage.getInstance()
                .navigateToSignUpPage()
                .verifyNavigationToSignUpPage()
                .registerNewUser(userDetails)
                .verifyUserRegistrationSuccessful()
                .loginToApplication(userDetails.getUsername(), userDetails.getPassword());
    }
}
