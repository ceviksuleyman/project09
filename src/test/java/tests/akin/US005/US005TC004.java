package tests.akin.US005;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;

public class US005TC004 {//Urun fotosu eklenebilmeli
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager acilan pencerede photo ustune tiklar
    5	Store Manager Media Libraryden eklenecek foto secilir Select butonuna tiklar
    6	Store Manager Media Libraryden eklenecek  diger foto secilir ve Add to Gallery botununa tiklar
    7	Store Manager fotograflari eklendigini gorur
     */
    PearlyMarketPageAkin page;

    @Test
    public void US005TC004() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        page = new PearlyMarketPageAkin();
        Login.login();
        page.signOutButton.click();
        page.storeManager.click();
        page.products.click();
        page.addNewButton.click();
        page.fotoEkleme1.click();
        page.mediaLibrary.click();
        page.foto1.click();
        page.fotoSelectButton.click();
        js.executeScript("arguments[0].click();", page.foto2Ekleme);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", page.foto2);
        Thread.sleep(1000);
        page.fotoAddToGalleryButton.click();
        Assert.assertTrue(page.fotoEkleme1.isDisplayed() &&page.foto2Ekleme.isDisplayed());












    }
}
