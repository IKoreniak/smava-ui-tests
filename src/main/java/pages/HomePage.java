package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.registration.ContactInfoPage;

public class HomePage extends BasePage{

    //Page Elements
    @FindBy(css = "[title=Anmelden]")
    WebElement signInButton;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//*[contains(@class, 'StyledRegisterAccountSubmitButton')]")
    WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(), 'Freie Verwendung')]")
    WebElement usageDDL;

    @FindBy(xpath = "//div[contains(text(), '20.000')]")
    WebElement loanAmountDDL;

    @FindBy(xpath = "//div[contains(text(), '84 Monate')]")
    WebElement runningTimeDDL;

    @FindBy(xpath = "//span[contains(text(), 'Jetzt Kreditvergleich starten')]")
    WebElement startComparisonButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Smava Home Page")
    public HomePage openHomePage() {
        driver.navigate().to(baseUrl);
        return this;
    }

    @Step("Login with username {0}, password {0}")
    public SignInPage login(String email, String password) {
        signInButton.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        return new SignInPage(driver);
    }

    @Step("Ask for loan for {0} of amount {1} to pay during {2} months")
    public ContactInfoPage enterLoanParamsAndProceedToRegistration(String usage, String loanAmount, String runningTime) {
        selectOptionByText(usageDDL, usage);
        selectOptionByText(loanAmountDDL, loanAmount);
        selectOptionByText(runningTimeDDL,runningTime);
        startComparisonButton.click();
        return new ContactInfoPage(driver);
    }

}
