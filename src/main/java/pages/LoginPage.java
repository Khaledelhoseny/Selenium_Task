package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public LoginPage (WebDriver driver){
        super(driver);
    }
    private final By createAccountLink = By.id("customer_register_link") ;
    private final By emailField = By.id("CustomerEmail");
    private final By passwordField = By.id("CustomerPassword");
    private final By signInButton = By.xpath("//*[contains ( text() , 'Sign In' )]");
    private final By errorMessage = By.cssSelector(".errors");
    public SignUpPage clickOnCreateAccountLink(){
        click(createAccountLink, 5);
        return new SignUpPage(driver) ;
    }
    private void insertEmail(String text){
        sendKeys(emailField,5,text);
    }
    private void insertPassword(String text){
        sendKeys(passwordField,5,text);
    }

    private void clickOnSignIn(){
        click(signInButton,5);
    }
    public void loginFeature( String email , String password ){
        insertEmail(email);
        insertPassword(password);
        clickOnSignIn();
    }

    public String getErrorMessage(){
        return getText(errorMessage,5);
    }


}
