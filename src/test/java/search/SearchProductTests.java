package search;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchResultPage;
import java.io.FileNotFoundException;
public class SearchProductTests extends BaseTests {
    // Happy Scenario
    @Test
    public void testExistProduct() throws FileNotFoundException {
        homePage.clickOnSearchIcon();
        homePage.insertInSearchInput(dataModel().ValidProduct);
        SearchResultPage searchResultPage = homePage.clickToSearch();
        //Assertion
        String actualResult = searchResultPage.getSearchResult();
        String expectedResult = dataModel().ValidProduct ;
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    // UnHappy Scenario
    @Test
    public void testNonExistProduct() throws FileNotFoundException {
        homePage.clickOnSearchIcon();
        homePage.insertInSearchInput(dataModel().InvalidProduct);
        SearchResultPage searchResultPage = homePage.clickToSearch();
        //assertion for 0 results
        String actualResult = searchResultPage.getCountOfResults();
        String expectedResult = "0 RESULTS" ;
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
