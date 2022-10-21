package tests.akin.US007;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;

public class US007TC004 {// NSB urunun brandi belirlenebilmeli
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager   NS8 brandine tiklar
    5	Store Manager   NS8   brandi belirlendigi gorulur
     */
    PearlyMarketPageAkin page;
    @Test
    public void US007TC004() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        page = new PearlyMarketPageAkin();
        Login.login();
        page.signOutButton.click();
        page.storeManager.click();
        page.products.click();
        page.addNewButton.click();
        js.executeScript("arguments[0].click();", page.NS8);
        Assert.assertTrue(page.NS8.isDisplayed());

    }
}
