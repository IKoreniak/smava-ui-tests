package pages.registration;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static org.assertj.core.api.Assertions.assertThat;

public class EmploymentPage extends BasePage {

    //Used to verify that user is on correct step of wizard
    String step = "step=Employment";

    @FindBy(id = "applicant0.household.livingCondition-RENT")
    WebElement rentRadioButton;

    public EmploymentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify that Income page is fully loaded")
    public void verifyThatPageIsFullyLoaded() {
        waitForPageLoad();
        assertThat(rentRadioButton.isDisplayed()).as("Expected element is not displayed on the page").isTrue();
        assertThat(driver.getCurrentUrl().contains(step)).isTrue();
    }

}
