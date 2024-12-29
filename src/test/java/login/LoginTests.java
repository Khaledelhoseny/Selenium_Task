package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() throws FileNotFoundException {
        homePage.clickOnSiteNavButton();
        LoginPage loginPage = homePage.clickOnLoginButton();
        String email = dataModel().Login.ValidCredentials.Email;
        String password = dataModel().Login.ValidCredentials.Password;
        loginPage.loginFeature(email , password);
    }
    @Test
    public void testUnSuccessfulLogin() throws FileNotFoundException {
        homePage.clickOnSiteNavButton();
        LoginPage loginPage = homePage.clickOnLoginButton();
        String email = dataModel().Login.InValidCredentials.Email;
        String password = dataModel().Login.InValidCredentials.Password;
        loginPage.loginFeature(email , password);
        //Assertion
//        String actualResult = loginPage.getErrorMessage();
//        String expectedResult = "Incorrect email or password." ;
//        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
