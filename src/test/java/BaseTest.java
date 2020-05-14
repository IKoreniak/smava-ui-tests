import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import settings.Settings;

public class BaseTest {

    WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = Settings.webDriverSettings();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
