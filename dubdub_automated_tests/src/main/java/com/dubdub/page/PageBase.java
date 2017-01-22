package com.dubdub.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dubdub.util.Helpers;

import io.appium.java_client.ios.IOSDriver;

public class PageBase {
    public WebElement wait(By locator) {
        return Helpers.wait(locator);
    }
    public IOSDriver getDriver(){
        return Helpers.getDriver();
    }
 //   public void swipeRightToLeft(WebElement element){ swipeRightToLeft(element);}

    public void swipeRightToLeft(WebElement elementToSwipe){

        IOSDriver driver = getDriver();
        //get the size of the screen
        org.openqa.selenium.Dimension screenSize = driver.manage().window().getSize();


        //Find swipe x points from the screen's width and height
        //find the start X point located at the right side of the screen
        int startX = (int) (elementToSwipe.getSize().width * 0.60);
        //find the endX coordinate located at the left side of the screen
        int endX = (int) (elementToSwipe.getSize().width * 0.20);

        //get the height of the screen
        int yValue = (int)(elementToSwipe.getSize().height / 2);

        //create object of TouchAction class
        TouchAction action_swipe = new TouchAction(driver);

        //Find element on screen to swipe from right to left
        action_swipe.longPress(elementToSwipe,300,300).moveTo(elementToSwipe,100,300).release();
        action_swipe.perform();

    }

    //this function is used to swipe up to down (like in the galaxy)
    public void swipeUpToDown(WebElement elementToSwipe){

        IOSDriver driver = getDriver();

        //Find swipe x points from the element's Width and Height
        int startX = (int)(elementToSwipe.getSize().width * 0.5);
        int endX = startX;
        int startY = (int)(elementToSwipe.getSize().height * 0.7);
        int endY = (int)(elementToSwipe.getSize().height * 0.1);

        //create object of TouchAction class
        TouchAction action_scroll = new TouchAction(driver);


        //Find element on screen to swipe from up to down
        action_scroll.longPress(elementToSwipe,startX,startY).moveTo(elementToSwipe,endX,endY).release();
        action_scroll.perform();

    }

    public void doubleTap(WebElement elementToDoubleTap){

        IOSDriver driver = getDriver();

        //Find the coordinates of where you wanna tap on the element
        int startX = (int)(elementToDoubleTap.getSize().width *0.5);
        int startY = (int)(elementToDoubleTap.getSize().height * 0.5);

        TouchAction actionDoubleTap = new TouchAction(driver);

        actionDoubleTap.tap(startX, startY).tap(0,0).perform();
    }


}