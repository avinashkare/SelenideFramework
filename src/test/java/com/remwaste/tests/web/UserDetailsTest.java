package com.remwaste.tests.web;

import com.remwaste.entity.LoginDetails;
import com.remwaste.entity.UserDetails;
import com.remwaste.pages.LoginPage;
import com.remwaste.tags.testtype.WebTest;
import com.remwaste.testdata.LoginTestData;
import com.remwaste.testdata.UserTestData;
import com.remwaste.tests.base.WebTestSetup;

public class UserDetailsTest extends WebTestSetup {

    private final LoginDetails loginDetails = LoginTestData.getValidLoginDetails();
    private final UserDetails userDetails = UserTestData.getValidUserDetails();

    @WebTest
    void editUserDetails() {
        LoginPage.getInstance()
                .validLogin(loginDetails)
                .verifyUserLoggedInSuccessfully(loginDetails.getUserName())
                .navigateToProfilePage()
                .verifyNavigationToProfilePage()
                .editUserInformation(userDetails);
    }
}
