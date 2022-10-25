package tests.akin.US006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US006TC003 extends TestBaseRapor {//Elektrik & Elektronik kategorisini belirlenebilmeli
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager Elektrik & Elektronik  kategorisini tiklar
    5	Store Manager Elektrik & Elektronik  kategorisini secildigini gorur
     */
    PearlyMarketPageAkin page;

    @Test
    public void US006TC003() {
        extentTest = extentReports.createTest("Elektrik & Elektronik kategorisini belirlenebilmeli", "Cok satanlar ");

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
        ReusableMethods.jsScrollClick(page.elektrikElektronik);
        extentTest.info("Elektrik elektronik  kategorisi secildi");
        Assert.assertTrue(page.elektrikElektronik.isEnabled());
        extentTest.pass("Elektrik elektronik 'ın secildigi goruldu");
        Driver.closeDriver();
    }
}
