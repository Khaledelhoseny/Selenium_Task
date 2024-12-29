package base;

import data.DataModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import reader.ReadDataFromJson;
import utils.ScreenRecorderUtil;
import utils.UtilsTests;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

public class BaseTests {
    protected WebDriver driver ;
    public UtilsTests utilsTests ;
    ChromeOptions chromeOptions ;
    FirefoxOptions firefoxOptions ;
    public ReadDataFromJson readDataFromJson;
    public HomePage homePage;
    @Parameters("browser")
    @BeforeClass(groups = {"regression2","smoke"})
    public void setUp(@Optional("chrome") String browser ){
        setUpBrowser(browser);
        driver.manage().window().maximize();
//        homePage = new HomePage(driver);
        homePage = new HomePage(driver) ;
    }
    public void setUpBrowser(String browser ){
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("headlessChrome")) {
            chromeOptions = new ChromeOptions() ;
            chromeOptions.addArguments("--headless") ;
            driver = new ChromeDriver(chromeOptions) ;
        }else if(browser.equalsIgnoreCase("headlessFirefox")) {
            firefoxOptions = new FirefoxOptions() ;
            firefoxOptions.addArguments("--headless") ;
            driver = new FirefoxDriver(firefoxOptions) ;
        }
    }
    @BeforeMethod (groups = {"regression2","smoke"})
    public void goHome( Method testMethod ) throws Exception {
        readDataFromJson = new ReadDataFromJson();
        driver.get(dataModel().URL);
        //        Take Screen Record
        ScreenRecorderUtil.startRecord(testMethod.getName());
        //        Create Test case in report
        utilsTests = new UtilsTests(driver) ;
        utilsTests.createTestCaseInReport(testMethod);
    }
    @AfterMethod (groups = {"regression2", "smoke"})
    public void takeScrenShotAfterMethod (Method testMethod , ITestResult result) throws Exception {
//                Take Screen Shots
        utilsTests = new UtilsTests(driver) ;
        utilsTests.takeScreenShot(testMethod);
//                Take Screen Record
        ScreenRecorderUtil.stopRecord();
//                Set status in extent report
        utilsTests.setStatus(testMethod,result);
    }
    @AfterClass (groups = {"regression2","smoke"})
    public void teaDown(){
        driver.quit();
    }

    @BeforeSuite  (groups = {"regression2","smoke"})
    public void beforeSuite(){
        utilsTests = new UtilsTests(driver) ;
        utilsTests.createReport();
    }
    @AfterSuite (groups = {"regression2","smoke"})
    public void afterSuite(){
        utilsTests = new UtilsTests(driver) ;
        utilsTests.flushReport();
    }

    public DataModel dataModel() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        return readDataFromJson.readJsonFile()  ;
    }


}
