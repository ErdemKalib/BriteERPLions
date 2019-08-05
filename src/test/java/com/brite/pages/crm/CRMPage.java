package com.brite.pages.crm;

import com.brite.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CRMPage {

    private WebDriver driver = Driver.getDriver();


    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-left oe_application_menu_placeholder']//li//a[starts-with(@class,'oe_menu_')]")
    public List <WebElement> menuElements;

    @FindBy(className = "oe_kanban_color_0 oe_kanban_global_click o_kanban_record ui-sortable-handle")
    public List<WebElement> oppElements;

    @FindBy(xpath = "//div[@class='btn-group btn-group-sm o_cp_switch_buttons']//button ")
    public List<WebElement> viewElements;

    @FindBy(xpath = "//table//tr[2]//td[1]")
    public WebElement newButtonElement;

    @FindBy(xpath = "//a[.='Opportunity']")
    public WebElement oppMenuElement;

    @FindBy(xpath = "//table//tbody//tr[4]//td[1]")
    public WebElement secondTitleElement;

    @FindBy(xpath = "//table//tbody//tr[4]//td[2]")
    public WebElement secondValueElement;

    @FindBy(xpath = "//table//tbody//tr//td[3]")
    public List<WebElement> oppColumnElements;

    @FindBy(xpath = "//table//tbody//tr//td[9]")
    public List<WebElement> revColumnElements;

    @FindBy(xpath = "//button[@accesskey='l']")
    public WebElement  listButtonElement;

    @FindBy(xpath = "//table//tbody//tr//td[2]")
    public List<WebElement> expRevColumnElements;

    @FindBy(xpath = "//button[@data-view-type='pivot']")
    public WebElement pivotButtonElement;

    @FindBy(xpath = "//a[@class='oe_menu_toggler']//span[contains(text(),'CRM')]")
    public WebElement crmButtonElement;

    public CRMPage(){
        PageFactory.initElements(driver,this);
    }

}
