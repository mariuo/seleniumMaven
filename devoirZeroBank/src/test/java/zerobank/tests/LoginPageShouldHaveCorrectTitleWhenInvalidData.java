package zerobank.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import zerobank.pages.Dashboard;
import zerobank.pages.HomePage;
import zerobank.pages.LoginPage;
import zerobank.pages.OnlineBankPage;

public class LoginPageShouldHaveCorrectTitleWhenInvalidData {
    protected WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private OnlineBankPage onlineBankPage;
    private Dashboard dashboard;
    private String username;
    private String password;

    @BeforeClass
    public void beforeClass() {
        System.out.println("Test Case 03 - Started...");
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }


    @BeforeMethod
    public void beforeMethod() throws Exception {
        homePage.openPage();
    }

    @AfterMethod
    public void afterMethod() throws Exception{
        driver.close();
    }
    @AfterTest
    public void afterTest() throws Exception {
        driver.quit();
    }

    @AfterClass
    public void afterClass() throws Exception{
        System.out.println("Test Case 03 - Ended...");

    }

    @Test(priority = 1, description = "Case 3")
    public void case3() throws Exception {
        String expect = "Zero - Free Access to Online Banking";
        username = "username";
        password = "password";

        loginPage = homePage.getLoginPage();
        Thread.sleep(100);

        dashboard = loginPage.doLogin(username, password);

        onlineBankPage = dashboard.getOnlineBankPage();
        String result = onlineBankPage.getTitle();
        Assert.assertEquals(expect, result);
    }

}
