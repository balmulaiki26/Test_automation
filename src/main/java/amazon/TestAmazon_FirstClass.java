package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAmazon_FirstClass {

    //xpath strategy
    //tag[@key='value']
    //tag[@key='value' and @key='value']

    public static WebDriver driver;

    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
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

    @Test
    public void clickOnAccount() {
        driver.findElement(By.id("nav-link-accountList")).click();
    }

    @Test
    public void clickOnOrders() {
        driver.findElement(By.id("nav-orders")).click();
    }

    @Test
    public void searchForBooks() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Books");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Go']")).click();
    }

}
