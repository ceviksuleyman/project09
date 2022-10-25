package tests.akin.US006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US006TC009 extends TestBaseRapor {//Oyuncak kategorisini belirlenebilmeli
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager Oyuncak  kategorisini tiklar
    5	Store Manager Oyuncak  kategorisini secildigini gorur
     */
    PearlyMarketPageAkin page;

    @Test
    public void US006TC009() {
        extentTest = extentReports.createTest("Oyuncak kategorisini belirlenebilmeli", "Oyuncak ");
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
        ReusableMethods.jsScrollClick(page.Oyuncak);
        extentTest.info("Oyuncak kategorisi secildi");
        Assert.assertTrue(page.Oyuncak.isEnabled());
        extentTest.pass("Oyuncak'ın secildigi goruldu");
        Driver.closeDriver();


    }
}
