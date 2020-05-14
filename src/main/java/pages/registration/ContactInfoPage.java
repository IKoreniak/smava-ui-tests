package pages.registration;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ContactInfoPage extends BasePage {

    @FindBy(id = "applicant0.personal.firstName")
    WebElement firstNameField;

    @FindBy(id = "applicant0.personal.lastName")
    WebElement lastNameField;

    @FindBy(id = "applicant0.personal.birthDate")
    WebElement birthDateField;

    @FindBy(id = "applicant0.contacts.phoneMobile")
    WebElement phoneField;

    @FindBy(id = "applicant0.contacts.email")
    WebElement emailField;

    @FindBy(id = "applicant0.conditions.schufaAgreementAccepted")
    WebElement acceptAgreement;

    @FindBy(id = "applicant0.conditions.newsletterSubscription")
    WebElement newsletterSubscription;

    @FindBy(id = "cta_btn_0_span_0")
    WebElement nextButton;

    public ContactInfoPage(WebDriver driver) {
        super(driver);
    }

    //Allowed "count" values: 1, 2
    public void selectApplicantsCount(int count) {
        driver.findElement(By.id("applicant0.applicantsCount-" + count)).click();
    }

    //Allowed "salutation" values: MR, MRS
    public void selectSalutation(String salutation) {
        driver.findElement(By.id("applicant0.personal.salutation-" + salutation)).click();
    }

    @Step("Fill in Contact Information")
    public AddressPage fillInContactInformation(int count, String salutation, String firstName, String lastName,
                                                           String birthday, String phone, String email) {
        waitForPageLoad();
        selectApplicantsCount(count);
        selectSalutation(salutation);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        birthDateField.sendKeys(birthday);
        phoneField.sendKeys(phone);
        emailField.sendKeys(email);
        clickOnElement(acceptAgreement);
        clickOnElement(newsletterSubscription);
        clickOnElement(nextButton);
        return new AddressPage(driver);
    }
}
