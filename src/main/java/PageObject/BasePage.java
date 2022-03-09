package PageObject;

import Configuration.PropertyReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

import static BaseObjects.DriverCreation.getDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Properties properties;
    protected Logger log = Logger.getLogger(BasePage.class);

    protected BasePage() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        this.actions = new Actions(this.driver);
        this.properties = PropertyReader.getProperties();
    }

    public BasePage open() {
        String url = properties.getProperty("url");
        log.debug("Open page " + url);
        driver.get(url);
        return this;
    }

    protected BasePage open(String url) {
        log.debug("Open page " + url);
        driver.get(url);
        return this;
    }

    protected BasePage click(By element) {
        log.debug("Click on " + element);
        driver.findElement(element).click();
        return this;
    }

    protected BasePage clickLink(String linkText) {
        log.debug("Click link " + linkText);
        driver.findElement(By.linkText(linkText)).click();
        return this;
    }

    abstract public void verifyPage();
}
