package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class CollectionsPage extends MethodHandles {
    public CollectionsPage(WebDriver driver) {
        super(driver);
    }
    private final By products = By.cssSelector(".grid-product__content");

    public void scrollToProductByIndex ( int index ){
        scrollToElementbyIndex(products , index , 20);
    }

    public ProductPage clickOnProductByIndex(int index){
        clickByIndex(products,5,index);
        return new ProductPage(driver) ;
    }

}
