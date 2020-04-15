package Facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestFacebook {

    public static WebDriver driver;

    public void sleepFor(int seconds) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        sleepFor(5);
        driver.close();
        driver.quit();
    }


    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //webDriver is interface that is why its used and there are mulitple driver for web

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://facebook.com");

        //driver = new FirefoxDriver();
    }


    @Test
    public void signIn() {

        setUp();
        driver.findElement(By.id("email")).sendKeys("balmulaiki93");
        driver.findElement(By.id("pass")).sendKeys("12345");
        driver.findElement(By.id("loginbutton")).click();
        close();

    }


    @Test
    public void SignUp(){
        setUp();
        sleepFor(3);
        driver.findElement(By.id("u_0_f")).sendKeys("billal");
        driver.findElement(By.id("u_0_h")).sendKeys("Almulaiki");
        driver.findElement(By.id("u_0_k")).sendKeys("balmulaiki26@gmail.com");
        sleepFor(3);
        driver.findElement(By.id("u_0_n")).sendKeys("balmulaiki26@gmail.com");
        driver.findElement(By.id("u_0_r")).sendKeys("billalalmulaiki");
        driver.findElement(By.id("month")).sendKeys("aug");
        driver.findElement(By.id("day")).sendKeys("1");
        driver.findElement(By.id("year")).sendKeys("1994");
        sleepFor(3);
        driver.findElement(By.id("u_0_a")).click();
        driver.findElement(By.id("u_0_y")).click();
        sleepFor(3);
        close();
    }
@Test
    public void changeLanguage(){
        setUp();
        sleepFor(3);
        driver.findElement(By.xpath("//*[@id=\"pageFooter\"]/ul/li[5]/a")).click();
        sleepFor(3);
        driver.findElement(By.xpath("//*[@id=\"pageFooter\"]/ul/li[2]/a")).click();
        sleepFor(3);
        close();
}

@Test
    public void games(){
        setUp();
        driver.findElement(By.xpath("//*[@id=\"js_0\"]/ul/li[9]/a")).click();
        sleepFor(3);
        driver.findElement(By.xpath("//*[@id=\"u_0_c\"]/div/div[2]/span/div/div[1]/ul/span[2]/a/li")).click();
        sleepFor(3);
        driver.findElement(By.xpath("//*[@id=\"js_1\"]/input")).sendKeys("bingo");
        sleepFor(3);
        driver.findElement(By.className("_5cfc")).click();
        sleepFor(3);
        driver.findElement(By.className("_42ft _4jy0 gdp_button _4jy6 _4jy1 selected _51sy")).click();
        close();

    }


}
