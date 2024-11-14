package com.frameium.pageobject.Automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chromedriverconfig {
    //initializing the Webdriver interface
    public WebDriver Webdriversetup;
    public void Driversetup(String browser){
        String browsersetup = browser.toLowerCase();
            switch (browsersetup){
                case "chrome":
                    //automatically updated the chromedriver by using webdrivermanager setup
                    WebDriverManager.chromedriver().setup();
                    Webdriversetup = new ChromeDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    Webdriversetup = new ChromeDriver();
                }
            }


    }


