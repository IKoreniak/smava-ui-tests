package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[2]/div/div")
    public WebElement signInForm;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify that login failed and error message {0} is displayed")
    public SignInPage verifyThatLoginFailed(String errorMessage) {
        assertThat(signInForm.isDisplayed()).isTrue();
        assertThat(signInForm.getText()).contains(errorMessage);
        return this;
    }

}
