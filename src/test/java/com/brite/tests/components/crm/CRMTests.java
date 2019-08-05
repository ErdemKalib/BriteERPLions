package com.brite.tests.components.crm;

import com.brite.pages.crm.CRMPage;
import com.brite.pages.crm.CRMPage_old;
import com.brite.pages.login.LoginPage;
import com.brite.utilities.BriteUtils;
import com.brite.utilities.ConfigurationReader;
import com.brite.utilities.SeleniumUtils;
import com.brite.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRMTests extends TestBase {

    @Test
    public void Test1(){
        int waitTime=3;

        extentLogger = report.createTest("Check Values Report");
        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        //extentLogger.info("Clicking on remember me");
        //loginPage.clickRememberMe();
        loginPage.login(username, password);
        //to verify that Discuss/#inbox page opened
        //Once page name Discuss displays, means that we have logged in successfully
        Assert.assertEquals(BriteUtils.getPageSubTitle(), "#Inbox");
        extentLogger.pass("Verified that page name is #Inbox");


        CRMPage crm = new CRMPage();


        // Put all the Menu titles as elements in menuElements List
        //List<WebElement> menuElements = Driver.getDriver().findElements(By.xpath(menuLocator));
        System.out.println(SeleniumUtils.getElementsText(crm.menuElements));

        // click Menu Item CRM
        crm.menuElements.get(4).click();
        //SeleniumUtils.waitPlease(waitTime);
        BriteUtils.waitUntilLoaderScreenDisappear();
        System.out.println(BriteUtils.getPageSubTitle());
        Assert.assertEquals("Pipeline", BriteUtils.getPageSubTitle());

        //List<WebElement> oppElements = Driver.getDriver().findElements(By.className(oppElementLocator));
        System.out.println(crm.oppElements.size());
        if (crm.oppElements.size() < 3) {
            createOpp();
        }

        //List<WebElement> viewElements = Driver.getDriver().findElements(By.xpath(viewLocator));
        System.out.println(crm.viewElements.size());

        // Go to Pivot view
        crm.viewElements.get(3).click();
        BriteUtils.waitUntilLoaderScreenDisappear();
        //SeleniumUtils.waitPlease(waitTime);

        // find and click the new button
        //driver.findElement(By.xpath(newButtonLocator)).click();
        crm.newButtonElement.click();
        BriteUtils.waitUntilLoaderScreenDisappear();

        // find and click the Opportunity from the popup menu
        //driver.findElement(By.xpath(oppLocator)).click();
        crm.oppMenuElement.click();
        BriteUtils.waitUntilLoaderScreenDisappear();

//        String title = driver.findElement(By.xpath(titleLocator)).getText();
//        String value = driver.findElement(By.xpath(valueLocator)).getText();

        String title = crm.secondTitleElement.getText();
        String value = crm.secondValueElement.getText();

        System.out.println(title);
        System.out.println(value);

        // go to list view
        //driver.findElement(By.xpath(listButtonLocator)).click();
        crm.listButtonElement.click();
        BriteUtils.waitUntilLoaderScreenDisappear();

        // put the Opportunities column elements into a list of Elements
        //List <WebElement> oppElementList = driver.findElements(By.xpath(oppTableLocator));
        // put the Expected Revenue column elements into a list of Elements
        //List <WebElement> revenueElementList = driver.findElements(By.xpath(revenueTableLocator));

        // find the Element from the table Opportunities Column that has a text that is equal to title (which was the second item in Pivot View)
        // and save its index to location
        int location=0;
        for (int i=0; i < crm.oppColumnElements.size();i++){
            if (title.equals(crm.oppColumnElements.get(i).getText())){
                location=i;
            }
        }
        // compare the value (which was the second item's value in Pivot View) with same item's value in the list view
        Assert.assertEquals(value, crm.revColumnElements.get(location).getText());
        SeleniumUtils.waitPlease(5);
    }



    @Test
    public void Test2(){
        int waitTime=3;

        extentLogger = report.createTest("Sum of Values Report");
        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        //extentLogger.info("Clicking on remember me");
        //loginPage.clickRememberMe();
        loginPage.login(username, password);
        //to verify that Discuss/#inbox page opened
        //Once page name Discuss displays, means that we have logged in successfully
        Assert.assertEquals(BriteUtils.getPageSubTitle(), "#Inbox");
        extentLogger.pass("Verified that page name is #Inbox");
        // Put all the Menu titles as elements in menuElements List
//        List<WebElement> menuElements = Driver.getDriver().findElements(By.xpath(menuLocator));
//        System.out.println(SeleniumUtils.getElementsText(menuElements));


        CRMPage crm = new CRMPage();



        // click Menu Item CRM
//        menuElements.get(4).click();
        //driver.findElement(By.xpath(crmButtonLocator)).click();
        crm.crmButtonElement.click();

        //SeleniumUtils.waitPlease(waitTime);
        BriteUtils.waitUntilLoaderScreenDisappear();
        System.out.println(BriteUtils.getPageSubTitle());

        Assert.assertEquals("Pipeline", BriteUtils.getPageSubTitle());

//        List<WebElement> oppElements = Driver.getDriver().findElements(By.className(oppElementLocator));
//        System.out.println(oppElements.size());
//        if (oppElements.size() < 3) {
//            createOpp();
//        }

//        List<WebElement> viewElements = Driver.getDriver().findElements(By.xpath(viewLocator));
//        System.out.println(viewElements.size());

        // Go to Pivot view
        // viewElements.get(3).click();
       // driver.findElement(By.xpath(pivotButtonLocator)).click();
        crm.pivotButtonElement.click();
        BriteUtils.waitUntilLoaderScreenDisappear();
        //SeleniumUtils.waitPlease(waitTime);

        // find and click the new button
       // driver.findElement(By.xpath(newButtonLocator)).click();
        crm.newButtonElement.click();
        BriteUtils.waitUntilLoaderScreenDisappear();

        // find and click the Opportunity from the popup menu
        //driver.findElement(By.xpath(oppLocator)).click();
        crm.oppMenuElement.click();
        BriteUtils.waitUntilLoaderScreenDisappear();


        //List<WebElement> expectedRevenueList = Driver.getDriver().findElements(By.xpath(expectedRevenueTableLocator));

        double sum = Double.valueOf(crm.expRevColumnElements.get(0).getText().replaceAll(",",""));
        double total=0;
        for (int i=2; i < crm.expRevColumnElements.size();i++){
            total = total + Double.valueOf(crm.expRevColumnElements.get(i).getText().replaceAll(",",""));
        }

        System.out.println("Sum : " + sum);
        System.out.println("Total : " + total);

        int dotLocation = String.valueOf(sum).indexOf(".");
        String strSum = String.valueOf(sum).substring(0,dotLocation+3);
        dotLocation = String.valueOf(total).indexOf(".");
        String strTotal = String.valueOf(total).substring(0,dotLocation+3);
        System.out.println("Sum : " + strSum);
        System.out.println("Total : " + strTotal);
        Assert.assertEquals(strSum, strTotal);

        //SeleniumUtils.waitPlease(5);
    }






    public void createOpp(){

    }


}
