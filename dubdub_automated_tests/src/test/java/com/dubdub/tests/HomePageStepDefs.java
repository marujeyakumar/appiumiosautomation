package com.dubdub.tests;
import com.dubdub.page.HomePage;
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
 * Created by dubdub on 2016-08-21.
 */
public class HomePageStepDefs {
    private HomePage home;
    private AppiumTest testBed;

    @Before()
    public void setUp() throws Throwable{
        testBed = new AppiumTest();
        //testBed.setUp();
        home = new HomePage();
    }

    @Given("^I launch dubdub$")
    public void iLaunchDubdub() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        return;
    }

    @When("^I look at the screen$")
    public void iLookAtTheScreen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        return;
    }

    @Then("^there should be a (.*) button$")
    public void thereShouldBeACreateButton(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(home.checkIfButtonIsPresentWithAGivenLabel(arg0), true);
    }

    @After()
    public void tearDown() throws Throwable{
        testBed.tearDown();
    }

    @And("^tabbar has (\\d+) buttons$")
    public void tabbarHasButtons(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(home.checkIfTabBarHasGivenNumberOfButtons(4),true);
    }

    @And("^home button is highlighted$")
    public void homeButtonIsHighlighted() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(home.checkIfHomeButtonIsHighlighted(),true);
    }
}
