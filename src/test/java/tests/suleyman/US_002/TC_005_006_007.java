package tests.suleyman.US_002;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TC_005_006_007 {

    //1 - vendor  https://pearlymarket.com/ sayfasina gider
    //2 - Sign in'e tiklar
    //3 - Acilan sayfada gecerli email ve sifre girer
    //4 - Sign in butonuna tiklar
    //5 - Acilan sayfada Orders,Downloads,Addresses,Account details,Wishlist,Logout seceneklerinin goruldugunu dogrular

    PearlyMarketPageSuleyman page;

    @Test
    public void us002_TC005() {

        page = new PearlyMarketPageSuleyman();

        List<String> expectedDashboardList = new ArrayList<>(
                Arrays.asList("ORDERS", "DOWNLOADS", "ADDRESSES", "ACCOUNT DETAILS", "WISHLIST", "LOGOUT"));
        Collections.sort(expectedDashboardList);


        Login.login();


        ReusableMethods.jsScrollClick(page.myAccountLink);


        List<WebElement> actualDashboardList = page.myAccountPageList;
        List<String> actualDashboardListString = new ArrayList<>();

        for (WebElement w : actualDashboardList) {

            actualDashboardListString.add(w.getText());
        }
        Collections.sort(actualDashboardListString);
        System.out.println(actualDashboardListString);
        System.out.println(expectedDashboardList);

        for (int i = 0; i < actualDashboardListString.size(); i++) {

            Assert.assertEquals(actualDashboardListString.get(i), expectedDashboardList.get(i));
        }
    }

    int i;

    List<String> expectedList = new ArrayList<>(
            Arrays.asList("Store Manager", "Orders", "Downloads", "Addresses", "Account details", "Wishlist"));

    @Test(dependsOnMethods = "us002_TC005")
    public void us002_TC006() {

        int count = 1;
        for (i = 1; i < 7; i++) {

            System.out.println(count + " -> " + page.dashboardList.get(i).getText());
            count++;
            Assert.assertEquals(page.dashboardList.get(i).getText(), expectedList.get(i - 1));
        }
    }


    List<String> expectedList2 = new ArrayList<>(
            Arrays.asList("Support Tickets", "Followings", "Logout"));

    @Test(dependsOnMethods = "us002_TC006")
    public void us002_TC007() throws IOException {

        ReusableMethods.jsScroll(page.dashBoardList);
        ReusableMethods.getScreenshotWebElement("dashboardSS",page.dashBoardList);

        int count = 7;
        for (i = 7; i < 10; i++) {

            System.out.println(count + " -> " + page.dashboardList.get(i).getText());
            count++;
            Assert.assertEquals(page.dashboardList.get(i).getText(), expectedList2.get(i - 7));
        }

      Driver.getDriver().quit();
    }
}
