package com.frameium.stepdef.Saleforcepractise;

import com.frameium.genericfunctions.GenericFunctions;
import com.frameium.pageobject.SalesforcePractise.SaleconsoleCompaign;
import com.frameium.stepdef.AutomationExercise.AddtoCartTest;
import com.frameium.stepdef.Hooks;
import com.frameium.stepdef.TestSetUp;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SalesconscampaiTest extends GenericFunctions {
    private static final Logger log = LoggerFactory.getLogger(AddtoCartTest.class);
    private WebDriver driver;
    TestSetUp setUp;
    Hooks hook = new Hooks();
    private SaleconsoleCompaign salescons;
    private GenericFunctions genericFunctions;
    private String ExpctdcampaignName = "Flash";
    private String expCampaignName;

    public SalesconscampaiTest(TestSetUp setUp){
        this.setUp = setUp;
        salescons = new SaleconsoleCompaign(setUp.baseTest.getDriver());
        genericFunctions = new GenericFunctions(setUp.baseTest.getDriver());
    }

    @Then("user navigate the url  {string}")
    public String userNavigateTheUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("driver----->" + driver);
        return url;


    }


    @And("I navigate to the saleconsole tab")
    public void iNavigateToTheSaleconsoleTab() throws InterruptedException{
        salescons.saleconsolepage();
    }

    @Then("User selecting the campaign from the sale dropdown")
    public void userSelectingTheCampaignFromTheSaleDropdown()throws InterruptedException {
        salescons.sidenavigbtn("campaign");
    }

    @Then("I am creating a campaign with proper {string} name")
    public void iAmCreatingACampaignWithProperName(String campaignName) throws InterruptedException{
        expCampaignName = campaignName;
        salescons.createcampaign(campaignName);
    }

    //verifying the actual and expected campaign names.
    @And("User verifies the newly created campaign")
    public void userVerifiesTheNewlyCreatedCampaign() throws InterruptedException {
        String actCampaignName = salescons.vfyCampaignName();
        try {
            Assert.assertEquals(actCampaignName, expCampaignName, "Actual and Expected campaign name is not matching");
            genericFunctions.logToExtentReport("Pass", "Campaign creation and name verification is successful. Expected and actual names match.");
        } catch (AssertionError e) {
            genericFunctions.logToExtentReport("Fail", "Campaign creation and name verification is failed. Expected: " + expCampaignName + ", but found: " + actCampaignName);
            throw e;
        }
    }

    @Then("User get datas from table.")
    public void userGetDatasFromTable(WebDriver driver)throws InterruptedException {
        salescons.getalltableData(driver);
    }
}
