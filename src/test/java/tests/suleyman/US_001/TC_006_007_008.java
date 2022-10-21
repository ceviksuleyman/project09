package tests.suleyman.US_001;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import tests.methods.VerificationCode;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC_006_007_008 {

    //TC006 TC007 TC008
    //1 - vendor https://pearlymarket.com/ sayfasina gider
    //2 - Register 'a tiklar
    //3 - Acilan pencerede Become A Vendor butonuna tiklar
    //4 - Registration sayfasinda email,password,confirm password 'un gorundugu dogrular
    //5 - Gecerli email adres girer emaile gelen dogrulama kodunu girer
    //6 - Sifreyi sadece rakamlardan, sadece kucuk harflerde ,sadece buyuk harflerden olusturup ayni password ve confirm password'u girer
    //7 - Register Butonuna tiklar
    //8 - 'Password strength should be atleast "Good.' uyarisinin gorundugunu dogrular

    PearlyMarketPageSuleyman page;

    @DataProvider
    public static Object[][] gecersizSifreler() {
        return new Object[][]{
                {"123123123123", "123123123123"},
                {"GECERSIZSIFRE", "GECERSIZSIFRE"},
                {"gecersizsifre", "gecersizsifre"}};
    }


    @Test(dataProvider = "gecersizSifreler")
    public void us001_TC006_007_008(String password, String confirmPassword) {
        page = new PearlyMarketPageSuleyman();

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));

        page.registerHomePage.click();

        page.becomeAVendor.click();

        Assert.assertTrue(page.registerEmailBox.isDisplayed()
                && page.registerPasswordBox.isDisplayed()
                && page.registerConfirmPwdBox.isDisplayed());


        VerificationCode.getEmailCode();

        page.registerPasswordBox.sendKeys(password);
        page.registerConfirmPwdBox.sendKeys(confirmPassword);


        page.registerButton.click();


        ReusableMethods.waitFor(2);
        String expectedText = "Password strength should be atleast \"Good\".";
        String actualText = page.weakPasswordText.getText();
        Assert.assertEquals(actualText, expectedText);

        try {
            ReusableMethods.getScreenshotWebElement("TC006-TC007-TC008-GecersizSifre", page.weakPasswordText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.waitFor(2);

        Driver.quitDriver();
    }
}
