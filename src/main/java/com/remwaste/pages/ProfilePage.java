package com.remwaste.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import com.remwaste.entity.UserDetails;

import static com.codeborne.selenide.ClickOptions.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    public ProfilePage() {
    }

    public static ProfilePage getInstance() {
        return new ProfilePage();
    }

    private static final SelenideElement PROFILE_INFORMATION_LABEL = $(withText("Personal Information"));
    private static final SelenideElement CONTACT_INFORMATION_LABEL = $(withText("Contact Information"));
    private static final SelenideElement FIRST_NAME_FIELD = $(byName("firstName"));
    private static final SelenideElement LAST_NAME_FIELD = $(byName("lastName"));
    private static final SelenideElement EMAIL_FIELD = $(byName("email"));
    private static final SelenideElement MOBILE_NUMBER_FIELD = $(byName("mobileNumber"));
    private static final SelenideElement ADDRESS_FIELD = $(byName("address"));
    private static final SelenideElement EDIT_PROFILE_BUTTON = $(byTagAndText("button", "Edit Profile"));
    private static final SelenideElement SAVE_CHANGES_BUTTON = $(byTagAndText("button", "Save Changes"));
    private static final SelenideElement CANCEL_BUTTON = $(byTagAndText("button", "Cancel"));

    private static final Faker FAKER = new Faker();

    public ProfilePage verifyNavigationToProfilePage() {
        PROFILE_INFORMATION_LABEL.shouldHave(visible);
        return this;
    }

    public void editUserInformation(UserDetails userDetails) {
        EDIT_PROFILE_BUTTON.shouldBe(visible, interactable).scrollTo().click(usingJavaScript());
        FIRST_NAME_FIELD.shouldBe(visible, enabled).clear();
        FIRST_NAME_FIELD.setValue(userDetails.getFirstName());
        LAST_NAME_FIELD.clear();
        LAST_NAME_FIELD.setValue(userDetails.getLastName());
        EMAIL_FIELD.shouldBe(visible, enabled).click();
        EMAIL_FIELD.clear();
        EMAIL_FIELD.setValue(userDetails.getEmail());
        MOBILE_NUMBER_FIELD.shouldBe(visible, enabled).clear();
        MOBILE_NUMBER_FIELD.setValue(userDetails.getMobileNumber());
        ADDRESS_FIELD.shouldBe(visible, enabled).clear();
        ADDRESS_FIELD.setValue(FAKER.address().city());
        SAVE_CHANGES_BUTTON.shouldBe(visible, interactable).click();
    }

}
