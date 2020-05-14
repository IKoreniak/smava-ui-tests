package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    String baseUrl = "https://smava.de";
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Method is used to aviod ElementClickInterceptedException
    public void clickOnElement(WebElement element){
        try {
            element.click();
        } catch (WebDriverException e) {
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
        }
    }

    //Method for selection of option from dropdown lists
    public void selectOptionByText(WebElement dropDown, String option) {
        dropDown.click();
        driver.findElement(By.xpath("//*[contains(text(), '" + option + "')]")).click();
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                        .equals("complete"));
    }

}
