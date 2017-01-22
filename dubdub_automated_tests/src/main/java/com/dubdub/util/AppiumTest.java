package com.dubdub.util;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.SauceOnDemandTestWatcher;
import com.saucelabs.saucerest.SauceREST;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class AppiumTest implements SauceOnDemandSessionIdProvider {

    private IOSDriver driver;

    /**
     * wait wraps Helpers.wait *
     */
    public static WebElement wait(By locator) {
        return Helpers.wait(locator);
    }


    private boolean runOnSauce = System.getProperty("sauce") != null;

    /**
     * Authenticate to Sauce with environment variables SAUCE_USER_NAME and SAUCE_API_KEY *
     */
    private SauceOnDemandAuthentication auth = new SauceOnDemandAuthentication();

    /**
     * Report pass/fail to Sauce Labs *
     */
    // false to silence Sauce connect messages.
    public
    @Rule
    SauceOnDemandTestWatcher reportToSauce = new SauceOnDemandTestWatcher(this, auth, false);

    private String sessionId;

    /**
     * Keep the same date prefix to identify job sets. *
     */
    private static final Date date = new Date();

    @Rule
    public TestRule printTests = new TestWatcher() {
        protected void starting(Description description) {
            System.out.print("  test: " + description.getMethodName());
        }

        protected void finished(Description description) {
            final String session = getSessionId();

            if (session != null) {
                System.out.println(" " + "https://saucelabs.com/tests/" + session);
            } else {
                System.out.println();
            }
        }
    };

    /**
     * Run before each test *
     */
    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.5.3");
        capabilities.setCapability("platformVersion", "9.3.4");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "Maru's iPhone");
        //new line of code
        capabilities.setCapability("app", "/Users/dubdub/IdeaProjects/dubdub_automated_tests/dubdub.app");
        capabilities.setCapability("udid", "17c30930daa51c67204ac6be8ceab7ff39d4868a");

        // Set job name on Sauce Labs
        capabilities.setCapability("name", "Java iOS tutorial " + date);
        String userDir = System.getProperty("user.dir");
        String localApp = "dubdub.app";
        if (runOnSauce) {
            String user = auth.getUsername();
            String key = auth.getAccessKey();

            // Upload app to Sauce Labs
            SauceREST rest = new SauceREST(user, key);

            rest.uploadFile(new File(userDir, localApp), localApp);

            capabilities.setCapability("app", "sauce-storage:" + localApp);
            URL sauceURL = new URL("http://" + user + ":" + key + "@ondemand.saucelabs.com:80/wd/hub");
            driver = new IOSDriver(sauceURL, capabilities);
        } else {
            String appPath = Paths.get(userDir, localApp).toAbsolutePath().toString();
            capabilities.setCapability("app", appPath);
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }

        sessionId = driver.getSessionId().toString();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Helpers.init(driver);
    }

    /**
     * Run after each test *
     */
    @After
    public void tearDown() throws Exception {
        if (driver != null) driver.quit();
    }

    /**
     * If we're not on Sauce then return null otherwise SauceOnDemandTestWatcher will error. *
     */
    public String getSessionId() {
        return runOnSauce ? sessionId : null;
    }

    public IOSDriver getDriver(){
        return driver;
    }

    //code for scrolling downwards
    //not fully tested to see if this works.. thats the next task
    public void swipeDownwards(){
        org.openqa.selenium.Dimension d = driver.manage().window().getSize();
        int startx = d.width/2;
        int endx = startx;

        int endy = (int)(d.height *0.9);
        int starty = (int)(d.height * 0.1);

        driver.swipe(startx, 20, endx, 400, 1000);

    }


    //SWIPING: ATTEMPT 3
    //this function will take in a web element and attempt to swipe it right to left.
    public void swipeRightToLeft(WebElement elementToSwipe){

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




    //for debugging purposes
    public void printName(String p){
        System.out.println("\n" + p);
    }


}