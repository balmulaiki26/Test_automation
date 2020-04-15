package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAmazon {
    public static WebDriver driver;

    public void sleepFor(int seconds) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @BeforeTest(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //webDriver is interface that is why its used and there are mulitple driver for web

        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        sleepFor(3);

        //driver = new FirefoxDriver();
    }

    @AfterTest(alwaysRun = true)
    public void close() {
        sleepFor(3);
        driver.close();
        driver.quit();
    }
    public void clickOnElementByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public void typeOnElementByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public void typeOnElementById(String locator){
        driver.findElement(By.id(locator)).click();
    }
    public void clickOnElementBycssSelector(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }
    public void clickOnElementBylinkText(String locator){
        driver.findElement(By.linkText(locator)).click();
    }
    public void clickOnElementBypartialLinkText(String locator){
        driver.findElement(By.partialLinkText(locator)).click();
    }
    public void clickOnElementByclassName(String locator){
        driver.findElement(By.className(locator)).click();
    }
    public void clickBy(String locator){

    }
    @Test
    public void clickOnAccount() {
        sleepFor(3);
        driver.findElement(By.id("nav-link-accountList")).click();

    }

    @Test
    public void clickObOrders() {
        setUp();
        driver.findElement(By.id("nav-orders")).click();
        close();

    }

    @Test
    public void searchForBooks() {
        setUp();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Books");
        driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
        close();


    }
    @Test
    public void signIn(){
        setUp();
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys("b_almulaiki@yahoo.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("12234");
        driver.findElement(By.id("signInSubmit")).click();
     close();
    }
}


