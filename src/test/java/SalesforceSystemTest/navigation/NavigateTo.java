
package SalesforceSystemTest.navigation;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    public void clickNewContact(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("//*[@data-id='Contact']")).click();
        //driver.findElement(By.xpath("(//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container'])[2]")).click();
        waitfortheelement();
//        Actions act1 = new Actions(driver);
//        waitfortheelement();
//        waitfortheelement();
//        act1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//        waitfortheelement();

    }

    public void clickNewOpportunity(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("(//lightning-icon[@class='slds-icon-utility-chevrondown slds-icon_container'])[5]")).click();
        waitfortheelement();
//        Actions act1 = new Actions(driver);
//        act1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//        waitfortheelement();

    }

    public void enterAllDetails(WebDriver driver, String fieldName, String fieldValue) {
        driver.findElement(By.xpath("//div[contains(@class,'uiInput')]//span[contains(text(),'" + fieldName + "')]/../..//input")).sendKeys(fieldValue);
    }


    public void scrollDown(WebDriver driver) {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        waitfortheelement();

    }

    public void scrollUP(WebDriver driver) {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_UP).build().perform();

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
        driver.findElement(By.xpath("//button[@title='"+ buttonName +"']//span[@class=' label bBody']")).click();
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

    public void clickTextboxOfEngagementPlan(WebDriver driver) {
        waitfortheelement();
        driver.findElement(By.xpath("//div[@class='primaryLabel slds-truncate slds-lookup__result-text']")).click();
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
    public void clickOnEpn(WebDriver driver){
        waitfortheelement();
        waitfortheelement();
        driver.findElement(By.xpath("//a[contains(@class,'textUnderline output')][@data-recordid ='a0k6D000000TH4YQAW']")).click();
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
        driver.findElement(By.xpath("//div[@title ='"+ Name +"']")).click();
        waitfortheelement();
    }
    public void verifyURM(WebDriver driver,String ManagerName,String RnManager){
        waitfortheelement();
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
    public void verifyPRM (WebDriver driver,String Manager){
        waitfortheelement();
        waitfortheelement();
        String OldManager = driver.findElement(By.xpath("//span[text()='Previous Relationship Manager']/../..//a[@class=' textUnderline outputLookupLink slds-truncate forceOutputLookup']")).getText();
        waitfortheelement();
        Assert.assertEquals(OldManager,Manager);
    }
}