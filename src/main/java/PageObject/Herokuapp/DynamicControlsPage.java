package PageObject.Herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DynamicControlsPage extends BasePage {
    private By checkbox = By.xpath("//input[@type='checkbox']");
    private By buttonRemove = By.xpath("//button[@type='button']");
    private By text = By.xpath("//p[@id='message']");
    private By textField = By.xpath("//input[@type='text']");
    private By enableButton = By.xpath("//button[text()='Enable']");
    private By massage =  By.xpath("//*[@id='input-example']/p[@id='message']");

    public DynamicControlsPage findAndClickCheckbox() {
        click(checkbox);
        return this;
    }

    public DynamicControlsPage clickRemoveButton() {
        click(buttonRemove);
        Assert.assertTrue(driver.findElement(text).isDisplayed());
        return this;
    }

    public DynamicControlsPage verifyCheckboxAndField() {
        int numberOfCheckboxes = driver.findElements(checkbox).size();
        Assert.assertEquals(numberOfCheckboxes,0);
        return this;
    }
    public DynamicControlsPage clickAndVerify() {
        click(enableButton);
        Assert.assertTrue(driver.findElement(massage).isDisplayed());
        Assert.assertTrue(driver.findElement(textField).isDisplayed());
        return this;
    }


    @Override
    public void verifyPage() {

    }
}
