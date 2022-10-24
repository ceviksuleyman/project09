package tests.akin.US007;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;

public class US007TC002 {// Green Grass urunun brandi belirlenebilmeli
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager  Green Grass brandine tiklar
    5	Store Manager  Green Grass   brandi belirlendigi gorulur
     */
    PearlyMarketPageAkin page;
    @Test
    public void US007TC002() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        page = new PearlyMarketPageAkin();
        Login.login();
        page.signOutButton.click();
        ReusableMethods.jsScrollClick(page.storeManager);
        ReusableMethods.jsScrollClick(page.products);
        page.addNewButton.click();
        js.executeScript("arguments[0].click();", page.greenGrass);
        Assert.assertTrue(page.greenGrass.isDisplayed());

    }
}