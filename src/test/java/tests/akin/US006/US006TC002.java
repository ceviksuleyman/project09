package tests.akin.US006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US006TC002 extends TestBaseRapor {//Cok satanlar kategorisini belirlenebilmeli
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager Cok satanlar  kategorisini tiklar
    5	Store Manager Cok satanlar  kategorisini secildigini gorur
     */
    PearlyMarketPageAkin page;

    @Test
    public void US006TC002() {
        extentTest = extentReports.createTest("Cok satanlar kategorisini belirlenebilmeli", "Cok satanlar ");
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
        ReusableMethods.jsScrollClick(page.cokSatanlar);
        extentTest.info("Cok satanlar'ın secildi");
        Assert.assertTrue(page.cokSatanlar.isEnabled());
        extentTest.pass("Cok satanlar'ın secildigi goruldu");
        Driver.closeDriver();
    }
}
