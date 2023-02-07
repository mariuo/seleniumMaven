package testCas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GoodiezHomePage;
import pages.MilkshakePage;
import pages.OrderPage;
import pages.PickUpPage;

public class SuiteTestGoodiezHomePage {
    protected WebDriver driver;
    private GoodiezHomePage goodiezHomePage;
    private OrderPage orderPage;
    private PickUpPage pickUpPage;
    private MilkshakePage milkshakePage;
    private JavascriptExecutor js;

    @BeforeTest
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        goodiezHomePage = new GoodiezHomePage(driver);
        js = (JavascriptExecutor) driver;
    }

    @Test(priority = 1, description = "TestCas01")
    public void homePageTitleShouldBeCorrect() throws Exception {
        goodiezHomePage.openPage();

        String result = goodiezHomePage.getTitle();
        String expect = "Goodiez Bubble Tea And Snacks | L'Île-Perrot, Montreal";

        Assert.assertEquals(result, expect);
    }

    @Test(priority = 2, description = "TestCas02")
    public void milkshakePageShouldHaveCorrectAddress() throws Exception {
        String expect = "101 Grand Boulevard L'Île-Perrot,\nQC J7V 4W7";

        goodiezHomePage.openPage();
        js.executeScript("window.scrollTo(0,1068)");
        Thread.sleep(400);
        milkshakePage = goodiezHomePage.navigateToButtonMilkshake();
        String result = milkshakePage.getAddress();

        Assert.assertEquals(result, expect);
    }


    @Test(priority = 3, description = "TestCas03")
    public void milkshakePageShouldHaveCorrectTitle() throws Exception {
        String expect = "Goodiez Bubble Tea and Snacks (101 Grand Boulevard) Delivery & Takeout in L'Île-Perrot | Menu & Prices | Caviar";

        goodiezHomePage.openPage();
        js.executeScript("window.scrollTo(0,1068)");
        Thread.sleep(400);
        milkshakePage = goodiezHomePage.navigateToButtonMilkshake();
        Thread.sleep(200);
        pickUpPage = milkshakePage.navigateToButtonPickUp();
        Thread.sleep(200);
        String result = pickUpPage.getTitle();

        Assert.assertEquals(expect, result);
    }

    @Test(priority = 4, description = "TestCas04")
    public void orderPageShouldBeCorrectPriceOrder() throws Exception {
        String expect = "CA$7.99";

        goodiezHomePage.openPage();
        orderPage = goodiezHomePage.navigateToButtonOrdre();
        Thread.sleep(400);
        String result = orderPage.getPriceOrdre();

        Assert.assertEquals(expect, result);

    }

    @AfterTest
    public void close() throws Exception {
        goodiezHomePage.closePage();
    }

}
