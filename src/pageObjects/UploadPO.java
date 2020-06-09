package pageObjects;

import com.sun.org.apache.xalan.internal.res.XSLTErrorResources;
import commons.AbstractPage;
import commons.Constants;
import interfaces.UploadPageUI;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UploadPO extends AbstractPage {
    WebDriver driver;
    public ArrayList<String> filesListArray = new ArrayList<String>();
    public String fileList;

    public UploadPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void uploadImg(String filePath){
        waitToElementVisible(UploadPageUI.UPLOAD_BUTTON);
        sendKeyToElement(UploadPageUI.UPLOAD_FIELD, filePath);
        sleepInSecond(4);
    }

    public void clickToNoSignatureOption(){
        waitToElementVisible(UploadPageUI.NO_SIGNATURE_RADIO_BTN);
        clickToElement(UploadPageUI.NO_SIGNATURE_RADIO_BTN);
    }

    public void scanImageInFolder(String filePath){
        File folder = new File(filePath);
        //Implementing FilenameFilter to retrieve only txt files
        FilenameFilter txtFileFilter = new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name) {
                if(name.endsWith(".jpg") || name.endsWith(".jpeg")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        //Passing txtFileFilter to listFiles() method to retrieve only txt files
        File[] files = folder.listFiles(txtFileFilter);

        for (File file : files) {
            System.out.println(file.getName());
            filesListArray.add(filePath + "\\" + file.getName());
            fileList = filesListArray.stream().map(Object::toString).collect(Collectors.joining("\n "));
            System.out.println(fileList);
        }
    }

    public int countFilesToUpload(){
        return countElements(UploadPageUI.FILES_SELECTED_TO_UPLOAD);
    }
}
