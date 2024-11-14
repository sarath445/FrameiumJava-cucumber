package com.frameium.pageobject.Automationexercise;

import com.frameium.genericfunctions.GenericFunctions;
import com.frameium.logger.LoggerHelper;
import com.frameium.pageobject.ClimateXLoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.HashMap;

public class Loginautomationexercise extends GenericFunctions {
    private final Logger log = LoggerHelper.getLogger(ClimateXLoginPage.class);
    public WebDriver driver;
    private By clicksignin = By.xpath("//ul[contains(@class,'navbar-nav')]//li/a[contains(@href,'login')]");
    private By Emailaddress = By.name("email");
    private By Password = By.name("password");
    private By Loginclck = By.xpath("//button[text()='Login']");
    //public  String Expctedtitle = "Automation Exercise";
    private By nextbutton = By.xpath("(//a/i[@class='fa fa-angle-right'])[1]");
    private By Addcategorymen = By.xpath("(//span[@class='badge pull-right'])[1]");
    public Loginautomationexercise(WebDriver driver) {    this.driver = driver;    }

 //public void loginautomation(WebDriver driver){this.driver= driver;}

 public  void loginautomation( String username, String password) throws Exception{
    waitForByElement(clicksignin);
    clickElement(clicksignin);
    enterKeys(Emailaddress,username);
    log.info("Email entered successfully");
    clickElement(Password);
    enterKeys(Password,password);
    //initializing webdriver wait and waiting for element to be visible
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement elements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Login']")));
    elements.click();
    //clickElement(elements);

//    if(isDisplayed(findElement(Loginclck))){
//         waitForByElement(Loginclck);
//         clickElement(Loginclck);
//         System.out.println("loginbutton clicked successfully");
//     }
//     else {
//         System.out.println("login button is not visible in the screen");
//     }



}
public void loginclickautomation(){
   if(isDisplayed(findElement(Loginclck))){
       waitForByElement(Loginclck);
       clickElement(Loginclck);
       System.out.println("loginbutton clicked successfully");
    }
   else {
       System.out.println("login button is not visible in the screen");
   }


    }
public boolean verify_homepage_title(String expctedtitle){
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
//    wait.until(ExpectedConditions.titleContains(expectedtitle));
    String Homepagetitle = driver.getTitle();
    SoftAssert asser = new SoftAssert();
    asser.assertEquals(expctedtitle, Homepagetitle);
    asser.assertAll();
    return true;
}
 public void clickSignin(){
     clickElement(clicksignin);
 }

//Hashmap to store credentials
private HashMap<String,String> credentials = new HashMap<>();

    //constructor initializes and add values to the hashmap.
    public void Loginpage(WebDriver driver){
        this.driver = driver;
        credentials.put("Sarathsobhs", "Sarath@1123");
    }
    //Method to login using credentials from the Hashmap.
    public void logi(String userkey){
        String password = credentials.get(userkey);
        if(password!=null){
            EnterKeys(Emailaddress, userkey);
            //Emailaddress.sendkeys(userkey);
        }
        else{
            System.out.println("entered invalid credentials");
        }
    }
}
