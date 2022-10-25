package tests.akin.US007;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US007TC004 extends TestBaseRapor {// NSB urunun brandi belirlenebilmeli
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
        extentTest = extentReports.createTest("NS8 brand'i belirlenebilmeli", "NS8 ");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        page = new PearlyMarketPageAkin();
        Login.login();
        extentTest.info("Login olundu");
        page.signOutButton.click();
        ReusableMethods.jsScrollClick(page.storeManager);
        extentTest.info("StoreManager 'a gidildi");
        ReusableMethods.jsScrollClick(page.products);
        extentTest.info("Products 'a gidildi");
        page.addNewButton.click();
        extentTest.info("AddNew butonu secildi");
        js.executeScript("arguments[0].click();", page.NS8);
        extentTest.info("NS8 brand'i secildi");
        Assert.assertTrue(page.NS8.isDisplayed());
        extentTest.pass("NS8 brand'in secildigi goruldu");
        Driver.closeDriver();

    }
}
