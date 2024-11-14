package com.frameium.stepdef.AutomationExercise;
import com.frameium.genericfunctions.GenericFunctions;
import com.frameium.pageobject.Automationexercise.Loginautomationexercise;
import com.frameium.stepdef.Hooks;
import com.frameium.stepdef.TestSetUp;
import cucumber.annotation.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class Loginexercisedef extends GenericFunctions {
    Hooks hooks = new Hooks();
    TestSetUp setUp;
    private GenericFunctions genericFunctions;
    private Loginautomationexercise practise;
    public String Expctedtitle = "Automation Exercise";
    public WebDriver driver;
    public Loginexercisedef(TestSetUp setUp) {
        this.setUp = setUp;
        genericFunctions = new GenericFunctions(setUp.baseTest.getDriver());
        practise = new Loginautomationexercise(setUp.baseTest.getDriver());
        // Assign the driver from setUp to the local driver variable
        this.driver = setUp.baseTest.getDriver();
}

    @When("User is on the login page")
    public void userIsOnTheLoginPage() {
        //String expectedtitle="Automation Exercise";
        practise.verify_homepage_title(Expctedtitle);
        boolean headtitle = practise.verify_homepage_title(Expctedtitle);
        if (headtitle==true){
            System.out.println("our home title is" + headtitle);
        }
        else {
            System.out.println("title is checking...");
        }

  }
    @Then("User navigate to the url {string}")
    public void userNavigateToTheUrl(String url) {
        genericFunctions.getApplicationUrl(url);

    }


    @Then("User enters {string} and {string}")
    public void userEntersUsernameAndPassword(String username, String password)throws Exception{

          practise.loginautomation(username,password);
          practise.logi("Sarathsobhs");
    }

    @When("user click on signup button")
    public void userClickOnSignupButton() {
          practise.clickSignin();
    }



}
