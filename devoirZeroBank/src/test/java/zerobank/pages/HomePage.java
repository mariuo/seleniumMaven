package zerobank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;
    static String urlPage = "http://zero.webappsecurity.com";
    private By signInButton = By.xpath("//*[@id=\"signin_button\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(urlPage);
    }

    public LoginPage getLoginPage(){
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
}
