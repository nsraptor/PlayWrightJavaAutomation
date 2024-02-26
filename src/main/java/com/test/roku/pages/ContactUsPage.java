package com.test.roku.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import static com.test.roku.utils.CommonUtils.clickOnElement;
import static com.test.roku.utils.CommonUtils.sendKeysTo;
import static com.test.roku.utils.CommonUtils.waitForNotVisible;

@Getter
public class ContactUsPage {
    private final Locator nameIdCardIcon;
    private final Locator emailIcon;
    private final Locator phoneIcon;
    private final Locator subjectEnvelopeIcon;
    private final Locator messageCaption;
    private final Locator nameTextField;
    private final Locator emailTextField;
    private final Locator phoneTextField;
    private final Locator subjectTextField;
    private final Locator thanksMessage;
    private final Locator messageTextArea;
    private final Locator submitButton;
    private final Locator errorMessageContainer;

    public ContactUsPage(Page page) {
        System.out.println("WEBELEMENTS INITIALISED!!!!");
        this.nameIdCardIcon = page.locator(".fa-id-card");
        this.emailIcon = page.locator("//input[@id='email']/preceding-sibling::div//span[@class='fa fa-envelope']");
        this.phoneIcon = page.locator("//span[@class='fa fa-phone']");
        this.subjectEnvelopeIcon = page.locator("//input[@id='subject']/preceding-sibling::div//span[@class='fa fa-envelope']");
        this.messageCaption = page.locator("//span[@class='input-group-text']");
        this.nameTextField = page.locator("//input[@id='name']");
        this.emailTextField = page.locator("//input[@id='email']");
        this.phoneTextField = page.locator("//input[@id='phone']");
        this.subjectTextField = page.locator("//input[@id='subject']");
        this.thanksMessage = page.locator("//*[h2[contains(.,'Thanks for getting in touch')]]");
        this.messageTextArea = page.locator("//textarea[@id='description']");
        this.submitButton = page.locator("//button[@id='submitContact']");
        this.errorMessageContainer = page.locator(".alert");
    }

    public void submitContactUsDetails(String name, String email, String phone, String subject, String message) {
         sendKeysTo(nameTextField, name);
         sendKeysTo(emailTextField, email);
         sendKeysTo(phoneTextField, phone);
         sendKeysTo(subjectTextField, subject);
         sendKeysTo(messageTextArea, message);
    }

    public void scrollToContactUsForm(Page page) {
        // Call the scrollIntoView method using JavascriptExecutor
    }

    public void clickOnSubmitButton() {
         clickOnElement(submitButton);
         waitForNotVisible(submitButton);
}
}
