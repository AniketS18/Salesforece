
package SalesforceSystemTest.navigation;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class NavigateTo {

    @Step("Open the Salesforce home page")
    public void LogintoSalesforce(WebDriver driver) {
        String salesforceURL = getConfigurationDetails("webdriver.base.url");
        String userName = getConfigurationDetails("Salesforce.username");
        String passWord = getConfigurationDetails("Salesforce.password");
        driver.get(salesforceURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(passWord);
        driver.findElement(By.xpath("//input[@id='Login']")).click();
    }

    public String getConfigurationDetails(String nameURL) {
        EnvironmentVariables props = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        String configDetails = EnvironmentSpecificConfiguration.from(props).getProperty(nameURL);
        return configDetails;
    }


    public void waitfortheelement() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickContacts(WebDriver driver,String tagname) {
        waitfortheelement();
        waitfortheelement();
        waitfortheelement();
        waitfortheelement();
        //String e=driver.findElement(By.xpath(".//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'][a[span[text()='"+ tagname +"']]]")).getText();

        driver.findElement(By.xpath(".//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'][a[span[@class='slds-truncate'][text()='"+ tagname +"']]]")).click();
       // driver.findElement(By.xpath(".//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none']//a//span[@class='slds-truncate'][text()='"+ tagname +"']")).click();
        waitfortheelement();
    }
    public void clickNewContact(WebDriver driver) {
        waitfortheelement();
        WebElement element1 = driver.findElement(By.xpath("//div[contains(@class,'menuItemsWrapper')]//span//span[contains(text(),'New Contact')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element1);



    }
    public void clickOnDropdown(WebDriver driver){
        waitfortheelement();
        driver.findElement(By.xpath("(//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container'])[2]")).click();
        waitfortheelement();
    }

    public void clickNewOpportunity(WebDriver driver) {
        waitfortheelement();
        WebElement element1 = driver.findElement(By.xpath("//div[contains(@class,'menuItemsWrapper')]//span//span[contains(text(),'New Opportunity')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element1);
        waitfortheelement();
//        Actions act1 = new Actions(driver);
//        act1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//        waitfortheelement();

    }
    public void clickOpportunitydropdown(WebDriver driver){
        waitfortheelement();
        driver.findElement(By.xpath("(//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container'])[5]")).click();
        waitfortheelement();
    }

    public void enterAllDetails(WebDriver driver, String fieldName, String fieldValue) {
        driver.findElement(By.xpath("//div[contains(@class,'uiInput')]//span[contains(text(),'" + fieldName + "')]/../..//input")).sendKeys(fieldValue);
    }


    public void scrollDown(WebDriver driver) {
        waitfortheelement();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        waitfortheelement();

    }

    public void scrollUP(WebDriver driver) {
        waitfortheelement();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_UP).build().perform();
        waitfortheelement();

    }

    public void insertRecords(WebDriver driver, String fieldSalutation, String fieldFirstName, String fieldLastName, String fieldPhone, String firstName, String lastName, String Salutation, String Phone) {
        waitfortheelement();
        driver.findElement(By.xpath("//div[contains(@class,'uiInputSelect')]//span[contains(text(),'" + fieldSalutation + "')]/../..//div[contains(@class,'salutation')]//a")).click();
        waitfortheelement();
        driver.findElement(By.xpath("//div[contains(@class,'select-options')]//a[contains(@title,'" + Salutation + "')]")).click();
        waitfortheelement();
        enterAllDetails(driver, fieldFirstName, firstName);
        enterAllDetails(driver, fieldLastName, lastName);
        enterAllDetails(driver, fieldPhone, Phone);


    }

    public void clickOnSave(WebDriver driver,String buttonName) {
        waitfortheelement();
        //driver.findElement(By.xpath("//button[@title='"+ buttonName +"']//span[@class=' label bBody']")).click();
        waitfortheelement();
        WebElement duplicateMessage =driver.findElement(By.xpath("//div[@class ='slds-col slds-align-middle']"));

        if(duplicateMessage!=null && duplicateMessage.getText().contains("duplicate")){
            driver.findElement(By.xpath("//button[@title='"+ buttonName +"']//span[@class=' label bBody']")).click();
        }
        else {
            driver.findElement(By.xpath("//button[@title='"+ buttonName +"']//span[@class=' label bBody']")).click();
        }
        waitfortheelement();

    }
    public void clickNext(WebDriver driver){
        waitfortheelement();
        driver.findElement(By.xpath("//span[@class=' label bBody'][text()='Next']")).click();
        waitfortheelement();
    }


    public void recentlyViewedDropdown(WebDriver driver,String dropdown) {
        waitfortheelement();
        driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--reset d')][contains(@title,'"+ dropdown +"')]")).click();
        waitfortheelement();
//        Actions act1 = new Actions(driver);
//        waitfortheelement();
//        act1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//        waitfortheelement();
    }

    public void allContacts(WebDriver driver,String contact) {
        waitfortheelement();
        driver.findElement(By.xpath("//span[@class= ' virtualAutocompleteOptionText'][contains(text(),'"+ contact +"')]")).click();
        waitfortheelement();
        Actions act1 = new Actions(driver);
        waitfortheelement();
        act1.sendKeys(Keys.ENTER).build().perform();
        waitfortheelement();
    }

    public void contactNameInSearch(WebDriver driver,String name) {
        waitfortheelement();
//        String contactName = getConfigurationDetails("Salesforce.contactName");
        String contactName = name;
        driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys(contactName);
        waitfortheelement();
        Actions act1 = new Actions(driver);
        waitfortheelement();
        act1.sendKeys(Keys.ENTER).build().perform();
        waitfortheelement();
    }

    public void searchContactName(WebDriver driver) {
        waitfortheelement();
        waitfortheelement();
        waitfortheelement();
        WebElement e = driver.findElement(By.xpath("//table[contains(@class,'uiVirtualDataTable')]//tbody"));

        waitfortheelement();

        List<WebElement> rows = e.findElements(By.tagName("tr"));
        WebElement firstRecordFound = rows.get(0);

        firstRecordFound.findElement(By.tagName("th")).findElement(By.tagName("a")).click();
        waitfortheelement();
        waitfortheelement();
        waitfortheelement();
    }
//    public void enterTagName(WebDriver driver, String TagName, String TagValue) {
//        driver.findElement(By.xpath("//li[@class ='tabs__item uiTabItem']//a[@title='"+  TagName +" ']")).sendKeys(TagValue);

    public void clickTabName(WebDriver driver, String tagName){
        waitfortheelement();
        //String filedTagName =TagName;
        WebElement elem = driver.findElement(By.xpath("//span[@class ='title'][text()='"+ tagName +"']"));
        elem.click();
        waitfortheelement();
        waitfortheelement();
    }

    public void clickNewEngagementPlans(WebDriver driver,String buttonName) {
        waitfortheelement();
        waitfortheelement();
        driver.findElement(By.xpath("(//li[@class='slds-button slds-button--neutral slds-truncate']//a[contains(@title,'"+ buttonName +"')])[4]")).click();
        waitfortheelement();
    }
    public void clickNewEngagementPlansTemplet(WebDriver driver) {
        waitfortheelement();
        waitfortheelement();
        driver.findElement(By.xpath("(//li[@class='slds-button slds-button--neutral slds-truncate']//a[contains(@title,'New')])[10]")).click();
        waitfortheelement();
//    (//li[@class='slds-button slds-button--neutral slds-truncate']//a[contains(@title,'New')])[10]
    }
    public void clickTextboxOfEngagementPlan(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("//div[contains(@class,'createNew itemContainer')]")).click();
        waitfortheelement();
        waitfortheelement();

    }
    public void verifyDetails(WebDriver driver,String ept,String contactName){
        waitfortheelement();
        waitfortheelement();
        String eptNum = driver.findElement(By.xpath("//div//span[text()='Engagement Plan Template']/../..//div//a")).getText();
        String cName= driver.findElement(By.xpath("//div//span[text()='Contact']/../..//div//a")).getText();


//        System.out.println("-----------------------------------------------------");
//        System.out.println(eptNum);
//        System.out.println(eptNum.getText());
//        System.out.println("-----------------------------------------------------");

//        System.out.println(cName);
//        System.out.println(cName.getText());
//        System.out.println("-----------------------------------------------------");

          Assert.assertEquals(eptNum,ept);
         Assert.assertEquals(contactName,cName);
    }
    public void clickOnEpn(WebDriver driver,String filedEPN){
        waitfortheelement();
        waitfortheelement();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("scrollBy(0,50)");
//        driver.findElement(By.tagName("table"));
//        String el =driver.findElement(By.xpath("//th[@class='initialSortAsc '][text()='"+ filedEPN +"']/../../..//div[@class='outputLookupContainer forceOutputLookupWithPreview']//a")).getText();
//        WebElement e= driver.findElement(By.xpath("//th[@class='initialSortAsc '][text()='"+ filedEPN +"']/../../..//div[@class='outputLookupContainer forceOutputLookupWithPreview']//a"));
//        System.out.println("----------------------------------------------");
//        System.out.println(el);
//        System.out.println("-----------------------------------------------");
//        List<WebElement> rows = e.findElements(By.tagName("tr"));
//        WebElement firstRecordFound = rows.get(0);
//
//        firstRecordFound.findElement(By.tagName("th")).findElement(By.tagName("a")).click();
//        //driver.findElement(By.xpath("//th[@class='initialSortAsc '][text()='"+ filedEPN +"']/../../..//div[@class='outputLookupContainer forceOutputLookupWithPreview']//a[text()='"+ filedNumer +"']")).click();
//        String e =driver.findElement(By.xpath("(//table[contains(@class,'forceRecordLayout slds-table')])[1]")).getText();
//        System.out.println("----------------------------------------------");
//        System.out.println(e);
//        System.out.println("----------------------------------------------");
//        System.out.println(driver.findElement(By.xpath("(//table[contains(@class,'forceRecordLayout slds-table')])[1]")).findElements(By.tagName("tr")));
//
//        System.out.println("-----------------------------------------------");
          driver.findElement(By.xpath("(//tr//th[@class='initialSortAsc ']/../../..//div[@class='outputLookupContainer forceOutputLookupWithPreview']//a)[1]")).click();
        waitfortheelement();
    }
    public void clickOnERM(WebDriver driver,String ERMButton){
        waitfortheelement();
        waitfortheelement();
         driver.findElement(By.xpath("//button[@title='"+ ERMButton +"']")).click();
          waitfortheelement();
    }

    public void clickOnRelationshipManager(WebDriver driver, String  Name){
        waitfortheelement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,50)");
        driver.findElement(By.xpath(".//span[@class='pillText'][text()='"+ Name +"']")).click();
        waitfortheelement();
    }
    public void verifyURM(WebDriver driver,String ManagerName,String RnManager){
        waitfortheelement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-250)");
        String Name = driver.findElement(By.xpath("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//span[text()='"+ RnManager +"']/../..//span[@class='pillText']")).getText();
        waitfortheelement();
        System.out.println("-----------------------------------------------------");
        System.out.println(Name);
        System.out.println("-----------------------------------------------------");

        Assert.assertEquals(Name,ManagerName);
    }
//    public void enterRelationshipManager(WebDriver driver,String FirstName,String LastName){
//        waitfortheelement();
//        WebElement Name = driver.findElement(By.xpath("//span[text()='"+ ManagerName +"']"));
//        waitfortheelement();
//
//    }
      public void crossMark(WebDriver driver,String RnManager){
        waitfortheelement();
        driver.findElement(By.xpath("//span[text()='"+ RnManager +"']/../..//a[@class='deleteAction']//span[@class='deleteIcon']")).click();
        waitfortheelement();
        waitfortheelement();
    }
    public void ClosePopUp(WebDriver driver,String close){
        waitfortheelement();
        waitfortheelement();
        driver.findElement(By.xpath("//div[@class='container']//div//button[@title='"+ close +"']")).click();
        waitfortheelement();
    }


    public WebElement getVisibility(WebDriver driver,By locator, int timeout) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
    public void clickElementWhenClickable(WebDriver driver,By locator, int timeout) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }



    public void verifyPRM (WebDriver driver,String previousManager){
        waitfortheelement();
        waitfortheelement();
        String xPath = "//span[text()='Previous Relationship Manager']/../..//a[@class=' textUnderline outputLookupLink slds-truncate forceOutputLookup']";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-250)");
        String testname = driver.findElement(By.xpath(xPath)).getText();

        Assert.assertEquals(previousManager,testname);

    }
    public void clickOnURM(WebDriver driver,String UndoRM){
        waitfortheelement();
        waitfortheelement();
        String OldManager = driver.findElement(By.xpath("//span[text()='"+ UndoRM +"']/../..//a[@class=' textUnderline outputLookupLink slds-truncate forceOutputLookup']")).getText();
        System.out.println("Old Manager="+OldManager);
        waitfortheelement();
    }
    public void verifyDetailsUnderContact(WebDriver driver,String fullName,String filedPhone){
        waitfortheelement();
        waitfortheelement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-250)");
        String fullName1 = driver.findElement(By.xpath("//span[text()='Name']/../..//span[@class='uiOutputText']")).getText();
        String PhoneNo = driver.findElement(By.xpath("//span[text()='Phone']/../..//span[@class='uiOutputPhone']")).getText();
        System.out.println("-------------------Name-----------------------");
        System.out.println(fullName);
        System.out.println("--------------------Phone----------------------");
        System.out.println(PhoneNo);
        waitfortheelement();
        Assert.assertEquals(fullName1,fullName);
        Assert.assertEquals(PhoneNo,filedPhone);
    }
    public void verifyCorrectErrorMessage(WebDriver driver,String message){
        waitfortheelement();
        waitfortheelement();
        String msg = driver.findElement(By.xpath("//li[text()='"+ message +"']")).getText();
        waitfortheelement();

        Assert.assertEquals(msg,message);
    }
    public void verifyErrorMessage(WebDriver driver,String message){
        waitfortheelement();
        waitfortheelement();
        String msg = driver.findElement(By.xpath("//li[@class='form-element__help']")).getText();
//        System.out.println("=--------------------------------------------");
//        System.out.println(msg);
//        System.out.println("----------------------------------------------");
        waitfortheelement();

        Assert.assertEquals(msg,message);
    }
    public void clickCheckBox(WebDriver driver,String checkbox){
        waitfortheelement();
        waitfortheelement();
        driver.findElement(By.xpath("//label//span[text()='"+ checkbox +"']/../..//input[@type='checkbox']")).click();
        waitfortheelement();
    }
    public void selectDonation(WebDriver driver){
        waitfortheelement();
        driver.findElement(By.xpath(".//span[@class='slds-radio--faux']/../..//div[@class='changeRecordTypeOptionRightColumn']//span[contains(text(),'Donation')]")).click();
        waitfortheelement();
    }
    public void insertdetails(WebDriver driver,String fieldOpportunityName,String fieldPrimaryCampaignSource,String filedCloseDate,String filedStage,String opportunityName,String primaryCampaignSource,String closeDate,String stage){
        waitfortheelement();
        enterAllDetails(driver, fieldOpportunityName, opportunityName);
        driver.findElement(By.xpath("//label[contains(@class,'label inputLabel uiLabel-left form-element__label uiLabel')]//span[text()='Primary Campaign Source']")).click();


        //        enterAllDetails(driver, fieldPrimaryCampaignSource, primaryCampaignSource);
//        enterAllDetails(driver, filedCloseDate, closeDate);
//        enterAllDetails(driver, filedStage, stage);
        driver.findElement(By.xpath("//label[contains(@class,'label inputLabel uiLabel-left form-element__label uiLabel')]//span[text()='Primary Campaign Source']/../..//div[contains(@class,'primaryLabel slds')]")).click();
        waitfortheelement();
        WebElement element = driver.findElement(By.xpath("//label[contains(@class,'label inputLabel')]//span[text()='Close Date']/../..//a[contains(@class, 'datePicker-openIcon')]//span[@class='assistiveText']"));
        waitfortheelement();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        waitfortheelement();
        driver.findElement(By.xpath("//td[contains(@class,'uiDayInMonthCell')]//span[contains(@class,'slds-day weekday')][text()='24']")).click();
        waitfortheelement();
        String e =driver.findElement(By.xpath("//span[contains(@class,'label inputLabel')]//span[text()='Stage']")).getText();
        System.out.println(e);

        driver.findElement(By.xpath("//span[contains(@class,'label inputLabel')]//span[text()='Stage']/../..//a[@class='select']")).click();
        driver.findElement(By.xpath(".//li[@class='uiMenuItem uiRadioMenuItem']//a[@title='Posted']")).click();
    }
    public void provideEngagementPlanName(WebDriver driver){
        waitfortheelement();
        waitfortheelement();
        waitfortheelement();
//        int size =driver.findElements(By.tagName("iframe")).size();
//        System.out.println("------------------------------");
//        System.out.println(size);
//        System.out.println("=======------------------------");
//        for(int i=0; i<=size; i++){
//            driver.switchTo().frame(i);
//            int total=driver.findElements(By.xpath("html/body/a/img")).size();
//            System.out.println(total);
//            driver.switchTo().defaultContent();}
        driver.switchTo().frame(0);
        waitfortheelement();
        driver.findElement(By.xpath("//label[@class='slds-form-element__label']//abbr/../..//input[@class='slds-input']")).sendKeys("High Value Prospect Journey");

    }
    public void MEPTSave(WebDriver driver){
        waitfortheelement();
        driver.findElement(By.xpath("//input[@class='btn slds-button slds-button_brand']")).click();
        driver.switchTo().defaultContent();
    }
    public void selectRelated(WebDriver driver){
        driver.findElement(By.xpath("(//a[@class='tabHeader'][@title='Related']//span[@class ='title'][text()='Related'])[2]")).click();
    }
    public void  selectAccount(WebDriver driver){
        waitfortheelement();
        driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']//input[@title='Search Accounts']")).click();
        driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']//input[@title='Search Accounts']/..//div//div[@title='Jain Household']")).click();
    }
    public void selectEngagementPlan(WebDriver driver){
        waitfortheelement();
        driver.findElement(By.xpath("//div[@class='primaryLabel slds-truncate slds-lookup__result-text']")).click();
        waitfortheelement();
    }
    public void verfyopportunitydetails(WebDriver driver,String filedOpportunityName,String filedPrimaryCampaignSource,String filedCloseDate,String filedStage){
        waitfortheelement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,150)");
        String Opprtunity = driver.findElement(By.xpath("//div//span//span[@class='uiOutputText']")).getText();
        waitfortheelement();
        System.out.println("----------------------------------------");
        System.out.println(Opprtunity);
        System.out.println("-----------------------------------------");

        Assert.assertEquals(Opprtunity,filedOpportunityName);
    }
    public void verifyAnonymousSupporter(WebDriver driver,String filedPhone,String fullName){
        waitfortheelement();
        waitfortheelement();
        String fullName1 = driver.findElement(By.xpath("//span[text()='Name']/../..//span[@class='uiOutputText']")).getText();
        String PhoneNo = driver.findElement(By.xpath("//span[text()='Phone']/../..//span[@class='uiOutputPhone']")).getText();
//        List list = driver.findElements(By.name("radioButton"));
//
//        // Create a boolean variable to store true/false.
//        Boolean is_selected = list.get(0).isSelected();
        Assert.assertEquals(fullName1,fullName);
        Assert.assertEquals(PhoneNo,filedPhone);

    }
    public void clickNewTask(WebDriver driver,String task){
        waitfortheelement();
        driver.findElement(By.xpath("//a//div[@title='"+ task +"']")).click();
        waitfortheelement();
    }
    public void newTaskDetails(WebDriver driver,String fieldAssignedto,String fieldSubject,String filedStatus,String filedPriorty,String Assignedto,String Subject,String Status,String Priorty){
        driver.findElement(By.xpath("//div//input[contains(@class,'default input uiInput uiInputTextForAutocomplet')][@title ='Search People']")).click();
        waitfortheelement();
        //WebElement element =
        driver.findElement(By.xpath("//label[contains(@class,'label inputLabel')]//span[text()='Close Date']/../..//a[contains(@class, 'datePicker-openIcon')]//span[@class='assistiveText']")).sendKeys(fieldSubject);
        driver.findElement(By.xpath("//span[contains(@class,'label inputLabel')]//span[text()='Status']/../..//div[@class='uiMenu']/")).click();
        driver.findElement(By.xpath("//div//ul//li[@class='uiMenuItem uiRadioMenuItem']//a[@title='In Progress']")).sendKeys(fieldSubject);
        waitfortheelement();
    }
    public void verifywarningMessage (WebDriver driver,String filedMessage){
        String msg =driver.findElement(By.xpath("//div//div[@class ='slds-col slds-align-middle']")).getText();

        System.out.println("----------------------------------");
        System.out.println(msg);
        System.out.println("----------------------------------");
        Assert.assertEquals(msg,filedMessage);
    }

}