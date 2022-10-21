package tests.akin.US005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;

public class US005TC003 {//Urun ismi ekle  product title, satis Fiyati
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager Product Title sekmesine tiklar ve urun ismi yazar
    5	Store Manager Price($)  sekmesine  tiklar ve fiyat yazar
    6	Store Manager fiyat girilebildigini gorur

     */
    PearlyMarketPageAkin page;
    @Test
    public void US005TC003() {
        page = new PearlyMarketPageAkin();
        Login.login();
        page.signOutButton.click();
        page.storeManager.click();
        page.products.click();
        page.addNewButton.click();
        page.productTitle.sendKeys("Xiaomi");
        page.priceGirisi.sendKeys("800");
        Assert.assertTrue(page.productTitle.isDisplayed()&&page.priceGirisi.isDisplayed());

    }
}
