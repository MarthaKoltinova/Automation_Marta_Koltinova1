package PageObject.Herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FileUploadPage extends BasePage {
    private By chooseFile = By.id("file-upload");
    private final String fileName = "7 отчет.docx";
    private final String filePath = "C:\\Users\\marta\\IdeaProjects\\Automation_Marta_Koltinova\\src\\main\\java\\File\\";
    private By uploadButton = By.className("button");
    private By uploadedFile = By.id("uploaded-files");

    public FileUploadPage sendFileName() {
        driver.findElement(chooseFile).sendKeys(filePath + fileName);
        return this;
    }

    public FileUploadPage clickButton() {
        click(uploadButton);
        return this;
    }

    public FileUploadPage verifyName() {
        Assert.assertEquals(driver.findElement(uploadedFile).getText(), fileName);
        return this;
    }

    @Override
    public void verifyPage() {

    }
}
