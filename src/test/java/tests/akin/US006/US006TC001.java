package tests.akin.US006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.ReusableMethods;

public class US006TC001 {//Besin takviyeleri kategorisini belirlenebilmeli
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager Besin takviyeleri kategorisini tiklar
    5	Store Manager Besin takviyeleri kategorisini secildigini gorur
     */
    PearlyMarketPageAkin page;

    @Test
    public void US006TC001() {
        page = new PearlyMarketPageAkin();
        Login.login();
        page.signOutButton.click();
        page.storeManager.click();
        page.products.click();
        page.addNewButton.click();
        ReusableMethods.jsScrollClick(page.besinTakviyesi);
        Assert.assertTrue(page.besinTakviyesi.isEnabled());

    }
}
