package Lesson4;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Lesson4 {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void google() {
       // driver.get("https://www.google.by/");
        driver.manage().window().setSize(new Dimension(1260, 662));
        driver.findElement(By.name("q")).sendKeys("погода минск");
        {
            String value = driver.findElement(By.name("q")).getAttribute("value");
            Assert.assertEquals(value, "погода минск");

        }
        driver.findElement(By.name("q")).clear();
        {
            String value = driver.findElement(By.name("q")).getAttribute("value");
            Assert.assertEquals(value, " ");
        }
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }
}
