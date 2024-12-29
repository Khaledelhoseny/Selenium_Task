package register;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignUpPage;

public class RegisterTests extends BaseTests {
    @Test
    public void testSuccessfulRegister() throws InterruptedException {
        LoginPage loginPage = homePage.clickOnAccountLink();
        SignUpPage signUpPage = loginPage.clickOnCreateAccountLink();
        signUpPage.insertFirstName();
        signUpPage.insertLastName();
        signUpPage.insertEmail();
        signUpPage.insertPassword();
        signUpPage.clickOnCreateButton();
        System.out.println(signUpPage.fakeEmail);
        System.out.println(signUpPage.fakePassword);
    }
}
