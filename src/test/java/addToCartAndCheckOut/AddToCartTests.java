package addToCartAndCheckOut;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CollectionsPage;
import pages.LoginPage;
import pages.ProductPage;

import java.io.FileNotFoundException;

public class AddToCartTests extends BaseTests {
    @Test
    public void testAddToCart() throws InterruptedException, FileNotFoundException {
        homePage.scrollToPetByIndex(1);
        CollectionsPage collectionsPage = homePage.clickOnPetByIndex(1);
        collectionsPage.scrollToProductByIndex(3);
        ProductPage productPage = collectionsPage.clickOnProductByIndex(3);
        productPage.clickOnAddToCartButton();
        LoginPage loginPage = productPage.clickOnCheckOutButton();

        // login to check out
        String email = dataModel().Login.ValidCredentials.Email;
        String password = dataModel().Login.ValidCredentials.Password;
        loginPage.loginFeature(email,password);

    }
}
