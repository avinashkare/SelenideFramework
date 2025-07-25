package com.remwaste.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import com.remwaste.entity.UserDetails;

import static com.codeborne.selenide.ClickOptions.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SignUpPage {

    public SignUpPage() {
    }

    public static SignUpPage getInstance() {
        return new SignUpPage();
    }

    private static final SelenideElement SIGN_UP_HEADER = $(withTagAndText("h1", "Sign Up"));
    private static final SelenideElement USERNAME_FIELD = $(byId("username"));
    private static final SelenideElement FIRST_NAME_FIELD = $(byName("firstName"));
    private static final SelenideElement LAST_NAME_FIELD = $(byName("lastName"));
    private static final SelenideElement EMAIL_FIELD = $(byName("email"));
    private static final SelenideElement PASSWORD_FIELD = $(byName("password"));
    private static final SelenideElement CONFIRM_PASSWORD_FIELD = $(byName("confirmPassword"));
    private static final SelenideElement MOBILE_NUMBER_FIELD = $(byName("mobileNumber"));
    private static final SelenideElement NEXT_BUTTON = $x("//button[text()='Next']");
    private static final SelenideElement BACK_BUTTON = $x("//button[text()='Back']");
    private static final SelenideElement REGISTER_BUTTON = $x("//button[text()='Register']");
    private static final SelenideElement REGISTRATION_SUCCESS_MESSAGE = $(withText("Registration successful"));

    public SignUpPage verifyNavigationToSignUpPage() {
        SIGN_UP_HEADER.shouldHave(visible, textCaseSensitive("Sign Up"));
        return this;
    }

    public SignUpPage registerNewUser(UserDetails registerUserDetails) {
        USERNAME_FIELD.shouldBe(visible).setValue(registerUserDetails.getUsername());
        EMAIL_FIELD.shouldBe(visible).setValue(registerUserDetails.getEmail());
        PASSWORD_FIELD.shouldBe(visible).setValue(registerUserDetails.getPassword());
        CONFIRM_PASSWORD_FIELD.shouldBe(visible).setValue(registerUserDetails.getPassword());
        NEXT_BUTTON.shouldBe(visible, enabled).click(usingJavaScript());
        FIRST_NAME_FIELD.shouldBe(visible).setValue(registerUserDetails.getFirstName());
        LAST_NAME_FIELD.shouldBe(visible).setValue(registerUserDetails.getLastName());
        MOBILE_NUMBER_FIELD.shouldBe(visible).setValue(registerUserDetails.getMobileNumber());
        REGISTER_BUTTON.shouldBe(visible, enabled).click(usingJavaScript());
        return this;
    }

    public LoginPage verifyUserRegistrationSuccessful() {
        REGISTRATION_SUCCESS_MESSAGE.shouldHave(visible, textCaseSensitive("Registration successful"));
        return new LoginPage();
    }
}
