package com.remwaste.tests.web;

import com.remwaste.pages.LoginPage;
import com.remwaste.tags.testtype.WebTest;
import com.remwaste.tests.base.WebTestSetup;
import com.remwaste.utils.Utilities;

public class ResetPasswordTest extends WebTestSetup {

    @WebTest
    void testForgotPassword() {
        LoginPage.getInstance()
                .navigateToResetPasswordPage()
                .verifyNavigationToResetPasswordPage()
                .sendResetPasswordInstructions(Utilities.generateEmail());
    }

}
