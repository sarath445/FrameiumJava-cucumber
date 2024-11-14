package com.frameium.stepdef.AutomationExercise;
import com.frameium.genericfunctions.GenericFunctions;
import com.frameium.pageobject.Automationexercise.AddtoCart;
import com.frameium.stepdef.Hooks;
import com.frameium.stepdef.TestSetUp;
//import cucumber.annotation.en.And;
import cucumber.annotation.en.When;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class AddtoCartTest extends GenericFunctions {

    private static final Logger log = LoggerFactory.getLogger(AddtoCartTest.class);
    TestSetUp setUp;
    Hooks hook = new Hooks();
    public WebDriver driver;
    private GenericFunctions genericFunctions;
    private AddtoCart productpage;
    private AddtoCart cardadd;
    private String ExpectedSuccessfulName = "Added!";
    public AddtoCartTest(TestSetUp setUp){
        this.setUp=setUp;
        cardadd = new AddtoCart(setUp.baseTest.getDriver());
        productpage = new AddtoCart(setUp.baseTest.getDriver());
        genericFunctions = new GenericFunctions(setUp.baseTest.getDriver());
        this.driver=setUp.baseTest.getDriver();


    }

    @Then("User verify the category name")
    public void userVerifyTheCategoryName() {
        cardadd.Verifycategory();

    }

    @Then("User have added items to the cart")
    public void userHaveAddedItemsToTheCart() throws InterruptedException{

        cardadd.AddingCart();
        hook.takeScreenshot(hook.scenario);
    }

    @Then("User hit on continue button")
    public void userHitOnContinueButton() {
        cardadd.Continueshop();
    }

    public List<String> verifyProductNames(){
        //List<String> expectedproduct = Arrays.asList("product1", "product2", "product3");
        List<String> actualproductnames = productpage.getproductnames();
        //Assert.assertEquals(expectedproduct,actualproductnames, "product names don't match");
        return actualproductnames;
    }

    @And("User verify the SuccessfulAdded message")
    public void userVerifyTheSuccessfulAddedMessage() throws InterruptedException{

        String actualAddedmsg = cardadd.ItemAddedmsg();
        System.out.println("the actual successful message" + actualAddedmsg);
        try{
            Assert.assertEquals(actualAddedmsg, ExpectedSuccessfulName);
            genericFunctions.logToExtentReport("pass","Expectd and actualmessages are matched");
        } catch (Exception e) {
            genericFunctions.logToExtentReport("fail", "Expectd and actualmesages are not matched");
            throw new RuntimeException(e);
        }
    }

    @And("User storing the elements as List")
    public List<String> userStoringTheElementsAsList() {
        //List<String> expectedproduct = Arrays.asList("product1", "product2", "product3");
        List<String> productnames = productpage.getproductnames();
        //Assert.assertEquals(expectedproduct, productnames, "productnames don't match");
        return productnames;


    }

}








