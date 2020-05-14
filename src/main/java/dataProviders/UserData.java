package dataProviders;

import org.testng.annotations.DataProvider;

public class UserData {

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLogin() {
        return new Object[][] {
                {"test.email@mail.com", "password", "Ihr Passwort oder Ihr Konto stimmen nicht"}
        };
    }

    @DataProvider(name = "registrationData")
    public Object[][] registrationData() {
        return new Object[][] {
                {"Wohnen / Modernisierung", "2.750", "24 Monate", 1, "MRS", "Tim", "Dun", "12.12.1999", "01234567",
                        "test.email@mail.com", "Berlin", "ledig", "21386", "Betzendorf",
                        "Inge Beisheim Platz", "5", "12.2000"}
        };
    }



}
