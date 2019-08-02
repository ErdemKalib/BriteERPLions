package com.brite.pages.login;

import com.brite.utilities.ConfigurationReader;
import com.brite.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

//    String userNameLocator = "login";    //id
//    String passwordLocator = "password"; //id

//    public void login(String userName, String password){
//        Driver.getDriver().findElement(By.id(userNameLocator)).sendKeys(userName);
//        Driver.getDriver().findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);
//    }


    private WebDriver driver = Driver.getDriver();
    //private WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));
    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Long.valueOf(ConfigurationReader.getProperty("explicitwait")));

    @FindBy(id="login")
    public WebElement userNameElement;

    @FindBy (name="password")
    public WebElement passwordElement;

    @FindBy (xpath="//button[text()='Log in']")
    public WebElement loginButtonElement;

//    //@FindBy(id="remember_me")
//    @FindBy(css=".custom-checkbox__icon")
//    public WebElement rememberMeElement;


    @FindBy(partialLinkText = "Forgot your password?")
    public WebElement forgotPasswordElement;

    @FindBy(tagName="h2")
    public WebElement titleElement;

                    //p[contains(text(),'Wrong login/password')]
    @FindBy(css = "div p[class='alert alert-danger']")
    public WebElement errorMessageElement;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void login(String username, String password){
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
        // VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged in successfully
        // Assert.assertEquals(VYTrackUtils.getPageSubTitle(), "Dashboard");
    }

    public String getErrorMessage(){
        return errorMessageElement.getText();
    }
//
//    public void clickRememberMe(){
//        wait.until(ExpectedConditions.elementToBeClickable(rememberMeElement));
//        if (!rememberMeElement.isSelected()){
//            rememberMeElement.click();
//        }
//    }


}
