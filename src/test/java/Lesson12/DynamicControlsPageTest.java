package Lesson12;

import BaseObjects.BaseTest;
import PageObject.Herokuapp.DynamicControlsPage;
import org.testng.annotations.Test;

public class DynamicControlsPageTest extends BaseTest {

    @Test
    public void DynamicControlsPage_Test() {
        get(DynamicControlsPage.class)
                .findAndClickCheckbox()
                .clickRemoveButton()
                .verifyCheckboxAndField()
                .clickAndVerify();
    }
}
