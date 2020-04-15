package amazon;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon extends CommonAPI {

    @Test
    public void clickOnAccount() {
        clickOnElementById("nav-link-accountList");
        sleepFor(5);
    }

    @Test
    public void clickOnOrders() {
        clickOnElementById("nav-orders");
    }

    @Test
    public void searchForBooks() {
        typeOnElementById("twotabsearchtextbox", "Java Books");
        captureScreenshot("searchForBooks_");
        clickOnElementByXpath("//input[@type='submit' and @value='Go']");
    }

    @Test
    public void todaysDealTest() {
        String value = getValueByXpath("//a[@href='/gp/goldbox?ref_=nav_cs_gb_azl']");
        System.out.println(value);
        //Assert.assertEquals(actual,expected);
        Assert.assertEquals(value, "Today's Deals");

        boolean flag = isElementDisplayed("//a[@href='/gp/goldbox?ref_=nav_cs_gb_azl']");

        Assert.assertEquals(flag, false);
    }
}