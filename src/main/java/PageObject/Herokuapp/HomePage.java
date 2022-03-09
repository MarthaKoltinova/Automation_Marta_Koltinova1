package PageObject.Herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

    private By getLink(String text) {
        return By.partialLinkText(text);
    }

    public HomePage open(String url) {
        super.open(url);
        return this;
    }

    @Override
    public void verifyPage() {

    }

    public HomePage clickLink(Links link) {
       driver.findElement(By.partialLinkText(link.getLink())).click();
        return this;
    }


}