package tests.akin.US006;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US006TC012 {//Kategori negatif test
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager acilan pencerede photo ustune tiklar
    5	Store Manager Media Libraryden eklenecek foto secilir Select butonuna tiklar
    6	Store Manager Media Libraryden eklenecek  diger foto secilir ve Add to Gallary botununa tiklar
    7	Store Manager Submit butonuna tiklar
    8	Store Manager "Product cat: This field is required." uyarisinin ciktigini gorur
     */
    PearlyMarketPageAkin page;

    @Test
    public void US006TC012() throws InterruptedException, IOException {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        page = new PearlyMarketPageAkin();
        Login.login();
        page.signOutButton.click();
        ReusableMethods.jsScrollClick(page.storeManager);
        ReusableMethods.jsScrollClick(page.products);
        page.addNewButton.click();
        js.executeScript("arguments[0].click();", page.fotoEkleme1);
        page.mediaLibrary.click();
        page.foto1.click();
        page.fotoSelectButton.click();
        js.executeScript("arguments[0].click();", page.foto2Ekleme);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", page.foto2);
        Thread.sleep(1000);
        page.fotoAddToGalleryButton.click();
        js.executeScript("arguments[0].click();", page.submitButton);
        ReusableMethods.waitForVisibility(page.uyariYazisiProduct,5);
        Assert.assertTrue(page.uyariYazisiProduct.isDisplayed());





    }

}
