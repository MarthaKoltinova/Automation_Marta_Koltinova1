package Lesson12;

import BaseObjects.BaseTest;
import PageObject.BasePage;
import PageObject.Herokuapp.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Parameters({"linkName"})
    @Test
    public void homePage_Test(String linkName) {
        get(HomePage.class)
                .open(context.getSuite().getParameter("url"))
                .clickLink(Links.valueOf(linkName));
    }
}
