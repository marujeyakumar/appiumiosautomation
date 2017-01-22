package com.dubdub.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;

//This class is the page that tests the dubsuite
// Goal is to write up around 20 or so mix scenarios that test the dubsuite
// The first thing to do is to write a quick function that swipes through those darn onboarding pages :)

public class DubSuitePage extends PageBase{

    public static final int numOfOnboardingScreens = 5;

    //This function will be called to swipe through the onboarding screens
    public void swipeThroughTheOnboardingScreens(IOSDriver driver){
        //Now swipe through onboarding screens
        for(int i = 1; i < numOfOnboardingScreens; i++){
            WebElement elementToSwipe = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAImage[1]"));
            swipeRightToLeft(elementToSwipe);
        }

        //Press the start button to get to the mix screen
        WebElement we = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAButton[1]"));
        driver.tap(1, we, 2);
    }

    //This function navigates to the dubsuite in the app
    public void navigateToDubSuite(){

        IOSDriver driver = getDriver();

        //press the create button
        wait(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).click();

        //press the create new dub button
        wait(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();

        //call the fucntion to swipe through the screens
        swipeThroughTheOnboardingScreens(driver);
    }

    //This function will import the first video to the track
    public void importTheFirstVideoToTheTrack(){
        IOSDriver driver = getDriver();

        //Import something new
        WebElement plusButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]"));
        driver.tap(1, plusButton, 2);

        //Selecting video as an option to import
        WebElement videoButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[16]"));
        driver.tap(1, videoButton, 2);

        //Selecting a video which will be imported
        //Specifically this will import the first video that appear on the screen
        WebElement videoToImport = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]"));
        driver.tap(1, videoToImport, 2);

        //Press the done button
        WebElement doneButton = driver.findElement(By.xpath("  //UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]"));
        driver.tap(1, doneButton, 2);
    }

    //This function will import a text to the first track
    public void importTextToTheFirstTrack(){
        IOSDriver driver = getDriver();

        //Import something new
        WebElement plusButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]"));
        driver.tap(1, plusButton, 2);

        //Selecting text as the option to import
        WebElement textOption = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[19]"));
        driver.tap(1, textOption, 2);

    }

    //This function will import the first Image to a track
    public void importTheFirstImageToTheTrack(){

        IOSDriver driver = getDriver();

        //Import something new
        WebElement plusButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]"));
        driver.tap(1, plusButton, 2);

        //Selecting Image as the option to import
        //UIAApplication[1]/UIAWindow[1]/UIAButton[20]
        WebElement imageButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[20]"));
        driver.tap(1, imageButton, 2);

        //Select an Image to be imported
        //Specifically, this will import the first image that appears on the screen
        //UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]
        WebElement imageToImport = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]"));
        driver.tap(1, imageToImport, 2);

        //Press the done button
        WebElement doneButton = driver.findElement(By.xpath("  //UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]"));
        driver.tap(1, doneButton, 2);
    }

    public void importMusicToTheFirstTrack(){
        IOSDriver driver = getDriver();

        //Import Something new
        WebElement plusButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]"));
        driver.tap(1, plusButton, 2);

        //SElecting music as the option to Import
        //UIAApplication[1]/UIAWindow[1]/UIAButton[21]
        WebElement musicButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[21]"));
        driver.tap(1, musicButton, 2);

        //Selecting the Songs option
        //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]
        WebElement songsOption = driver.findElement(By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]"));
        driver.tap(1, songsOption, 2);

        //Selecting the first song
        //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]
        WebElement firstSong = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]"));
        driver.tap(1, firstSong, 2);

        //Press the done button to complete the import
        //UIAApplication[1]/UIAWindow[1]/UIAButton[2]
        WebElement doneButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
        driver.tap(1, doneButton, 200);
    }

    public void importDubSoundToTheFirstTrack(){

        IOSDriver driver = getDriver();

        //Import Something new
        WebElement plusButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]"));
        driver.tap(1, plusButton, 2);

        //Selecting dubsound as the option to import
        //Import Something new
        WebElement dubSoundOption = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[22]"));
        driver.tap(1, dubSoundOption, 2);

        //Choosing Amore Moderner to download and import
        WebElement amoreModerner = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[2]"));
        driver.tap(1, amoreModerner, 2);

    }

    public void importDubSoundToTheSecondTrack() {

        IOSDriver driver = getDriver();
        //xpath for second plus button
        //UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[9]

        //Import Something to the SECOND track
        WebElement plusButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[9]"));
        driver.tap(1, plusButton, 2);

        //Choose dubsound as the option to import
        WebElement dubSoundOption = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[22]"));
        driver.tap(1, dubSoundOption, 2);

        //Choosing Amore Moderner to download and import
        WebElement amoreModerner = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[2]"));
        driver.tap(1, amoreModerner, 2);

    }

    public void importDubSoundToTheThirdTrack() {
        IOSDriver driver = getDriver();

        //Import Something to the THIRD track
        WebElement plusButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[9]"));
        driver.tap(1, plusButton, 2);

        //Chose dubsound as the option to import
        WebElement dubSoundOption = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[22]"));
        driver.tap(1, dubSoundOption, 2);

        //Chose Amore Mordor to download and import
        WebElement amoreModerner = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[2]"));
        driver.tap(1, amoreModerner, 2);




    }

    public void importTextToTheSecondTrack() {

        IOSDriver driver = getDriver();

        //Import Something to the SECOND track
        WebElement plusButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[9]"));
        driver.tap(1, plusButton, 2);

        //Selecting text as the option to import
        WebElement textOption = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[19]"));
        driver.tap(1, textOption, 2);

        WebElement screen = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]"));
        swipeUpToDown(screen);


        WebElement typeSomeText = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[2]"));
        doubleTap(typeSomeText);

    }

    public void importImageToTheSecondTrack() {
        IOSDriver driver = getDriver();

        //Import Something to the SECOND track
        WebElement plusButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[9]"));
        driver.tap(1, plusButton, 2);

        //Selecting Image as the option to import
        //UIAApplication[1]/UIAWindow[1]/UIAButton[20]
        WebElement imageButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[20]"));
        driver.tap(1, imageButton, 2);

        //Select an Image to be imported
        //Specifically, this will import the first image that appears on the screen
        //UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]
        WebElement imageToImport = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]"));
        driver.tap(1, imageToImport, 2);

        //Press the done button
        WebElement doneButton = driver.findElement(By.xpath("  //UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]"));
        driver.tap(1, doneButton, 2);

        WebElement screen = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]"));
        swipeUpToDown(screen);


    }

    public void importVideoToSecondTrack() {

        IOSDriver driver = getDriver();

        //Import Something to the SECOND track
        WebElement plusButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[9]"));
        driver.tap(1, plusButton, 2);

        ////Selecting video as an option to import
        WebElement videoButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[16]"));
        driver.tap(1, videoButton, 2);

        //Selecting a video which will be imported
        //Specifically this will import the second video that appear on the screen
        WebElement videoToImport = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]"));
        driver.tap(1, videoToImport, 2);

        //Press the done button
        WebElement doneButton = driver.findElement(By.xpath("  //UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]"));
        driver.tap(1, doneButton, 2);

    }

    //This function will press and hold to mix for 5 seconds
    public void mixVideoForFiveSeconds() {
        IOSDriver driver = getDriver();

        //Press and Hold to mix
        WebElement mixButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]"));
        //The app has an approx 1 second delay before the Mixing Actually Starts!
        //So if you want to mix for 5s, you need to pass 5000ms + 1000 ms delay into driver.tap.
        driver.tap(1, mixButton, 6000);

    }

    //This function will check if five seconds has actually been mixed
    public boolean checkIfFiveSecondsWasMixed(){
        IOSDriver driver = getDriver();
        //jsut a filler code - need to figure out a better validation for mixing.
        WebElement dubsuite = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[7]"));

        //check if we mixed for five seconds
        return(dubsuite.getAttribute("name").equals("5s/89s"));
    }


    public void mixSecondTrackForFiveSeconds() {

        IOSDriver driver = getDriver();
        //Press and hold
//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[8]

        //Press and Hold to mix
        WebElement mixButton = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[8]"));
        //The app has an approx 1 second delay before the Mixing Actually Starts!
        //So if you want to mix for 5s, you need to pass 5000ms + 1000 ms delay into driver.tap.
        driver.tap(1, mixButton, 5000);

    }

    public boolean checkIfMixed(int arg0) {
        IOSDriver driver = getDriver();
        //jsut a filler code - need to figure out a better validation for mixing.
        WebElement dubsuite = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[7]"));

        String secondsStr = String.format("%ss/89s", arg0);
        //check if we mixed for five seconds
        return(dubsuite.getAttribute("name").equals(secondsStr));

    }
}
