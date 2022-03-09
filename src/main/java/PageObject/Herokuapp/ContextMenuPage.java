package PageObject.Herokuapp;


import PageObject.BasePage;
import PageObject.Herokuapp.FileUploadPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContextMenuPage extends BasePage {
    private By field = By.id("hot-spot");

    public ContextMenuPage rightClick() {
        actions.contextClick(driver.findElement(field)).perform();
        return this;
    }

    public ContextMenuPage verifyAlertText() {
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "You selected a context menu");
        return this;
    }

    public ContextMenuPage closeAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    @Override
    public void verifyPage() {

    }
}