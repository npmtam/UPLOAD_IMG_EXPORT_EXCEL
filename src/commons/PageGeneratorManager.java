package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.UploadPO;

public class PageGeneratorManager {
    public static UploadPO getUploadPage(WebDriver driver) {
        return new UploadPO(driver);
    }

//    public static OriginalPO getOriginalPage(WebDriver driver){
//        return new OriginalPO(driver);
//    }
//
//    public static WhatNewPO getWhatNewPage(WebDriver driver){
//        return new WhatNewPO(driver);
//    }
//
//    public static WebsitePO getWebsitePage(WebDriver driver){
//        return new WebsitePO(driver);
//    }
}
