package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class SearchResultPage extends MethodHandles {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    private final By searchResult = By.xpath("//*[@aria-label='breadcrumbs']") ;
    private final By countOfResults = By.xpath("//h2[@class='section-header__title']") ;

    public String getSearchResult(){
        return getText(searchResult,5);
    }

    public String getCountOfResults(){
        return getText(countOfResults,5);
    }





}
