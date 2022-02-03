package Lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lesson5 {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    @Test(dataProvider = "data")
    public void test1(FData fData, List<String> expectedData) {

        WebElement roomLength = driver.findElement(By.name("calc_roomwidth"));
        WebElement roomWidth = driver.findElement(By.name("calc_roomheight"));
        WebElement length = driver.findElement(By.name("calc_lamwidth"));
        WebElement width = driver.findElement(By.name("calc_lamheight"));
        WebElement packaged = driver.findElement(By.name("calc_inpack"));
        WebElement price = driver.findElement(By.name("calc_price"));
        WebElement layingDirection = driver.findElement(By.name("calc_direct"));
        Select selectDirection = new Select(layingDirection);
        WebElement rowOffset = driver.findElement(By.name("calc_bias"));
        WebElement retreatFromTheWall = driver.findElement(By.name("calc_walldist"));
        WebElement calcBtn = driver.findElement(By.cssSelector("[type='button']"));
        List<WebElement> results = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-12 whiteback']//div[@class='col-xs-12 col-sm-12']"));

        //Actions
        clearField(roomLength);
        roomLength.sendKeys(fData.roomWidth);
        clearField(roomWidth);
        roomWidth.sendKeys(fData.roomHeight);
        clearField(length);
        length.sendKeys(fData.lamWidth);
        clearField(width);
        width.sendKeys(fData.lamHeight);
        clearField(packaged);
        packaged.sendKeys(fData.inpack);
        clearField(price);
        price.sendKeys(fData.pr);
        selectDirection.selectByIndex(1);
        clearField(rowOffset);
        rowOffset.sendKeys(fData.offset);
        clearField(retreatFromTheWall);
        retreatFromTheWall.sendKeys(fData.retreat);

        calcBtn.click();

        List<String> actualData = new ArrayList<>() {{
            results.forEach((element) -> add(element.getText()));
        }};

        Assert.assertEquals(actualData, expectedData);
    }

    @DataProvider(name = "data")
    private Object[][] getData() {
        FData data1 = new FData("6", "4", "1200", "192", "12", "500", "1", "300", "10");
        FData data2 = new FData("3", "8", "1300", "208", "18", "800", "1", "200", "12");
        FData data3 = new FData("4", "3", "1500", "300", "20", "1000", "1", "250", "15");
        Results results1 = new Results("23.80", "106", "9", "12441", "2", "8");
        Results results2 = new Results("23.74", "93", "6", "23362", "15", "3");
        Results results3 = new Results("11.79", "30", "2", "18000", "10", "7");
        return new Object[][]{
                {data1, results1.getResults()},
                {data2, results2.getResults()},
                {data3, results3.getResults()},
        };
    }

    @AfterTest
    public void close() {
        driver.close();
        driver.quit();
    }
    private void clearField (WebElement element){
        element.click();
        do{
            element.sendKeys(Keys.BACK_SPACE);
        }
        while (!element.getAttribute("value").isEmpty());
    }
}
