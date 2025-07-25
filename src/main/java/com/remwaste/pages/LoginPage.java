package com.remwaste.pages;

import com.codeborne.selenide.SelenideElement;
import com.remwaste.entity.LoginDetails;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    LoginPage() {
    }

    public static LoginPage getInstance() {
        return new LoginPage();
    }

    private static final SelenideElement USERNAME = $(byId("username"));
    private static final SelenideElement PASSWORD = $(byId("password"));
    private static final SelenideElement SIGN_IN_BUTTON = $(withTagAndText("button", "Sign In"));
    private static final SelenideElement FORGOT_PASSWORD = $(withText("Forgot Password?"));
    private static final SelenideElement SIGN_UP = $(withText("Sign Up"));
    private static final SelenideElement INVALID_CREDENTIALS_MESSAGE = $(withText("The username or password you entered is incorrect"));

    public void loginToApplication(LoginDetails loginDetails) {
        USERNAME.shouldBe(visible, interactable).setValue(loginDetails.getUserName());
        PASSWORD.shouldBe(visible, interactable).setValue(loginDetails.getPassword());
        SIGN_IN_BUTTON.shouldBe(enabled).click();
    }

    public void loginToApplication(String userName, String password) {
        USERNAME.shouldBe(visible, interactable).setValue(userName);
        PASSWORD.shouldBe(visible, interactable).setValue(password);
        SIGN_IN_BUTTON.shouldBe(enabled).click();
    }

    public DashboardPage validLogin(LoginDetails loginDetails) {
        this.loginToApplication(loginDetails);
        return new DashboardPage();
    }

    public void verifyInvalidCredentials(LoginDetails loginDetails) {
        this.loginToApplication(loginDetails);
        INVALID_CREDENTIALS_MESSAGE.shouldBe(visible, textCaseSensitive("incorrect"));
    }

    public ForgotPasswordPage navigateToResetPasswordPage() {
        FORGOT_PASSWORD.shouldBe(interactable).click();
        return new ForgotPasswordPage();
    }

    public SignUpPage navigateToSignUpPage(){
        SIGN_UP.shouldBe(visible).click();
        return new SignUpPage();
    }
}