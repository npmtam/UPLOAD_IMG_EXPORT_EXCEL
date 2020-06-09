package testcases;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.reporters.jq.SuitePanel;
import pageObjects.UploadPO;

public class TC01_ScanAndUpload extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private UploadPO uploadPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeTest(String browserName) {
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);
        driver.get(Constants.UPLOAD_URL);
    }

//    {"source", "price", "style", "color", "size"}
//    @Parameters()
    @Test
    public void uploadImg(){
        uploadPage = PageGeneratorManager.getUploadPage(driver);
        uploadPage.clickToNoSignatureOption();
        uploadPage.scanImageInFolder("C:\\Attachments\\img");
        uploadPage.uploadImg(uploadPage.fileList);

    }
}
