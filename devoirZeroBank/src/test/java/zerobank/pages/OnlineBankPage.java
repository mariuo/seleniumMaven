package zerobank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OnlineBankPage {
    private By elements = By.id("online_banking_features");
    protected WebDriver driver;

    public OnlineBankPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public boolean getListElements(List<String> listExpect){
        List<WebElement> elementList = driver.findElements(elements);

        elementList = elementList.stream().sorted().collect(Collectors.toList());
        listExpect = listExpect.stream().sorted().collect(Collectors.toList());
        List<String> newResult = new ArrayList<>();

        for (WebElement ele : elementList){
            for (String st : listExpect){
                if(ele.getText().contains(st)){
                    newResult.add(st);
                }
            }
        }
        return newResult.size() == listExpect.size();

    }
}
