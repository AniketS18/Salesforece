
package SalesforceSystemTest.stepdefinitions;

import SalesforceSystemTest.navigation.NavigateTo;
import SalesforceSystemTest.navigation.SalesforceHomePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Map;


//import static org.assertj.core.api.Assertions.assertThat;

public class SalesforceStepDefinitions {

    @Steps
    NavigateTo navigateTo;
    SalesforceHomePage homePage;
    String firstName, lastName, Salutation, Phone, tagName;
    String expectedString;
    String enteredSupporterLevel, expectedSupporterLevel, expectedLevelOfService, expectedSelectService, expectedchoosedSupporter, enteredSelectService;

    public WebDriver initialize() {
        String saleforceNotifications = getConfigurationDetails("webdriver.base.disable_notifications");
        String driverName = getConfigurationDetails("webdriver.name.chrome");
        String driverPath = getConfigurationDetails("webdriver.chrome.driver");
        ChromeOptions option = new ChromeOptions();
//        option.addExtensions(new File("C:\\Users\\Aniket\\Downloads\\Block-image_v1.0.crx"));
        option.addArguments(saleforceNotifications);
        System.setProperty(driverName, driverPath);
        WebDriver driver = new ChromeDriver(option);
        return driver;
    }

    public String getConfigurationDetails(String nameURL) {
        EnvironmentVariables props = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        String configDetails = EnvironmentSpecificConfiguration.from(props).getProperty(nameURL);
        return configDetails;
    }

    WebDriver driver = initialize();

    @Given("^I login to Salesforce URL$")
    public void i_login_to_Salesforce_URL() throws Throwable {
        navigateTo.LogintoSalesforce(driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @When("^I click on Contacts Page")
    public void i_click_on_contacts_page() throws Throwable {
        navigateTo.clickNewContact(driver);
        //   restapi.testRestApi();

    }


    @When("^I enter following details in (.*), (.*), (.*) and (.*) fields under New Contact Page:$")
    public void i_enter_details(String fieldSalutation, String fieldFirstName, String fieldLastName, String fieldPhone, DataTable dataTable) throws Throwable {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        firstName = data.get(0).get("First Name");
        lastName = data.get(0).get("Last Name");
        Salutation = data.get(0).get("Salutation");
        Phone = data.get(0).get("Phone");
        navigateTo.insertRecords(driver, fieldSalutation, fieldFirstName, fieldLastName, fieldPhone, firstName, lastName, Salutation, Phone);
    }

    @When("^I select (.*) under (.*)$")
    public void i_select(String supporterLevel, String supporterfieldName) throws Throwable {
        // navigateTo.selectFromDropDown(driver, supporterLevel, supporterfieldName);
        enteredSupporterLevel = supporterLevel;
    }

    @When("^I click on (.*) button")
    public void i_click_on_Save_button(String saveButton) {
        navigateTo.clickOnSave(driver, saveButton);
    }

    @And("^I click on Recently Viewed dropdown (.*)$")
    public void recently_viewed_dropdown(String filedDropdown) {
        navigateTo.recentlyViewedDropdown(driver,filedDropdown);
    }

    @And("^I select \"(.*)\" from the list view$")
    public void select_all_contacts(String allContact) {
        navigateTo.allContacts(driver,allContact);
    }

    @And("^I type the contact \"(.*)\" in the Search box and press Enter to view the particular contact detail$")
    public void search_enter(String arg1) {
        navigateTo.contactNameInSearch(driver, arg1);
    }

//    @And("I click on (-?\\d) (-?\\d) ")
//    public void search_enter_name(String n) {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+n);
//        navigateTo.contactNameInSearch(driver);
//    }

    @And("I click on the searched contact name")
    public void searched_contact_name() {
        navigateTo.searchContactName(driver);
    }

//    @And("^I click on (.*) Tab$")
//    public void click_required_tab(String TagName) {
//        navigateTo.clickTabName(driver,TagName);


    @And("^I click on \"(.*)\" Tab$")
    public void click_required_tab(String fieldTagName) {
        navigateTo.clickTabName(driver, fieldTagName);
    }

    @And("I click \"(.*)\" button in the Engagement Plans section")
    public void Engagement_Plans_new(String newButton) {
        navigateTo.clickNewEngagementPlans(driver, newButton);
    }

    @And("I click on Engagement Plan Template textbox and select a plan under New Engagement Plan page")
    public void select_Engagement_Plan_Template() {
        navigateTo.clickTextboxOfEngagementPlan(driver);
    }

    @When("^I verify the an Engagement Plan Template and Contact is created$")
    public void i_enter_details(DataTable dataTable) throws Throwable {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String ept = data.get(0).get("Engagement Plan Template");
        String contactName = data.get(0).get("Contact Name");

        navigateTo.verifyDetails(driver, ept, contactName);
    }

    @And("I scroll down to page")
    public void scroll_Down() {
        navigateTo.scrollDown(driver);
    }

    @And("I click on ENGAGEMENT PLAN NUMBER")
    public void click_EPN() {
        navigateTo.clickOnEpn(driver);
    }

    @And("^I click \"(.*)\" button$")
    public void click_ERM(String editButton) {
        navigateTo.clickOnERM(driver, editButton);
    }
//    @And("^I enter \"(.*)\" and \"(.*)\" in Relationship Manager filed$")
//    public  void enter_Relationship_Manager(String fieldFirstName,String filedLastName,DataTable dataTable){
//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//        firstName = data.get(0).get("First Name");
//        lastName = data.get(0).get("Last Name");
//        navigateTo.enterRelationshipManager(driver,firstName,lastName);
//        }

    @And("^I enter \"(.*)\" in Relationship Manager filed$")
    public  void  click_Relationship_Manager(String fieldName){
//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//        firstName = data.get(0).get("First Name");
//        lastName = data.get(0).get("Last Name");
        navigateTo.clickOnRelationshipManager(driver,fieldName);
    }
    @Then("^I verify the (.*)name is populated with previous value$")
    public void  verify_Previous_Relationship_Manager(DataTable dataTable ){
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String PreviousManager = data.get(0).get("Manager Name");

        navigateTo.verifyPRM(driver,PreviousManager);
    }
    @Then("^I verify the (.*) is now updated with new manager name$")
    public void verify_Updated_Relationship_Manager(DataTable dataTable,String filedManager) throws Throwable {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String NewManager = data.get(0).get("Manager Name");
        navigateTo.verifyURM(driver,NewManager,filedManager);

    }
    @And("^I click on the cross mark against the (.*) name and remove it$")
    public void cross_Mark_Relationship_Manager(String filedManager){
        navigateTo.crossMark(driver,filedManager);
    }
    @And("^I \"(.*)\" the PopUp$")
    public void  PopUp_Close(String filedClose){
        navigateTo.ClosePopUp(driver,filedClose);
    }
}


