package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class Lesson6 {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void test1() {
        WebElement user = driver.findElement(By.id("user-name"));
        user.sendKeys("standard_user");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.className("submit-button"));
        login.click();
        WebElement link = driver.findElement(By.xpath("//div[contains(text(),'Bolt')]"));
        link.click();
        WebElement addToCart = driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt"));
        addToCart.click();
        WebElement shoppingCartLink = driver.findElement(By.className("shopping_cart_link"));
        shoppingCartLink.click();

        String value = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
        Assert.assertEquals(value, "Sauce Labs Bolt T-Shirt");
        String value1 = driver.findElement(By.className("inventory_item_price")).getText();
        Assert.assertEquals(value1, "$15.99");

    }

    @Test(priority = 2)
    public void above() {
        WebElement continueShopping = driver.findElement(By.id("continue-shopping"));
        continueShopping.click();
        WebElement remove = driver.findElement(By.name("remove-sauce-labs-bolt-t-shirt"));
        driver.findElement(with(By.tagName("button")).above(remove)).click();
    }
    @Test(priority = 3)
    public void below () {
        WebElement remove = driver.findElement(By.name("remove-sauce-labs-bolt-t-shirt"));
        driver.findElement(with(By.tagName("button")).below(remove)).click();
    }
    @Test(priority = 4)
    public void rightOf () {
        WebElement remove = driver.findElement(By.name("remove-sauce-labs-bolt-t-shirt"));
        driver.findElement(with(By.tagName("button")).toRightOf(remove)).click();
    }
    @Test(priority = 5)
    public void leftOf () {
        WebElement light = driver.findElement(By.xpath("//div[contains(text(),'Light')]"));
        driver.findElement(with(By.tagName("div")).toLeftOf(light)).click();
    }
    @Test(priority = 6)
    public void near () {
        WebElement light = driver.findElement(By.xpath("//div[contains(text(),'Light')]"));
        System.out.println(driver.findElement(with(By.tagName("div")).near(light)).getText());
    }
}