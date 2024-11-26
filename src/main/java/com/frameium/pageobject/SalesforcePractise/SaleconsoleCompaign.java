package com.frameium.pageobject.SalesforcePractise;

import com.frameium.genericfunctions.GenericFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SaleconsoleCompaign extends GenericFunctions {
    //initializing webdriver
    private WebDriver driver;
    //locators
    private By applaucnherbtn = By.xpath("//button[@title='App Launcher']");
    private By viewallbtn = By.xpath("//button[text()='View All']");
    private By saleconsolebtn = By.xpath("//p[text()='Sales Console']");
    private By sidenavigbtn = By.xpath("//button[@class='slds-button slds-button_icon slds-p-horizontal__xxx-small slds-button_icon-small slds-button_icon-container']");
    private By compaignbtn = By.xpath("//span[text()='Campaigns']");
    private By NewBtn = By.xpath("//li/a/div[text()='New']");
    private By compainName = By.xpath("//label/span[text()='Campaign Name']//following::*[2]");
    private By saveBtn = By.xpath("//button[@title='Save']");
    private By vfyCampName = By.xpath("//span[@class='uiOutputText' and text()='sdfgg']");
    private By clckdetails  = By.xpath("//span[text()='Details']");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    //creating constructor.
    public SaleconsoleCompaign(WebDriver driver){
        this.driver=driver;
    }

    //creating methods.
    public void saleconsolepage()throws InterruptedException{
        Thread.sleep(2000);
        clickElement(applaucnherbtn);
        waitForByElement(viewallbtn);
        clickElement(viewallbtn);
        scrollToElement(driver.findElement(saleconsolebtn));
        clickElement(saleconsolebtn);

        //initializing webdriver wait and waiting for presence of the element.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement saleElement = wait.until(ExpectedConditions.presenceOfElementLocated(saleconsolebtn));
        saleElement.click();

    }
    //for clicking newbtn
    public void clicknewbtn()throws InterruptedException{
        Thread.sleep(2000);
        clickElement(NewBtn);
    }

    //for selecting campaign via clicking new btn
    public void sidenavigbtn(String visibletext)throws InterruptedException{
        Thread.sleep(2000);
        clicknewbtn();
        Thread.sleep(3000);
        clickElement(sidenavigbtn);
        //locate the dropdown element
        WebElement dropdwonElement = driver.findElement(sidenavigbtn);
        //initialize select class
        Select dropdown = new Select(dropdwonElement);
        dropdown.selectByVisibleText(visibletext);
       // dropdown.selectByValue(Stringcompaignbtn);

    }

    public void createcampaign(String camppaignName)throws InterruptedException{
        Thread.sleep(2000);
        clickElement(compainName);
        enterKeys(compainName,camppaignName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement saveElement = wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn));
        saveElement.click();
    }

    public String getActualcampaignName(){
        waitForByElement(compainName);
        String Namecampain = driver.findElement(compainName).getText();
        return Namecampain;
    }

    public String vfyCampaignName()throws InterruptedException{
        Thread.sleep(2000);
        waitForByElement(clckdetails);
        clickElement(clckdetails);
        waitForByElement(vfyCampName);
        //locating the element to be visible.
        WebElement campaignElement = wait.until(ExpectedConditions.visibilityOfElementLocated(vfyCampName));
        String actualcampaign = campaignElement.getText();
        return actualcampaign;
    }

//    public String createdcampname()throws InterruptedException{
//        Thread.sleep(2000);
//        WebElement names = wait.until(ExpectedConditions.visibilityOfElementLocated(compainName));
//        String NameElement = names.getText();
//        return NameElement;
//    }

}
