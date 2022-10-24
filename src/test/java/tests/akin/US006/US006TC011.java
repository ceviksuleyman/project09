package tests.akin.US006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.ReusableMethods;

public class US006TC011 {//Yeni ürünler kategorisini belirlenebilmeli
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager Yeni ürünler kategorisini tiklar
    5	Store Manager Yeni ürünler kategorisini secildigini gorur
     */
    PearlyMarketPageAkin page;

    @Test
    public void US006TC011() {
        page = new PearlyMarketPageAkin();
        Login.login();
        page.signOutButton.click();
        ReusableMethods.jsScrollClick(page.storeManager);
        ReusableMethods.jsScrollClick(page.products);
        page.addNewButton.click();
        ReusableMethods.jsScrollClick(page.YeniUrünler);
        Assert.assertTrue(page.YeniUrünler.isEnabled());

    }
}
