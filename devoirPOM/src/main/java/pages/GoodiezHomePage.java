package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoodiezHomePage {

    protected WebDriver driver;
    static String urlPage = "https://goodiezbubbletea.com/";
    protected By menuButtonMilkshake = By.xpath("//div[2]/div/div[2]/div/a/div/span");
    protected By menuButtonOrdre = By.xpath("//*[@id=\"post-8\"]/div/div/div/section[2]/div[3]/div/div/section/div/div[2]/div/div/div/div/div/a/span/span[1]/span[2]");
    public GoodiezHomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void openPage() {
        driver.get(urlPage);
    }
    public void closePage() {
        driver.quit();
    }
    public String getTitle() {
        return driver.getTitle();
    }
    public MilkshakePage navigateToButtonMilkshake(){
        driver.findElement(menuButtonMilkshake).click();
        return new MilkshakePage(driver);
    }
    public OrderPage navigateToButtonOrdre() {
        driver.findElement(menuButtonOrdre).click();
        return new OrderPage(driver);
    }


}
