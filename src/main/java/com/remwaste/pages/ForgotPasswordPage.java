package com.remwaste.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {

    ForgotPasswordPage() {
    }

    public static ForgotPasswordPage getInstance() {
        return new ForgotPasswordPage();
    }

    private static final SelenideElement EMAIL = $(byAttribute("type", "email"));
    private static final SelenideElement FORGOT_PASSWORD_LABEL = $(byTagAndText("h1", "Forgot Password"));
    private static final SelenideElement SEND_RESET_INSTRUCTIONS_BUTTON = $(withTagAndText("button", "Send Reset Instructions"));
    private static final SelenideElement RESET_PASSWORD_LABEL = $(withText("you will receive password reset instructions."));

    public ForgotPasswordPage verifyNavigationToResetPasswordPage() {
        FORGOT_PASSWORD_LABEL.shouldHave(visible, textCaseSensitive("Forgot Password"));
        return this;
    }

    public void sendResetPasswordInstructions(String email) {
        EMAIL.shouldBe(visible).setValue(email);
        SEND_RESET_INSTRUCTIONS_BUTTON.shouldBe(interactable).click();
        RESET_PASSWORD_LABEL.shouldHave(visible, textCaseSensitive("If an account exists with the provided email, you will receive password reset instructions."));
    }
}
