package com.frameium.pageobject.Automationexercise;

import com.frameium.genericfunctions.GenericFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddtoCart extends GenericFunctions {

    public WebDriver driver;
    private By categoryVerify = By.xpath("(//h4[@class='panel-title'])[2]");
    private By MenCategory = By.xpath("(//*[text()='Category']//following::a)[5]");
    private By TshirtMen = By.xpath("//a[contains(text(),'Tshirts')]");
    private By viewProductElement = By.xpath("(//a[contains(text(),'View Product')])[3]");
    private By ProductinfoElement = By.xpath("//div[@class='product-information']");
    private By AddtoCartElement = By.xpath("//button[@class='btn btn-default cart']");
    private By cartAddedsuccessfully = By.xpath("//div[@class='modal-content']");
    private By continueSHopping = By.xpath("//button[text()='Continue Shopping']");
    private By VerifySuccessAddtitile = By.xpath("//h4[text()='Added!']");
    public By productelementnames = By.xpath("//div[@class='productinfo text-center']//p");


    public AddtoCart(WebDriver driver) {
        this.driver = driver;
    }

    //verification the text message in category field.
    public void Verifycategory() {

        String actualText = element(categoryVerify).getText();
        String ExpectedText = "Men";
        SoftAssert asser = new SoftAssert();
        asser.assertEquals(actualText, ExpectedText);
        System.out.println(("text verification passed"));
        //displayed

    }
    public void AddingCart()throws InterruptedException{
        Thread.sleep(2000);
        scrollToElement(driver.findElement(MenCategory));
        //waitForByElement(MenCategory);
        clickElement(MenCategory);
        Thread.sleep(3000);
        waitForByElement((TshirtMen));
        clickElement(TshirtMen);
        Thread.sleep(3000);
        scrollToElement(driver.findElement(viewProductElement));
        clickElement(viewProductElement);
        //String fieldvalue = ProductinfoElement;
       // String actualtext =
        waitForByElement(AddtoCartElement);
        clickElement(AddtoCartElement);
        //verifying successful message
        waitForByElement(cartAddedsuccessfully);
        WebElement Shopping = driver.findElement(cartAddedsuccessfully);
        Shopping.isDisplayed();
        System.out.println(("shopping adding successfully"));

    }
    public void Continueshop(){
        waitForByElement(continueSHopping);
        clickElement(continueSHopping);
    }
     //Verifying successful messages
    public String getSuccesstitle(){
        return driver.findElement(VerifySuccessAddtitile).getText();
    }

   public String ItemAddedmsg()throws InterruptedException{
        Thread.sleep(2000);
        String addItem = getSuccesstitle();
        return addItem;
   }


   //@DataProvider



    public Map<String, String> getcredentilas(){
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("Sarathuser", "Sarath@123");
        credentials.put("captain", "shadow@123");
        return credentials;
    }


    //Method to get a list of product names
   public List<String> getproductnames() {
       List<WebElement> productelementz = driver.findElements(productelementnames);
       List<String> productnamelists = new ArrayList<>();
       for (WebElement product : productelementz) {
           productnamelists.add(product.getText());
       }
       return productnamelists;

   }


    public void verifiyproductnames(){
        //locate elements representing product names
        List<WebElement> productelements = driver.findElements(productelementnames);
        List<String> actualproductnames = new ArrayList<>();


    }



}