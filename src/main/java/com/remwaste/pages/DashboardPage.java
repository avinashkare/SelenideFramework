package com.remwaste.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    public DashboardPage() {
    }

    public static DashboardPage getInstance() {
        return new DashboardPage();
    }

    private static final SelenideElement WELCOME_MESSAGE = $(withText("Welcome back"));
    private static final SelenideElement LOGIN_SUCCESSFUL_MESSAGE = $(withText("Login successful"));
    private static final SelenideElement CURRENT_USER_BUTTON = $(byAttribute("aria-label", "account of current user"));
    private static final SelenideElement PROFILE_BUTTON = $(byTagAndText("li", "Profile"));
    private static final SelenideElement LOGOUT_BUTTON = $(byTagAndText("li", "Logout"));

    public DashboardPage verifyUserLoggedInSuccessfully(String username) {
        WELCOME_MESSAGE.shouldBe(visible).shouldHave(textCaseSensitive("Welcome back, " + username));
        LOGIN_SUCCESSFUL_MESSAGE.shouldBe(disappear);
        return this;
    }

    public ProfilePage navigateToProfilePage() {
        CURRENT_USER_BUTTON.shouldBe(visible).click();
        PROFILE_BUTTON.shouldBe(visible).click();
        return new ProfilePage();
    }

    public void logout() {
        CURRENT_USER_BUTTON.shouldBe(visible).click();
        LOGOUT_BUTTON.shouldBe(visible).click();
    }
}
