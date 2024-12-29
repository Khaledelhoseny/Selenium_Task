package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {

   public HomePage(WebDriver driver){
       super(driver);
   }

   private final By accountLink = By.cssSelector(".site-nav__link.site-nav__link--icon.small--hide");
   private final By searchIcon = By.xpath("//*[@href='/search']") ;
   private final By searchInput = By.xpath("//*[@type='search']") ;
   private final By searchButton = By.xpath("//*[@type='submit'][1]") ;
   private final By pets = By.cssSelector(".grid__item.small--one-half.medium-up--one-third") ;
   private final By siteNavButton = By.cssSelector(".site-nav__link.site-nav__link--icon.js-drawer-open-nav") ;
   private final By loginButton = By.partialLinkText("Log in");
   public LoginPage clickOnAccountLink(){
       click(accountLink,3);
       return new LoginPage(driver) ;
   }

   public void clickOnSearchIcon(){
       click(searchIcon,5);
   }

   public void insertInSearchInput(String text){
       sendKeys(searchInput , 5 , text);
   }

   public SearchResultPage clickToSearch(){
       click(searchButton,5);
       return new SearchResultPage(driver) ;
   }

    public void scrollToPetByIndex ( int index ){
       scrollToElementbyIndex(pets , index , 5);
    }

    public CollectionsPage clickOnPetByIndex(int index){
         clickByIndex(pets,5,index);
         return new CollectionsPage(driver);
    }

    public void clickOnSiteNavButton(){
       click(siteNavButton,5);
    }

    public LoginPage clickOnLoginButton(){
       click(loginButton,5);
       return new LoginPage(driver) ;
    }

}
