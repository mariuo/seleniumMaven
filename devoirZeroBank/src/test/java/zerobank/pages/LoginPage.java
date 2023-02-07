package zerobank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    protected WebDriver driver;
    private By usernameElem = By.id("user_login");
    private By passwordElem = By.id("user_password");
    private By submitButton = By.cssSelector("#login_form > div.form-actions > input");
    private By errorMsg = By.xpath("//*[@id=\"login_form\"]/div[1]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public Dashboard doLogin(String user, String pass){
        driver.findElement(usernameElem).sendKeys(user);
        driver.findElement(passwordElem).sendKeys(pass);
        driver.findElement(submitButton).click();

        return new Dashboard(driver);
    }
    public boolean hasErrorMsg(){
        return driver.findElement(errorMsg).isDisplayed();
    }
    public boolean doInvalidLogin(String user, String pass){
        driver.findElement(usernameElem).sendKeys(user);
        driver.findElement(passwordElem).sendKeys(pass);
        driver.findElement(submitButton).click();
        return hasErrorMsg();
    }

    public String getTitle(){
        return driver.getTitle();
    }


}
