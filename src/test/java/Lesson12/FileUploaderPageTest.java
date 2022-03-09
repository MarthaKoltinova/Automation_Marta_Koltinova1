package Lesson12;

import BaseObjects.BaseTest;
import PageObject.Herokuapp.FileUploadPage;
import org.testng.annotations.Test;

public class FileUploaderPageTest extends BaseTest {

    @Test
    public void fileUploaderPage_Test() {
        get(FileUploadPage.class)
                .sendFileName()
                .clickButton()
                .verifyName();
    }
}
