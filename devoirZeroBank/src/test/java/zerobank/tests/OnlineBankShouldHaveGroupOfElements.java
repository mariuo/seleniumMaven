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

import java.util.Arrays;
import java.util.List;

public class OnlineBankShouldHaveGroupOfElements {
    protected WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private OnlineBankPage onlineBankPage;
    private Dashboard dashboard;
    private String username;
    private String password;

    @BeforeClass
    public void beforeClass() {
        System.out.println("Test Case 04 - Started...");
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
        System.out.println("Test Case 04 - Ended...");

    }


    @Test(priority = 1, description = "Case 4")
    public void case4() throws Exception {
        List<String> listExpect = Arrays.asList("Account Summary", "Account Activity", "Transfer Funds", "Pay Bills", "My Money Map", "Online Statements");
        username = "username";
        password = "password";

        loginPage = homePage.getLoginPage();
        Thread.sleep(100);

        dashboard = loginPage.doLogin(username, password);

        onlineBankPage = dashboard.getOnlineBankPage();
        boolean result = onlineBankPage.getListElements(listExpect);

        Assert.assertTrue(result);
    }

}
