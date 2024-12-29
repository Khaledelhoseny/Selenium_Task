package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class SignUpPage extends MethodHandles {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    private final By firstName = By.id("FirstName") ;
    private final By lastName = By.id("LastName");
    private final By email = By.id("Email") ;
    private final By password = By.id("CreatePassword");
    private final By createButton = By.xpath("//*[@value='Create']") ;
    public String fakeFirstName = generateFirstName();
    public String fakeLastName = generateLastName();
    public String fakeEmail = generateEmail();
    public String fakePassword = generatePassword() ;

    public void insertFirstName (){
        sendKeys(firstName,3,fakeFirstName);
    }
    public void insertLastName (){
        sendKeys(lastName,3,fakeLastName);
    }
    public void insertEmail (){
        sendKeys(email,3,fakeEmail);
    }
    public void insertPassword (){
        sendKeys(password,3,fakePassword);
    }
    public void clickOnCreateButton(){
        click(createButton,3);
    }
}
