package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.github.javafaker.Faker;
import junit.framework.Assert;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.awt.SystemColor.text;

public class MethodHandles {
    protected Faker faker ;
    protected WebDriver driver ;
    WebDriverWait wait  ;
    FluentWait fluentWait ;
    Actions actions ;
    Select select ;
    static ExtentTest test ;
    static ExtentReports extent ;
    public MethodHandles(WebDriver driver){
        this.driver = driver ;
    }
    private WebElement webElement(By locator ){
       return driver.findElement(locator) ;
    }
    public WebElement getWebElementByIndex(By locator , int index){
        return driver.findElements(locator).get(index) ;

    }
    protected void explicitWait(By locator , int time ){
        wait = new WebDriverWait(driver , Duration.ofSeconds(time)) ;
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(locator)
//                ExpectedConditions.elementToBeClickable(locator),
//                ExpectedConditions.presenceOfElementLocated(locator)
        ));
    }
    protected void inVisabilityOfElement(By locator , int time ){
        wait = new WebDriverWait(driver , Duration.ofSeconds(time)) ;
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    protected void fluentWait( By locator , int time){
        fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void sendKeys(By locator , int time , String text){

        for (int i = 0 ; i<5 ; i++){
            try {
                explicitWait(locator , time );
                addBorderToElement(driver, webElement(locator));
                setSteps();
                webElement(locator).sendKeys(text);
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Element doesn't exist");
            }
        }
    }

    protected void click(By locator , int time ){
        for (int i = 0 ; i<5 ; i++){
            try {
                explicitWait( locator , time);
                addBorderToElement(driver, webElement(locator));
                setSteps();
                webElement(locator).click();
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Element doesn't exist");
            }
        }
    }
    protected void clickByIndex(By locator , int time , int index ){
        for (int i = 0 ; i<5 ; i++){
            try {
                explicitWait( locator , time);
                addBorderToElement(driver, getWebElementByIndex(locator,index-1));
                setSteps();
                getWebElementByIndex(locator, index-1).click();
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Element doesn't exist");
            }
        }
    }

    protected void scrollToElement( By locator , int time){
        explicitWait(locator ,time );
        actions = new Actions(driver) ;
        actions.scrollToElement(webElement(locator)).build().perform();
    }
    protected void scrollToElementbyIndex(By locator ,int index , int time){
        explicitWait(locator ,time );
        addBorderToElement(driver, getWebElementByIndex(locator,index-1));
        setSteps();
        actions = new Actions(driver) ;
        actions.scrollToElement(getWebElementByIndex(locator , index-1)).build().perform();
    }
    public void scrollWithJsExecutor( By locator ){
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("arguments[0].scrollIntoView(true);",webElement(locator));
    }
    protected void switchToFrame(By locator){
        driver.switchTo().frame(webElement(locator)) ;
    }

    protected void clickWithMouseActions(By locator , int time){
        actions = new Actions(driver) ;
        for (int i = 0 ; i<5 ; i++){
            try {
                explicitWait( locator , time);
                addBorderToElement(driver, webElement(locator));
                setSteps();
                actions.click(webElement(locator)).build().perform();
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Element doesn't exist");
            }
        }
    }

    protected String getText(By locator , int time){
        String text = null ;
        for (int i = 0 ; i<5 ; i++){
            try {
                explicitWait( locator , time);
                addBorderToElement(driver, webElement(locator));
                setSteps();
                text = webElement(locator).getText() ;
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Element doesn't exist");
            }
        }
        return text ;
    }

    protected boolean isSelected(By locator , int time ){
        Boolean flag = false ;
        for (int i = 0 ; i<5 ; i++){
            try {
                explicitWait( locator , time);
                addBorderToElement(driver, webElement(locator));
                setSteps();
                flag = webElement(locator).isSelected() ;
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Element doesn't exist");
            }
        }
        return flag ;
    }

    protected boolean isDisplayed(By locator , int time ){
        Boolean flag = false ;
        for (int i = 0 ; i<5 ; i++){
            try {
                explicitWait( locator , time);
                addBorderToElement(driver, webElement(locator));
                setSteps();
                flag = webElement(locator).isDisplayed();
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Element doesn't exist");
            }
        }
        return flag ;
    }

    protected void clear(By locator , int time ){
        for (int i = 0 ; i<5 ; i++){
            try {
                explicitWait( locator , time);
                addBorderToElement(driver, webElement(locator));
                setSteps();
                webElement(locator).clear();
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Element doesn't exist");
            }
        }
    }

    protected void acceptJsAlert(){
        driver.switchTo().alert().accept();
    }
    protected void dismissJsAlert(){
        driver.switchTo().alert().dismiss();
    }
    protected void insertToJsAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    protected void dragAndDropAction(By locator1,By locator2){
        actions =  new Actions(driver) ;
        actions.clickAndHold(webElement(locator1)).moveToElement(webElement(locator2)).release().build().perform();
    }
    protected void moveToElement(By source ,By target ,  int time ){
        actions = new Actions(driver) ;
        for (int i = 0 ; i<5 ; i++){
            try {
                explicitWait( source , time);
                explicitWait( target , time);
                addBorderToElement(driver, webElement(source));
                addBorderToElement(driver, webElement(target));
                setSteps();
                actions.dragAndDrop(webElement(source) , webElement(target)).build().perform();
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Element doesn't exist");
            }
        }
    }

    protected void hoverOver(By locator){
        actions =  new Actions(driver) ;
        actions.moveToElement(webElement(locator)).build().perform();
    }

    protected void hoverOver(By locator , int index , int time ){
        actions =  new Actions(driver) ;
        for (int i = 0 ; i<5 ; i++){
            try {
                explicitWait( locator , time);
                addBorderToElement(driver, getWebElementByIndex(locator,index));
                setSteps();
                actions.moveToElement(getWebElementByIndex(locator,index)).build().perform();
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Element doesn't exist");
            }
        }

    }


    protected void selectElementByIndex(By locator , int index , int time){
        select = new Select(webElement(locator));
        for (int i = 0 ; i<5 ; i++){
            try {
                explicitWait( locator , time);
                addBorderToElement(driver, webElement(locator));
                setSteps();
                select.selectByIndex(index);
                break;
            }catch (StaleElementReferenceException e){
                System.out.println("Element doesn't exist");
            }
        }

    }
    protected List <String> getOptions(By locator){
        select = new Select(webElement(locator));
        setSteps();
        List<WebElement> selectedElements = select.getAllSelectedOptions();
        List<String> list = new ArrayList<String>(5);
        for (WebElement result : selectedElements) {
            list.add(result.getText());
            System.out.println(result.getText());
        }
        System.out.println(list);
        return list ;
    }


    protected void switchToFrame(String nameOrId){
        driver.switchTo().frame(nameOrId);
    }
    protected void switchToParent(){
        driver.switchTo().parentFrame();
    }
    protected void switchToFrame(int frameIndex){
        driver.switchTo().frame(frameIndex);
    }

    private static String getMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 2) {
            if (stackTraceElements.length >= 4)
                return stackTraceElements[4].getMethodName();
            return stackTraceElements[2].getMethodName();
        } else {
            return "Unknown";
        }
    }
    public void setSteps(){
        test.info(getMethodName());
    }

    private static void addBorderToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '5px solid red'", element);
    }


    public static void myAssertEquals(Object actual , Object expected){
        test.info(MarkupHelper.createLabel("----------- End OF Steps -----------------" , ExtentColor.BLUE));
        test.info(MarkupHelper.createLabel("----------- Actual Result -----------------" , ExtentColor.BLUE));
        test.info(actual.toString()) ;
        test.info(MarkupHelper.createLabel("----------- Expected Result -----------------" , ExtentColor.BLUE));
        test.info(expected.toString());
        Assert.assertEquals(actual,expected);
    }

    public static void myAssertTrue(String actual , String expected){
        test.info(MarkupHelper.createLabel("----------- End OF Steps -----------------" , ExtentColor.BLUE));
        test.info(MarkupHelper.createLabel("----------- Actual Result -----------------" , ExtentColor.BLUE));
        test.info(actual) ;
        test.info(MarkupHelper.createLabel("----------- Expected Result -----------------" , ExtentColor.BLUE));
        test.info(expected);
        Assert.assertTrue(actual.contains(expected));
    }


    protected String generateFakeName(){
        faker = new Faker();
        return faker.name().fullName().toLowerCase().replaceAll("\\s+","") ;
    }
    protected String generateFirstName(){
        faker = new Faker();
        return faker.name().firstName() ;
    }
    protected String generateLastName(){
        faker = new Faker();
        return faker.name().lastName() ;
    }
    protected String generateEmail(){
        faker = new Faker();
        return faker.internet().emailAddress() ;
    }
    protected String generatePassword(){
        faker = new Faker();
        return faker.internet().password(8, 16, true, true, true);
    }


}

