package com.test.roku.steps;

import com.microsoft.playwright.Page;
import com.test.roku.pages.ContactUsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.test.roku.utils.ConfigUtils.getPropertyByKey;

public class ContactUsSteps {
    Hooks hooks = new Hooks();
    Page page = hooks.getPage();
    ContactUsPageAssertions contactUsPageAssertions = new ContactUsPageAssertions(page);
    ContactUsPage contactuspage = contactUsPageAssertions.getContactUsPage();

    @When("User enter valid contact us details")
    public void userEnterValidContactUsDetails() {
        contactuspage.submitContactUsDetails(
                getPropertyByKey("contactUsPage.validName"),
                getPropertyByKey("contactUsPage.validEmailAddress"),
                getPropertyByKey("contactUsPage.validPhone"),
                getPropertyByKey("contactUsPage.validSubject"),
                getPropertyByKey("contactUsPage.validMessage")
        );
    }

    @And("Click on submit button")
    public void clickOnSubmitButton() {
        contactuspage.clickOnSubmitButton();
    }

    @Then("User should be displayed contact us successful submission message")
    public void userShouldBeDisplayedContactUsSuccessfulSubmissionMessage() {
        contactUsPageAssertions.assertContactUsSubmitSuccessMessage();
    }

    @And("User should be displayed the name in the successful submission message")
    public void userShouldBeDisplayedTheNameInTheSuccessfulSubmissionMessage() {
        contactUsPageAssertions.assertNameDisplayedInSubmitSuccessMessage();
    }

    @And("User should be displayed the subject in the successful submission message")
    public void userShouldBeDisplayedTheSubjectInTheSuccessfulSubmissionMessage() {
        contactUsPageAssertions.assertSubjectDisplayedInSubmitSuccessMessage();
    }


    @When("User enters {string} and {string} and {string} and {string} and {string}")
    public void userEntersNameAndEmailAndPhoneAndSubjectAndMessage(String name, String email, String phone,
                                                                   String subject, String message) {
        contactuspage.submitContactUsDetails(name, email, phone, subject, message);
    }

    @Then("User should be displayed error message")
    public void userShouldBeDisplayedErrorMessage() {
        contactUsPageAssertions.assertErrorMsgContainerDisplayed();
    }

    @And("User should be displayed blank name text error")
    public void userShouldBeDisplayedBlankNameTextError() {
        contactUsPageAssertions.assertErrorMessageDisplayedWhenBlankNameTextEntered();
    }

    @And("User should be displayed blank email text error")
    public void userShouldBeDisplayedBlankEmailTextError() {
        contactUsPageAssertions.assertErrorMessageDisplayedWhenBlankEmailTextEntered();
    }

    @And("User should be displayed blank phone text error")
    public void userShouldBeDisplayedBlankPhoneTextError() {
        contactUsPageAssertions.assertErrorMessageDisplayedWhenBlankPhoneTextEntered();
    }

    @And("User should be displayed error with acceptable range of {string}")
    public void userShouldBeDisplayedErrorWithAcceptableRange(String fieldName) {
        contactUsPageAssertions.assertErrorMessageDisplayedWhenOutOfRangeTextEntered(fieldName);
    }

    @And("User should be displayed blank subject text error")
    public void userShouldBeDisplayedBlankSubjectTextError() {
        contactUsPageAssertions.assertErrorMessageDisplayedWhenBlankSubjectTextEntered();
    }

    @And("User should be displayed blank message text error")
    public void userShouldBeDisplayedBlankMessageTextError() {
        contactUsPageAssertions.assertErrorMessageDisplayedWhenBlankMessageTextEntered();
    }

    @Then("User should be displayed {string} next to relevant text box")
    public void userShouldBeDisplayedIconNextToNameTextBox(String textBoxIcon) {
        contactUsPageAssertions.assertTextBoxIconDisplayed(textBoxIcon);
    }

    @And("User should be displayed {string} label in the text box")
    public void userShouldBeDisplayedLabelInFieldTextBox(String textBoxLabel) {
        contactUsPageAssertions.assertTextBoxLabelDisplayed(textBoxLabel);
    }

    @And("User should be displayed message caption next to message text area")
    public void userShouldBeDisplayedMessageCaptionNextToMessageTextArea() {
        contactUsPageAssertions.assertMessageBoxCaptionDisplayed();
    }

    @When("User enters {string} in the name field")
    public void userEntersInvalidNameInTheNameField(String invalidName) {
        contactuspage.submitContactUsDetails(
                invalidName,
                getPropertyByKey("contactUsPage.validEmailAddress"),
                getPropertyByKey("contactUsPage.validPhone"),
                getPropertyByKey("contactUsPage.validSubject"),
                getPropertyByKey("contactUsPage.validMessage")
        );
    }

    @When("User enters {string} in the email field")
    public void userEntersInvalidEmailInTheEmailField(String invalidEmailId) {
        contactuspage.submitContactUsDetails(
                getPropertyByKey("contactUsPage.validName"),
                invalidEmailId,
                getPropertyByKey("contactUsPage.validPhone"),
                getPropertyByKey("contactUsPage.validSubject"),
                getPropertyByKey("contactUsPage.validMessage")
        );
    }

    @When("User enters {string} in the phone field")
    public void userEntersInvalidPhoneInThePhoneField(String invalidPhoneNo) {
        contactuspage.submitContactUsDetails(
                getPropertyByKey("contactUsPage.validName"),
                getPropertyByKey("contactUsPage.validEmailAddress"),
                invalidPhoneNo,
                getPropertyByKey("contactUsPage.validSubject"),
                getPropertyByKey("contactUsPage.validMessage")
        );
    }

    @Then("User should be displayed invalid {string} format error message")
    public void userShouldBeDisplayedInvalidFormatErrorMessage(String fieldName) {
        contactUsPageAssertions.assertErrorDisplayedForInvalidFormat(fieldName);
    }

    @When("User enters {string} in the subject field")
    public void userEntersOutOfRangeSubjectTextInTheSubjectField(String outOfRangeSubjectText) {
        contactuspage.submitContactUsDetails(
                getPropertyByKey("contactUsPage.validName"),
                getPropertyByKey("contactUsPage.validEmailAddress"),
                getPropertyByKey("contactUsPage.validPhone"),
                outOfRangeSubjectText,
                getPropertyByKey("contactUsPage.validMessage")
        );
    }

    @When("User enters {string} in the message field")
    public void userEntersOutOfRangeMessageTextInTheMessageField(String outOfRangeMessageText) {
        contactuspage.submitContactUsDetails(
                getPropertyByKey("contactUsPage.validName"),
                getPropertyByKey("contactUsPage.validEmailAddress"),
                getPropertyByKey("contactUsPage.validPhone"),
                getPropertyByKey("contactUsPage.validSubject"),
                outOfRangeMessageText
        );
    }

    @Given("User is on the contact us page of the application and scrolled down")
    public void userIsOnTheContactUsPageOfTheApplicationAndScrolledDown() {
        contactuspage.scrollToContactUsForm(page);
    }
}
