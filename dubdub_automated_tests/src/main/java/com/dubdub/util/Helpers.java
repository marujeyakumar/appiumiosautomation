package com.dubdub.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public abstract class Helpers {

    private static IOSDriver driver;
    private static WebDriverWait driverWait;

    /**
     * Initialize the webdriver. Must be called before using any helper methods. *
     */
    public static void init(IOSDriver webDriver) {
        driver = webDriver;
        int timeoutInSeconds = 60;
        // must wait at least 60 seconds for running on Sauce.
        // waiting for 30 seconds works locally however it fails on Sauce.
        driverWait = new WebDriverWait(webDriver, timeoutInSeconds);
    }

    /**
     * Wrap WebElement in MobileElement *
     */
/*  private static WebElement w(WebElement element) {
    return (RemoteWebElement) element, driver);
  }*/

    /**
     * Wrap WebElement in MobileElement *
     */
    private static List<MobileElement> w(List<WebElement> elements) {
        List list = new ArrayList(elements.size());
        for (WebElement element : elements) {
            list.add((element));
        }

        return list;
    }

    /**
     * Return an element by locator *
     */
    public static WebElement element(By locator) {
        return (driver.findElement(locator));
    }

    /**
     * Return a list of elements by locator *
     */
    public static List<MobileElement> elements(By locator) {
        return w(driver.findElements(locator));
    }

    /**
     * Press the back button *
     */
    public static void back() {
        driver.navigate().back();
    }

    /**
     * Return a list of elements by tag name *
     */
    public static List<MobileElement> tags(String tagName) {
        return elements(for_tags(tagName));
    }

    /**
     * Return a tag name locator *
     */
    public static By for_tags(String tagName) {
        return By.className(tagName);
    }

    /**
     * Return a static text element by xpath index *
     */
    public static WebElement text(int xpathIndex) {
        return element(for_text(xpathIndex));
    }

    /**
     * Return a static text locator by xpath index *
     */
    public static By for_text(int xpathIndex) {
        return By.xpath("//UIAStaticText[" + xpathIndex + "]");
    }

    /**
     * Return a static text element that contains text *
     */
    public static WebElement text(String text) {
        return element(for_text(text));
    }

    /**
     * Return a static text locator that contains text *
     */
    public static By for_text(String text) {
        String up = text.toUpperCase();
        String down = text.toLowerCase();
        return By.xpath("//UIAStaticText[@visible=\"true\" and (contains(translate(@name,\"" + up
                + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@hint,\"" + up
                + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@label,\"" + up
                + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@value,\"" + up
                + "\",\"" + down + "\"), \"" + down + "\"))]");
    }

    /**
     * Return a static text element by exact text *
     */
    public static WebElement text_exact(String text) {
        return element(for_text_exact(text));
    }

    /**
     * Return a static text locator by exact text *
     */
    public static By for_text_exact(String text) {
        return By.xpath("//UIAStaticText[@visible=\"true\" and (@name=\"" + text
                + "\" or @hint=\"" + text + "\" or @label=\"" + text
                + "\" or @value=\"" + text + "\")]");
    }

    /**
     * Wait 30 seconds for locator to find an element *
     */
    public static WebElement wait(By locator) {
        return (driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    /**
     * Wait 60 seconds for locator to find all elements *
     */
    public static List<MobileElement> waitAll(By locator) {
        return w(driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)));
    }
    public static IOSDriver getDriver(){
        return driver;
    }
}