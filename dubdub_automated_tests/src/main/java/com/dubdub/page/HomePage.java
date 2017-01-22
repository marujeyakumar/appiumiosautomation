package com.dubdub.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;

public class HomePage extends PageBase {
    public boolean checkIfCreateIsPresentWithAGivenLabel(String label){
        WebElement element = wait(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"));
        return element.getAttribute("label").equals(label);
    }
    public boolean checkIfWatchIsPresentWithAGivenLabel(String label){
        WebElement element = wait(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
        return element.getAttribute("label").equals(label);
    }
    public boolean checkIfButtonIsPresentWithAGivenLabel(String label){
        if (label.equals("create"))
            return checkIfCreateIsPresentWithAGivenLabel(label);
        else
            return checkIfWatchIsPresentWithAGivenLabel(label);
    }
    public boolean checkIfTabBarHasGivenNumberOfButtons(int noOfButtons){
        IOSDriver driver = getDriver();
        WebElement element = wait(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]"));
        List<WebElement> elements = element.findElements(By.className("UIAButton"));
        return elements.size() == noOfButtons;
    }
    public boolean checkIfHomeButtonIsHighlighted(){
        WebElement element = wait(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]"));
        return element.getAttribute("value").equals("1");
    }
    public boolean isHomePageLoaded(){
        return checkIfCreateIsPresentWithAGivenLabel("create")
                && checkIfWatchIsPresentWithAGivenLabel("watch")
                && checkIfTabBarHasGivenNumberOfButtons(4)
                && checkIfHomeButtonIsHighlighted();
    }
}

