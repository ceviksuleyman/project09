package tests.akin.US005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.ReusableMethods;

public class US005TC002 {//Yeni urun ekle (Add new); urun icin virtual veya downloadable secenegi olmali
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager urun icin virtual veya downloadable secenegi oldugunu gorur
     */
    PearlyMarketPageAkin page;
    @Test
    public void US005TC002() {
        page = new PearlyMarketPageAkin();
        Login.login();
        page.signOutButton.click();
        ReusableMethods.jsScrollClick(page.storeManager);
        ReusableMethods.jsScrollClick(page.products);
        page.addNewButton.click();
        Assert.assertTrue(page.virtualClick.isDisplayed() && page.downloadableClick.isDisplayed());



    }
}
