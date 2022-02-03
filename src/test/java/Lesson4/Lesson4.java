<<<<<<< HEAD
package Lesson_4;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Lesson_4 {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");

    }


    @Test(priority = 1)
    public void google() {
        driver.manage().window().setSize(new Dimension(1260, 662));
        driver.findElement(By.name("q")).sendKeys("погода минск");
        {
            String value = driver.findElement(By.name("q")).getAttribute("value");
            Assert.assertEquals(value, "погода минск");

        }
        driver.findElement(By.name("q")).clear();
        {
            String value = driver.findElement(By.name("q")).getAttribute("value");
            Assert.assertEquals(value, "");
        }
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Test(priority = 2)
    public void enterMassage() {
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("Привет,Мир!");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        String text=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(text,"Привет, Мир!");

    }
    @Test(priority = 3)
    public void findNothing(){
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("*//*");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        String text=driver.findElement(By.cssSelector("p:nth-child(1)")).getText();
        List<String> results= new ArrayList<>();
        results.add("По запросу *//* ничего не найдено");
        results.add("Па запыце *//* нічога не знойдзена");
        results.add("Your search - *//* - did not match any documents");
        Assert.assertTrue(results.contains(text));

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
=======
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

import java.util.ArrayList;
import java.util.List;


public class Lesson4 {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");

    }


    @Test(priority = 1)
    public void google() {
        driver.manage().window().setSize(new Dimension(1260, 662));
        driver.findElement(By.name("q")).sendKeys("погода минск");
        {
            String value = driver.findElement(By.name("q")).getAttribute("value");
            Assert.assertEquals(value, "погода минск");

        }
        driver.findElement(By.name("q")).clear();
        {
            String value = driver.findElement(By.name("q")).getAttribute("value");
            Assert.assertEquals(value, "");
        }
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Test(priority = 2)
    public void enterMassage() {
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("Привет,Мир!");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        String text=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(text,"Привет, Мир!");

    }
    @Test(priority = 3)
    public void findNothing(){
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("*//*");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        String text=driver.findElement(By.cssSelector("p:nth-child(1)")).getText();
        List<String> results= new ArrayList<>();
        results.add("По запросу *//* ничего не найдено");
        results.add("Па запыце *//* нічога не знойдзена");
        results.add("Your search - *//* - did not match any documents");
        Assert.assertTrue(results.contains(text));

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
>>>>>>> origin/main
