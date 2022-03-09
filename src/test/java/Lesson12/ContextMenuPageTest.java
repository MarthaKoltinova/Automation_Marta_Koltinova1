package Lesson12;

import BaseObjects.BaseTest;
import PageObject.Herokuapp.ContextMenuPage;
import org.testng.annotations.Test;

public class ContextMenuPageTest extends BaseTest {

    @Test
    public void contextMenuPage_Test() {
        get(ContextMenuPage.class)
                .rightClick()
                .verifyAlertText()
                .closeAlert();
    }
}
