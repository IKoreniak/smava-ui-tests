package pages.registration;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AddressPage extends BasePage {

    @FindBy(id = "applicant0.personal.birthplace")
    WebElement birthplaceField;

    @FindBy(xpath = "//div[contains(text(), 'Familienstand')]")
    WebElement maritalStatusField;

    @FindBy(id = "applicant0.address.city.zipCode")
    WebElement zipCodeField;

    @FindBy(id = "applicant0.address.city.city")
    WebElement cityField;

    @FindBy(id = "applicant0.address.street.street")
    WebElement streetField;

    @FindBy(id = "applicant0.address.street.houseNumber")
    WebElement houseNumberField;

    @FindBy(id = "applicant0.address.moveInDate")
    WebElement moveInDateField;

    @FindBy(id = "cta_btn_1")
    WebElement nextButton;

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill in Address Information")
    public EmploymentPage fillInAddressInformation(String birthplace, String maritalStatus, String zipCode,
                                                   String city, String street, String houseNumber,
                                                   String moveInDate) {
        waitForPageLoad();
        birthplaceField.sendKeys(birthplace);
        selectOptionByText(maritalStatusField, maritalStatus);
        zipCodeField.sendKeys(zipCode);
        cityField.sendKeys(city);
        streetField.sendKeys(street);
        houseNumberField.sendKeys(houseNumber);
        moveInDateField.sendKeys(moveInDate);
        nextButton.click();
        return new EmploymentPage(driver);
    }

}
