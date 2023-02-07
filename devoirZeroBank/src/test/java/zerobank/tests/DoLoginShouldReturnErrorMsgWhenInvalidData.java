package zerobank.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import zerobank.pages.HomePage;
import zerobank.pages.LoginPage;

public class DoLoginShouldReturnErrorMsgWhenInvalidData {
    protected WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private String username;
    private String password;

    @BeforeClass
    public void beforeClass() {
        System.out.println("Test Case 02 - Started...");
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
        System.out.println("Test Case 02 - Ended...");

    }

    @Test(priority = 1, description = "Case 2")
    public void case2() throws Exception {
        username = "username";
        password = "password2";

        loginPage = homePage.getLoginPage();
        Thread.sleep(200);
        boolean result = loginPage.doInvalidLogin(username, password);

        Assert.assertTrue(result);
    }

}
