import dataProviders.UserData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.HomePage;

@Epic("Regression Tests")
@Feature("Loan Tests")
public class LoanTests extends BaseTest {

    @Story("Loan Wizard: First Step")
    @Test(description = "User asks for a loan and proceeds to second step of wizard",
            dataProvider = "registrationData", dataProviderClass = UserData.class)
    public void completeLoanFirstStepTest(String usage, String loanAmount, String runningTime, int count,
                                          String salutation, String firstName, String lastName, String birthday,
                                          String phone, String email, String birthplace,
                                          String maritalStatus, String zipCode, String city, String street,
                                          String houseNumber, String moveInDate ) {
        homePage = new HomePage(driver);
        homePage.openHomePage()
                .enterLoanParamsAndProceedToRegistration(usage, loanAmount, runningTime)
                .fillInContactInformation(count, salutation, firstName, lastName, birthday, phone, email)
                .fillInAddressInformation(birthplace,maritalStatus, zipCode, city, street, houseNumber, moveInDate)
                .verifyThatPageIsFullyLoaded();
    }
}
