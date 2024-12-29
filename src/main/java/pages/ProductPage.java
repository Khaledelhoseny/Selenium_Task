package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ProductPage extends MethodHandles {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    private final By addToCartButton = By.id("AddToCart-4661007810635") ;
    private final By checkOutButton = By.xpath("//form[@action='/cart']//button[@name='checkout']");
    public void clickOnAddToCartButton(){
        click(addToCartButton,5);
    }

    public LoginPage clickOnCheckOutButton(){
        click(checkOutButton,20);
        return new LoginPage(driver);
    }

}
