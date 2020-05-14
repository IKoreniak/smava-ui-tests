import dataProviders.UserData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.HomePage;

@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTest extends BaseTest{

    @Story("Invalid login tests")
    @Test(description = "Invalid login scenario with incorrect email and password",
    dataProvider = "invalidLoginData", dataProviderClass = UserData.class)
    public void incorrectLoginTest(String email, String password, String errorMessage) {
        homePage = new HomePage(driver);
        homePage.openHomePage()
                .login(email, password)
                .verifyThatLoginFailed(errorMessage);
    }

}
