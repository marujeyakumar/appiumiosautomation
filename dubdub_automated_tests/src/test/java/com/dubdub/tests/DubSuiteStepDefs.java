package com.dubdub.tests;
import com.dubdub.page.DubSuitePage;

import com.dubdub.util.AppiumTest;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maru Jeyakumar on 2016-08-22.
 */
public class DubSuiteStepDefs {

    private DubSuitePage page;

    private AppiumTest testBed;
    /*****************************************************************************************/
    @Before()
    public void setUp() throws Throwable{
        testBed = new AppiumTest();
        testBed.setUp();
        page = new DubSuitePage();
    }

    /*****************************************************************************************/
    @Given("^I import a video to a track$")
    public void iImportAVideoToATrack() throws Throwable {

        page.navigateToDubSuite();
        page.importTheFirstVideoToTheTrack();

    }

    @Given("^I import an image to a track$")
    public void iImportAnImageToATrack() throws Throwable {
        page.navigateToDubSuite();
        page.importTheFirstImageToTheTrack();

    }

    @Given("^I Import text to a track$")
    public void iImportTextToATrack() throws Throwable {
        page.navigateToDubSuite();
        page.importTextToTheFirstTrack();
    }

    @Given("^I import device music to a track$")
    public void iImportDeviceMusicToATrack() throws Throwable {
        page.navigateToDubSuite();
        page.importMusicToTheFirstTrack();
    }

    @Given("^I import dubsound to a track$")
    public void iImportDubsoundToATrack() throws Throwable {
        page.navigateToDubSuite();
        page.importDubSoundToTheFirstTrack();
    }

    /*****************************************************************************************/

    @And("^I import dubsound to the second track$")
    public void iImportDubsoundToTheSecondTrack() throws Throwable {
      page.importDubSoundToTheSecondTrack();
    }

    @And("^I import text to the second track$")
    public void iImportTextToTheSecondTrack() throws Throwable {
       page.importTextToTheSecondTrack();
    }

    @And("^I import an image to the second track$")
    public void iImportAnImageToTheSecondTrack() throws Throwable {

        page.importImageToTheSecondTrack();

    }
    @And("^I import a video to the second track$")
    public void iImportAVideoToTheSecondTrack() throws Throwable {
        page.importVideoToSecondTrack();
    }

    @And("^I press and hold to mix a second segment$")
    public void iPressAndHoldToMixASecondSegment() throws Throwable {
        page.mixSecondTrackForFiveSeconds();
    }
    /*****************************************************************************************/
    @When("^I press and hold to mix a segment$")
    public void iPressAndHoldToMixASegment() throws Throwable {
        page.mixVideoForFiveSeconds();
    }
    /*****************************************************************************************/

    @Then("^the video segment gets committed to the mix$")
    public void theVideoSegmentGetsCommittedToTheMix() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(page.checkIfFiveSecondsWasMixed(),true);
    }

    @Then("^the image segment gets committed to the mix$")
    public void theImageSegmentGetsCommittedToTheMix() throws Throwable {
        assertEquals(page.checkIfFiveSecondsWasMixed(),true);
    }

    @Then("^the text segment gets committed to the mix$")
    public void theTextSegmentGetsCommittedToTheMix() throws Throwable {
        assertEquals(page.checkIfFiveSecondsWasMixed(),true);
    }

    @Then("^the music segment gets committed to the mix$")
    public void theMusicSegmentGetsComittedToTheMix() throws Throwable {
        assertEquals(page.checkIfFiveSecondsWasMixed(),true);
    }
    @Then("^the dubsound segment gets committed to the mix$")
    public void theDubsoundSegmentGetsCommittedToTheMix() throws Throwable {
        assertEquals(page.checkIfFiveSecondsWasMixed(),true);
    }

    @Then("^it will mix successfully$")
    public void itWillMixSuccessfully() throws Throwable {
        assertEquals(page.checkIfFiveSecondsWasMixed(),true);
    }
    /*****************************************************************************************/

    @After()
    public void tearDown() throws Throwable{
        testBed.tearDown();
    }


    @And("^I import dubsound to the third track$")
    public void iImportDubsoundToTheThirdTrack() throws Throwable {
        page.importDubSoundToTheThirdTrack();
    }


    @Then("^it will mix for (\\d+) seconds sucessfully$")
    public void itWillMixForSecondsSucessfully(int arg0) throws Throwable {

        assertEquals(page.checkIfMixed(arg0),true);
    }
}
