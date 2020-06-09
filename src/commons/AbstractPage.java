package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class AbstractPage {
    WebDriver driver;
    WebElement element;
    By by;
    Select select;
    JavascriptExecutor jsExecutor;
    WebDriverWait waitExplicit;
    List<WebElement> elements;
    Set<String> allWindows;
    Actions action;
    long shortTimeout = 3;
    long midTimeout = 5;
    long longTimeout = 30;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
    }

    public void sendKeyToElement(String locator, String value) {
        element = driver.findElement(By.xpath(locator));
        element.clear();
        element.sendKeys(value);
    }

    public void sendKeyToElement(String locator, String[] value) {
        element = driver.findElement(By.xpath(locator));
        element.clear();
        element.sendKeys(value);
    }

    public void sendKeysToElement(String locator, List<String> value) {
        element = driver.findElement(By.xpath(locator));
        element.clear();
        element.sendKeys((CharSequence) value);
    }

    public void waitToElementVisible(String locator) {
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, longTimeout);
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitToElementVisible(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, longTimeout);
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void sleepInSecond(long numberInSecond) {
        try {
            Thread.sleep(numberInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickToElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        element.click();
    }

    public void overideGlobalTimeout(long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }


    public int countElements(String locators) {
        overideGlobalTimeout(shortTimeout);
        elements = driver.findElements(By.xpath(locators));
        overideGlobalTimeout(longTimeout);
        return elements.size();
    }

}
