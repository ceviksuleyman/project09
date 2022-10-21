package tests.akin.US006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.ReusableMethods;

public class US006TC007 {//Kozmetik & kisisel kategorisini belirlenebilmeli
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager Kozmetik & kisisel  kategorisini tiklar
    5	Store Manager Kozmetik & kisisel  kategorisini secildigini gorur
     */
    PearlyMarketPageAkin page;

    @Test
    public void US006TC007() {
        page = new PearlyMarketPageAkin();
        Login.login();
        page.signOutButton.click();
        page.storeManager.click();
        page.products.click();
        page.addNewButton.click();
        ReusableMethods.jsScrollClick(page.KozmetikKisisel);
        Assert.assertTrue(page.KozmetikKisisel.isEnabled());

    }
}
