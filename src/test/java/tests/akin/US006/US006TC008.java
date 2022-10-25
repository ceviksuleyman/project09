package tests.akin.US006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US006TC008 extends TestBaseRapor {//Moda & Giyim kategorisini belirlenebilmeli
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager Moda & Giyim  kategorisini tiklar
    5	Store Manager Moda & Giyim  kategorisini secildigini gorur
     */
    PearlyMarketPageAkin page;

    @Test(groups = "gp1")
    public void US006TC008() {
        extentTest = extentReports.createTest("Moda & Giyim kategorisini belirlenebilmeli", "Moda & Giyim ");
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
        ReusableMethods.jsScrollClick(page.ModaGiyim);
        extentTest.info("ModaGiyim kategorisi secildi");
        Assert.assertTrue(page.ModaGiyim.isEnabled());
        extentTest.pass("ModaGiyim'ın secildigi goruldu");
        Driver.closeDriver();

    }
}
