package tests.akin.US007;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US007TC007 extends TestBaseRapor {// Sterling urunun brandi belirlenebilmeli
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager  Sterling brandine tiklar
    5	Store Manager  Sterling   brandi belirlendigi gorulur
     */
    PearlyMarketPageAkin page;
    @Test(groups = "gp3")
    public void US007TC007() {
        extentTest = extentReports.createTest("Sterling brand'i belirlenebilmeli", "Sterling ");
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
        page.addNewButton.click();
        js.executeScript("arguments[0].click();", page.Sterling);
        extentTest.info("Sterling brand'i secildi");
        Assert.assertTrue(page.Sterling.isDisplayed());
        extentTest.pass("Sterling brand'in secildigi goruldu");
        Driver.closeDriver();

    }
}
