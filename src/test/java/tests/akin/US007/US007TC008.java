package tests.akin.US007;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US007TC008 extends TestBaseRapor  {// Brand Negatif Test
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager Kategori secimini yapar
    5	Store Manager Media Libraryden eklenecek foto secilir Select butonuna tiklar
    6	Store Manager Media Libraryden eklenecek  diger foto secilir ve Add to Gallary botununa tiklar
    7	Store Manager Submit butonuna tiklar
    8	Store Manager "Please insert Product Title before submit." yazisini gorur
     */
    PearlyMarketPageAkin page;
    @Test(groups = "gp3")
    public void US007TC008() throws InterruptedException {
        extentTest = extentReports.createTest("Brand Negatif Test'i belirlenebilmeli", "Negatif Test ");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
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
        page.addNewButton.click();
        ReusableMethods.jsScrollClick(page.fotoEkleme1);
        page.mediaLibrary.click();
        page.foto1.click();
        page.fotoSelectButton.click();
        js.executeScript("arguments[0].click();", page.foto2Ekleme);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", page.foto2);
        Thread.sleep(1000);
        page.fotoAddToGalleryButton.click();
        extentTest.info("Fotograflar eklendi");
        ReusableMethods.jsScrollClick(page.electronicsKategorisi);
        extentTest.info("AddNew butonu secildi");
        ReusableMethods.jsScrollClick(page.submitButton);
        extentTest.info("submit butonu secildi");
        Assert.assertTrue(page.uyariYazisiProduct.isDisplayed());
        extentTest.pass("Uyari Yazisi goruldu");
        Driver.closeDriver();




    }
}
