package PageObject.saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CompletePage extends BasePage {
    private By completeHeader = By.className("complete-header");

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(completeHeader).getText(), "THANK YOU FOR YOUR ORDER");
    }
}