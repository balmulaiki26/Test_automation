package ebay;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonAPI_Ebay {
    public static WebDriver driver;

    public static void setup(String url, String os, String browser) {
        if (os.equalsIgnoreCase("mac")) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver(capabilities);
            }
        } else if (os.equalsIgnoreCase("windows")) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver(capabilities);
            }
        }
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void close() {
        driver.close();
        driver.quit();
    }

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

    public void clickOnElementByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void clickOnElementById(String locator) {
        driver.findElement(By.id(locator)).click();
    }

    public void clickOnElementByCssSelector(String locator){
        driver.findElement(By.cssSelector(locator)).click();
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
        boolean flag = true;
        flag = driver.findElement(By.xpath(locator)).isDisplayed();
        return flag;
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
}
