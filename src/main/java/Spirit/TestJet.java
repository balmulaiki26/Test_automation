package Spirit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestJet {

    public static void main(String[]args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com");

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);

        for(int i=1;i<5;i++)

        {
            driver.findElement(By.id("hrefIncAdt")).click();

        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
    }

}

