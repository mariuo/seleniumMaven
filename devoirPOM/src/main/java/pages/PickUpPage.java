package pages;

import org.openqa.selenium.WebDriver;

public class PickUpPage {
    protected WebDriver driver;
    public PickUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
