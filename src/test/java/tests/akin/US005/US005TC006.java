package tests.akin.US005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.ReusableMethods;

import java.io.IOException;

public class US005TC006 {//Urun fotosu ekleme Negatif Test
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager Kategori secimini yapar
    5	Store Manager Submit butonuna tiklar
    6	Store Manager ""Please insert Product Title before submit."
                        "Featured img: This field is required."  ve
                        "Gallery Images: This field is required."
                               uyarilarinin ciktigini gorur"
     */
    PearlyMarketPageAkin page;
    @Test
    public void US005TC006() throws IOException {
        page = new PearlyMarketPageAkin();
        Login.login();
        page.signOutButton.click();
        ReusableMethods.jsScrollClick(page.storeManager);
        ReusableMethods.jsScrollClick(page.products);
        page.addNewButton.click();
        ReusableMethods.jsScrollClick(page.electronicsKategorisi);
        ReusableMethods.jsScrollClick(page.submitButton);
        Assert.assertTrue(page.uyariYazisiNegatifTest.isDisplayed());
        ReusableMethods.getScreenshotWebElement("negatifTest",page.uyariYazisiNegatifTest);





    }
}
