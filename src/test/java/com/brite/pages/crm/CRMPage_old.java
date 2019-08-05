package com.brite.pages.crm;

import com.brite.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMPage {

    private WebDriver driver = Driver.getDriver();


    //private WebDriver driver2 = Driver.getDriver();

    @FindBy(partialLinkText = "Forgot your password?")
    public WebElement forgotPasswordElement;


    public CRMPage(){
        PageFactory.initElements(driver,this);
    }

}
