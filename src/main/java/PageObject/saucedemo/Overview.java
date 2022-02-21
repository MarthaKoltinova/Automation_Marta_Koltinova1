package PageObject.saucedemo;
import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Overview extends BasePage{
    private By finishButton = By.id("finish");

    protected Overview(WebDriver driver) {
        super(driver);
    }
    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
    }


