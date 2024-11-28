package com.frameium.pageobject.SalesforcePractise;

import com.frameium.genericfunctions.GenericFunctions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

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
    private By campaigntable = By.xpath("//table[contains(@class,'slds-table forceRecordLayout slds-table_header-fixed slds-table--header-fixed slds-table_edit slds-table--edit slds-table_bordered slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable')]//tbody");
    private By tableclick = By.xpath("//*[@class=\"slds-table forceRecordLayout slds-table_header-fixed slds-table--header-fixed slds-table_edit slds-table--edit slds-table_bordered slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable\"]//tbody/tr[3]/td[2]");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    //creating constructor.@
    public SaleconsoleCompaign(WebDriver driver){
       this.driver=driver;
    }
//@BeforeTest
//public void iniitialize(){
//        driver=new ChromeDriver();
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

//    public String gettablerowtext(int row, int col)throws InterruptedException {
//        Thread.sleep(2000);
//        String celltext =
//    }

    public void getalltableData(WebDriver driver)throws InterruptedException{
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.navigate().to("https://testhouse5-dev-ed.develop.lightning.force.com/lightning/o/Campaign/list?filterName=__Recent");
//        driver.navigate().refresh();
        Thread.sleep(2000);
        waitForByElement(compaignbtn);
        clickElement(compaignbtn);
        WebElement Table = driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout slds-table_header-fixed slds-table--header-fixed slds-table_edit slds-table--edit slds-table_bordered slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable')]//tbody"));
        //Find all rows in the table.
        //so we need to create list.
        List<WebElement> rowdata = Table.findElements(By.tagName("tr"));
        System.out.println("table datas are " + rowdata);
    }

    }
//    public void ExtractTabledata()throws InterruptedException{
//        Thread.sleep(2000);
//        WebElement Table = driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout slds-table_header-fixed slds-table--header-fixed slds-table_edit slds-table--edit slds-table_bordered slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable')]//tbody"));
//        //Find all rows in the table.
//        //so we need to create list.
//        List<WebElement> rowdata = Table.findElements(By.tagName("tr"));
//        System.out.println("table datas are " + rowdata);
//    }


