package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MilkshakePage {

    protected WebDriver driver;
    protected By addressText = By.cssSelector(".elementor-element-8be3fff .elementor-heading-title");
    protected By menuButtonPickUp = By.xpath("//*[@id=\"post-660\"]/div/div/div/section[1]/div/div/div/section/div/div[1]/div/div/div/div/div/a");

    public MilkshakePage(WebDriver driver){
        this.driver = driver;
    }
    public String getAddress() {
        return driver.findElement(addressText).getText();
    }
    public PickUpPage navigateToButtonPickUp() {
        driver.findElement(menuButtonPickUp).click();
        return new PickUpPage(driver);
    }



}
