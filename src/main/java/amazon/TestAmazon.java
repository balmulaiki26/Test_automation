package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestAmazon {
    public static WebDriver driver;

    public void sleepFor(int seconds) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        sleepFor(3);
        driver.close();
        driver.quit();
    }


    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //webDriver is interface that is why its used and there are mulitple driver for web

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        //driver = new FirefoxDriver();
    }

    @Test
    public void clickOnAccount() {
        setUp();
        sleepFor(3);
        driver.findElement(By.id("nav-link-accountList")).click();
        close();


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


