package amazon;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver;

    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void captureScreenshot(String testcaseName) {
        DateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy-HH.mm.ss");
        Date date = new Date();
        String uniqueName = dateFormat.format(date);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //System.out.println(System.getProperty("user.dir"));
        //System.out.println(System.getProperty("user.dir") + "/screenshots/" + name + ".png");
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/" + testcaseName + uniqueName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }

    @AfterTest(alwaysRun = true)
    public void close() {
        driver.close();
        driver.quit();
    }

    public void clickOnElementByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void clickOnElementById(String locator) {
        driver.findElement(By.id(locator)).click();
    }


    public void typeOnElementByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void typeOnElementById(String locator, String value) {
        driver.findElement(By.id(locator)).sendKeys(value);
    }

   /* public String getValueByXpath(String locator){
        String value = driver.findElement(By.xpath(locator)).getText();
        return value;
    }*/

    public String getValueByXpath(String locator) {
        return driver.findElement(By.xpath(locator)).getText();
    }

    public boolean isElementDisplayed(String locator) {
        return driver.findElement(By.xpath(locator)).isDisplayed();
    }

    public boolean isElementEnabled(String locator) {
        boolean flag = true;
        flag = driver.findElement(By.xpath(locator)).isEnabled();
        return flag;
    }

    public boolean isElementSelected(String locator) {
        boolean flag = true;
        flag = driver.findElement(By.xpath(locator)).isSelected();
        return flag;
    }

    public WebElement getElement(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element;
    }
    //ClassWork
    //sendkeys
    //clickBy Class,cssSelector,linktext,partialLinkText
}
