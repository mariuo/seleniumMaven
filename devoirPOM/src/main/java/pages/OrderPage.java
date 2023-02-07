package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    protected WebDriver driver;
    protected By priceOrdre = By.xpath("//*[@id=\"__next\"]/main/div/div[1]/div[1]/div/div[1]/header/div[2]/div[2]/div[1]/div/div[1]/div[1]/span");
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getPriceOrdre() {
        return driver.findElement(priceOrdre).getText();
    }
}
