package zerobank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
    protected WebDriver driver;

    private String navElem = "pages-nav";

    private By menuOnlineBank = By.xpath("//*[@id=\"onlineBankingMenu\"]/div/strong");

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        driver.get("http://zero.webappsecurity.com/index.html");
    }

    public String contentOnlineBakingNav(){
        return driver.findElement(menuOnlineBank).getText();
    }

    public OnlineBankPage getOnlineBankPage(){
        driver.findElement(menuOnlineBank).click();
        return new OnlineBankPage(driver);
    }

}
