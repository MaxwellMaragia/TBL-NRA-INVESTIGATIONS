package StepDefinitions;


import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import gherkin.lexer.Th;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en_old.Ac;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.math3.analysis.function.Exp;
import org.apache.poi.ss.formula.functions.Na;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;




@RunWith(Cucumber.class)
public class stepDefinitions extends BaseClass  {
    public Properties Pro;
    public WebDriverWait five;
    public WebDriverWait ten ;
    public WebDriverWait fifteen;
    public WebDriverWait twenty ;
    public WebDriverWait twentyfive;
    public WebDriverWait thirty;
    public WebDriverWait thirtyfive;
    public WebDriverWait fourty;
    public WebDriverWait fourtyfive;
    public WebDriverWait fifty;
    public WebDriverWait fiftyfive;
    public WebDriverWait sixty;
    public WebDriverWait sixtyfive;
    public WebDriverWait seventy;
    public WebDriverWait seventyfive;
    public WebDriverWait eighty;
    public WebDriverWait eightyfive;
    public WebDriverWait ninety;
    public WebDriverWait ninetyfive;
    public WebDriverWait onehundred;
    public WebDriverWait twohundred;
    public Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    public Actions actions;



    public static sharedatastep sharedata;
    public String ReferenceNumber = "MANP/000002433/2020";
    public String Name = "";
    public String FirstName = "";
    public String SecondName = "";
    public String Email = "";
    public String PenaltyCode = "";
    public String FineCode = "";

    public stepDefinitions(sharedatastep sharedata) {

        stepDefinitions.sharedata = sharedata;

    }

    @Before(order = 2)
    public void method1() throws Exception {
        Pro = new Properties();
        FileInputStream fls = new FileInputStream("src\\test\\resources\\global.properties");
        Pro.load(fls);
        driver = BaseClass.getDriver();
        actions = new Actions(driver);
        five = new WebDriverWait(driver, 5);
        ten = new WebDriverWait(driver, 10);
        fifteen = new WebDriverWait(driver, 15);
        twenty = new WebDriverWait(driver, 20);
        twentyfive = new WebDriverWait(driver, 25);
        thirty = new WebDriverWait(driver, 30);
        thirtyfive = new WebDriverWait(driver, 35);
        fourty = new WebDriverWait(driver, 40);
        fourtyfive = new WebDriverWait(driver, 45);
        fifty = new WebDriverWait(driver, 50);
        fiftyfive = new WebDriverWait(driver, 55);
        sixty = new WebDriverWait(driver, 60);
        sixtyfive = new WebDriverWait(driver, 65);
        seventy = new WebDriverWait(driver, 70);
        seventyfive = new WebDriverWait(driver, 75);
        eighty = new WebDriverWait(driver, 80);
        eightyfive = new WebDriverWait(driver, 85);
        ninety = new WebDriverWait(driver, 90);
        ninetyfive = new WebDriverWait(driver, 95);
        onehundred = new WebDriverWait(driver, 100);
        twohundred = new WebDriverWait(driver, 200);

    }

    public void switchToFrameBackoffice(){
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
    }

    @Then("Switch to default")
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    @Then("^Verify success message \"([^\"]*)\"$")
    public void verify_success_message(String Message) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Message + "')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("Success message ('" + Message + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify error message \"([^\"]*)\"$")
    public void verify_error_message(String error) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + error + "')]")));
        if (errorMessage.isDisplayed()) {
            //This will scroll the page till the element is found
            System.out.println("Error message ('" + error + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify no data is found in table$")
    public void verify_no_data_is_found_in_table() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement noDataXpath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'No record(s) found.')]")));
        if (noDataXpath.isDisplayed()) {
            Assert.assertTrue("No data found in table", true);
        } else {
            Assert.assertFalse("Data found in table", false);
        }
    }

    @Given("^User navigates to the login page$")
    public void user_navigates_to_the_login_page() throws Throwable {

//    	intergtation link for backoffice
//    	driver.get("http://18.202.88.7:8001/trips-ui/faces/login/tripsLogin.xhtml");

        //    	SIT link for backoffice
        driver.get("https://backoffice.mra.mw:8443/trips-ui/faces/login/tripsLogin.xhtml");
    }

    @When("^Enters the username \"([^\"]*)\" and password \"([^\"]*)\" to login$")
    public void enters_the_username_something_and_password_something_to_login(String strArg1, String strArg2) throws Throwable {
        driver.findElement(By.id("loginForm:username")).sendKeys(strArg1);
        driver.findElement(By.id("loginForm:password")).sendKeys(strArg2);
        driver.findElement(By.xpath("//*[@id=\"loginForm:j_idt19\"]/span")).click();
    }

    @Then("^User should be logged in$")
    public void user_should_be_logged_in() throws Throwable {
        String URL = driver.getCurrentUrl();

//    	Assert.assertEquals(URL, "http://18.202.88.7:8001/trips-ui/faces/login/Welcome.xhtml" );
        Assert.assertEquals(URL, "https://backoffice.mra.mw:8443/trips-ui/faces/login/Welcome.xhtml");
    }

    @Then("^User logs out successfully$")
    public void user_logs_out_successfully() throws Throwable {
        driver.findElement(By.id("Logout")).click();

    }

    //---------------------------------------------------------------------Verify the Process of Assign Audit Case-----------------------------------------------------------------------------------------------//
    @Given("^Open CRM URL Module as \"([^\"]*)\"$")
    public void open_crm_url_module_as_something(String strArg1) throws Throwable {
        driver = getDriver();
        driver.get("https://" + strArg1 + ":Passw0rd@trips-crm.mra.mw:5555/TripsWorkflow/main.aspx");
    }

    @And("^Close Popup Window$")
    public void close_Popup_Window() throws Throwable {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @And("^Click on Case management dropdown$")
    public void click_on_case_management_dropdown() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"TabCS\"]/a/span")).click();
    }


    @Then("^switch to frame0$")
    public void switch_to_frame0() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @Then("^switch to frame1$")
    public void switch_to_frame1() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @Then("^Enter Outcome Reason$")
    public void enter_Outcome_Reason() throws Throwable {
        Thread.sleep(2000);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("OutComeReason_Frame_XPATH"))));
        driver.switchTo().frame(specificframe);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Pro.getProperty("NextStage_RefNum_Reject_OutComeReason_XPATH"))).click();
        WebDriverWait ReasonValue = new WebDriverWait(driver, 60);
        ReasonValue.until(ExpectedConditions.elementToBeClickable(By.xpath(Pro.getProperty("NextStage_RefNum_Reject_OutComeReason_Options_XPATH")))).click();
        Thread.sleep(8000);
    }


    @And("Click on compliance and enforcement > Perform tax compliance processing")
    public void clickOnComplianceUrl() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Compliance and Enforcement']"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Configure Penalty Rules']"))).click();
    }

    @Then("^Click reporting > reports$")
    public void goToReportingScreen() throws Throwable {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Reporting']"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Reports']"))).click();
    }

    @Then("Open CRM and close modal")
    public void openCRMAndCloseModal() {
        driver.get(Pro.getProperty("MRA_crm_url_Registration"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @Then("search for reference number")
    public void searchForReferenceNumber() throws InterruptedException {
        WebElement search = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));

        search.clear();
        Thread.sleep(2000);
        //search.sendKeys("*AV/000000875/2021");
        search.sendKeys(ReferenceNumber);
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
    }

    @Then("^Click on reference number$")
    public void click_on_reference_number() {

        WebElement elementLocator = driver.findElement(By.xpath(Pro.getProperty("CaseManagement_Queue_Select_ReffNo_XPATH")));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();

        driver.switchTo().defaultContent();

    }

    @Then("^Select report to print \"([^\"]*)\"$")
    public void select_report_to_print(String reportType) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + reportType + "']"))).click();

    }

    @Then("^Select report file type \"([^\"]*)\"$")
    public void select_report_file_type(String reportFormat) throws Throwable {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:ReportFormat\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + reportFormat + "')]")).click();
    }

    @Then("^Select tax office \"([^\"]*)\"$")
    public void select_tax_office(String taxOffice) throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"frmReportDetails:TAX_OFFICE\"]/div[3]")).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("^Select return type$")
    public void select_return_type() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:TAX_TYPE\"]/div[3]"))).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    @Then("^Verify file \"([^\"]*)\" has been downloaded in downloads directory \"([^\"]*)\"$")
    public void verify_file_has_been_downloaded_in_downloads_directory(String fileName, String downloadPath) throws Throwable {
        Thread.sleep(10000);
        if (isFileDownloaded(downloadPath, fileName)) {
            System.out.println(fileName + ": has been downloaded");
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(fileName + ": has not been downloaded", false);
        }
    }

    @Then("^Click run report \"([^\"]*)\"$")
    public void click_run_report(String buttonID) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(buttonID))).click();
    }

    @Then("Select ending date as today")
    public void selectEndingDateAsToday() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmReportDetails:EndDate_input"))).sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB);
        Thread.sleep(1000);
    }

    @Then("Select business sector")
    public void selectBusinessSector() throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:BUSINESS_SECTOR\"]/div[3]"))).click();
        Thread.sleep(1500);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Click cancel to abandon report")
    public void clickCancelToAbandonReport() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmReportDetails:btnCancel"))).click();
    }


    @And("Click on investigations > Mantain information source")
    public void clickOnInvestigationsMantainInformationSource() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Investigations']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Maintain Information Source']"))).click();
    }

    @Then("Maintain Information Source screen should be displayed with the following fields and buttons")
    public void maintainInformationSourceScreenShouldBeDisplayedWithTheFollowingFieldsAndButtons() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:sourceReferenceNumber"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:sourceReliability_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:name"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:informationSourceType_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:confidentialLevel_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:tin"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_idt42"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:Cancel"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_id20"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_id21"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_id22"))).isDisplayed();
    }

    @Then("click new button")
    public void clickNewButton() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_id20"))).click();
    }

    @Then("Verify fields in Create Information Source")
    public void verifyFieldsInCreateInformationSource() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:ReferenceNumber"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:InformationSource_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:SourceReliability_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:ConfidentialLevel_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Name"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Tin"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Address"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:PhoneNumber"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Email"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:ContactMethod_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Save"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:cancel"))).isDisplayed();
    }

    @Then("Enter Information source as {string}")
    public void enterInformationSourceAs(String source) throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InformationSourceForm:InformationSource\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + source + "')]")).click();
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Enter source reliability as {string}")
    public void enterSourceReliabilityAs(String reliability) throws InterruptedException {
        Thread.sleep(1500);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InformationSourceForm:SourceReliability\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + reliability + "')]")).click();
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Enter confidentiality level as {string}")
    public void enterConfidentialityLevelAs(String level) throws InterruptedException {
        Thread.sleep(1500);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InformationSourceForm:ConfidentialLevel\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + level + "')]")).click();
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Enter name as random number")
    public void enterNameAs() throws InterruptedException {
        Thread.sleep(1500);
        Name = getRandom(6);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Name"))).clear();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Name"))).sendKeys(Name);
    }

    @Then("Enter tin as {string}")
    public void enterTinAs(String tin) throws InterruptedException {
        Thread.sleep(1500);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Tin"))).sendKeys(tin);
    }

    @Then("Enter address as {string}")
    public void enterAddressAs(String address) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Address"))).sendKeys(address);
    }

    @Then("Enter phone number as {string}")
    public void enterPhoneNumberAs(String phone) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:PhoneNumber"))).sendKeys(phone);
    }

    @Then("Enter email as random")
    public void enterEmailAs() {
        Email = getRandom(5)+"@gmail.com";
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Email"))).sendKeys(Email);
    }

    @Then("Save information source")
    public void saveInformationSource() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Save"))).click();
    }

    @Then("Obtain information source ref number {string}")
    public void obtainInformationSourceRefNumber(String success) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,100);
        String text  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+success+"')]"))).getText();
        //Processing Completed - Reference Number - ISN/00000025/2021
        System.out.println(text);
        System.out.println("substring is "+ text.substring(42));
        ReferenceNumber =text.substring(42);

        System.out.println(ReferenceNumber);
        System.out.println("Information Source Reference Number is " +ReferenceNumber);
        sharedatastep.InformationSourceRef = ReferenceNumber;
        Thread.sleep(2000);
    }

    @Then("Enter reference number")
    public void enterReferenceNumber() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:sourceReferenceNumber"))).sendKeys(ReferenceNumber);
    }

    @Then("Click search")
    public void clickSearch() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_idt42"))).click();
    }

    @Then("Click edit button")
    public void clickEditButton() throws InterruptedException {
        Thread.sleep(5000);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_id21"))).click();
    }


    @Then("Enter reference number as wrong")
    public void enterReferenceNumberAsWrong() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:sourceReferenceNumber"))).sendKeys(getRandom(5));
    }

    @Then("Enter duplicate name")
    public void enterDuplicateName() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Name"))).clear();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Name"))).sendKeys(Name);
    }

    @Then("Enter duplicate email")
    public void enterDuplicateEmail() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InformationSourceForm:Email"))).sendKeys(Email);
    }

    @And("Click on investigations > Maintain suspect")
    public void clickOnInvestigationsMantainSuspect() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Investigations']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Maintain Suspect']"))).click();
    }

    @Then("Maintain Suspect screen should be displayed with the following fields and buttons")
    public void maintainSuspectScreenShouldBeDisplayedWithTheFollowingFieldsAndButtons() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:SuspectRefNumber"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:FirstName"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:LastName"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:SuspectStatus_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:Warning"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:SuspectReason_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:SuspectReason_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:SuspectType_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:ReviewDate_input"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:SuspectTIN"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_idt42"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:Cancel"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_id26"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_id27"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_id28"))).isDisplayed();
    }

    @Then("Click add new suspect")
    public void clickAddNewSuspect() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_id26"))).click();
    }

    @Then("Verify fields in create suspect")
    public void verifyFieldsInCreateSuspect() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:ReferenceNumber"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:FirstName"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:LastName"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:MiddleName"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:DistinguishingFeatures"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:Name"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:Address"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:PhoneNumber"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:Email"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:idSave"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:Cancel"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:SuspectStatus_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:SuspectType_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:SuspectReason_label"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:ReviewDate_input"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:SuspectTIN"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:SuspectTIN"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:Warnings"))).isDisplayed();
    }

    @Then("Enter suspect first name as random")
    public void enterSuspectFirstNameAsRandom() {
        FirstName = getRandom(6);
        System.out.println("First name: "+FirstName);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:FirstName"))).clear();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:FirstName"))).sendKeys(FirstName);
    }

    @Then("Enter suspect second name as random")
    public void enterSuspectSecondNameAsRandom() {
        SecondName = getRandom(6);
        System.out.println("Second name: "+SecondName);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:LastName"))).clear();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:LastName"))).sendKeys(SecondName);
    }

    @Then("Enter suspect type as {string}")
    public void enterSuspectTypeAs(String type) throws InterruptedException {
        Thread.sleep(1500);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MaintainSuspect:SuspectType\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + type + "')]")).click();
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Enter suspect reason as {string}")
    public void enterSuspectReasonAs(String reason) throws InterruptedException {
        Thread.sleep(1500);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MaintainSuspect:SuspectReason\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + reason + "')]")).click();
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Enter review date")
    public void enterReviewDate() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:ReviewDate_input"))).sendKeys(Keys.ENTER);
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Enter suspect address as {string}")
    public void enterSuspectAddressAs(String address) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:Address"))).sendKeys(address);
    }

    @Then("Enter suspect email as random")
    public void enterSuspectEmailAsRandom() {
        Email = getRandom(5)+"@gmail.com";
        System.out.println("Email: "+Email);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:Email"))).sendKeys(Email);
    }

    @Then("select suspect method of contact as email")
    public void selectSuspectMethodOfContactAsEmail() throws InterruptedException {
        Thread.sleep(1500);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MaintainSuspect:MethodOfContact\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'Email')]")).click();
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Save suspect")
    public void saveSuspect() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:idSave"))).click();
    }

    @Then("Obtain suspect ref number {string}")
    public void obtainSuspectRefNumber(String success) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,100);
        String text  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+success+"')]"))).getText();
        //Suspect has been successfully saved - Reference Number - SUS/00000029/2021
        System.out.println(text);
        System.out.println("substring is "+ text.substring(57));
        ReferenceNumber =text.substring(57);

        System.out.println(ReferenceNumber);
        System.out.println("Suspect reference number is " +ReferenceNumber);
        sharedatastep.SuspectRef = ReferenceNumber;
        Thread.sleep(2000);
    }

    @Then("Search for suspect")
    public void searchForSuspect() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:SuspectRefNumber"))).sendKeys(ReferenceNumber);
        driver.findElement(By.id("SearchForm:j_idt42")).click();
    }

    @Then("Click edit suspect button")
    public void clickEditSuspectButton() throws InterruptedException {
        Thread.sleep(5000);
        //twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'"+ReferenceNumber+"')]"))).isDisplayed();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:j_id27"))).click();
    }

    @Then("Enter blank suspect first name")
    public void enterBlankSuspectFirstName() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:LastName"))).clear();
    }

    @Then("modify suspect first name")
    public void modifySuspectFirstName() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:FirstName"))).clear();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:FirstName"))).sendKeys(getRandom(6));
    }

    @Then("Enter suspect first name")
    public void enterSuspectFirstName() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:FirstName"))).sendKeys(FirstName);
    }

    @Then("Enter suspect second name")
    public void enterSuspectSecondName() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:LastName"))).sendKeys(SecondName);
    }

    @Then("Enter suspect email")
    public void enterSuspectEmail() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("MaintainSuspect:Email"))).sendKeys(Email);
    }


    @Then("search for suspect with invalid data")
    public void searchForSuspectWithInvalidData() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:SuspectRefNumber"))).sendKeys("Boom");
        driver.findElement(By.id("SearchForm:j_idt42")).click();
    }

    @And("Click on investigations > Create Investigation Case")
    public void clickOnInvestigationsCreateInvestigationCase() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Investigations']"))).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Create Investigation Case']"))).click();
    }

    @Then("Enter case title")
    public void enterCaseTitle() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InvestigationCase:CaseTitle"))).sendKeys("Case "+getRandom(6));
    }

    @Then("Select suspicion type as {string}")
    public void selectSuspicionTypeAs(String suspicionType) throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InvestigationCase:SuspicionType\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + suspicionType + "')]")).click();
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("Enter suspicion reason")
    public void enterSuspicionReason() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InvestigationCase:SuspicionReason"))).sendKeys("Reason "+getRandom(6));
    }

    @Then("Enter suspicion offence as {string}")
    public void enterSuspicionOffenceAs(String offence) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InvestigationCase:SuspicionOffence"))).sendKeys(offence);
    }

    @Then("Enter suspicion description as {string}")
    public void enterSuspicionDescriptionAs(String desc) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InvestigationCase:SuspicionDescription"))).sendKeys(desc);
    }

    @Then("Select Information Source as previously saved")
    public void selectInformationSourceAsPreviouslySaved() throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InvestigationCase:SelectSource"))).click();
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:sourceReferenceNumber"))).sendKeys(sharedatastep.InformationSourceRef);
        driver.findElement(By.id("SearchForm:j_idt21")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        Thread.sleep(4000);
    }


    @Then("Select Suspect as previously saved")
    public void selectSuspectAsPreviouslySaved() throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("InvestigationCase:SelectSuspect"))).click();
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:SuspectRefNumber"))).sendKeys(sharedatastep.InformationSourceRef);
        driver.findElement(By.id("SearchForm:j_idt21")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        Thread.sleep(4000);
    }

    @Then("Save Investigations Case")
    public void saveInvestigationsCase() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("InvestigationCase:SaveInvestCase"))).click();
    }

    @Then("Obtain Investigations Case ref number {string}")
    public void obtainInvestigationsCaseRefNumber(String success) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,100);
        String text  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+success+"')]"))).getText();
        //Processing Completed - Reference Number - IN/000002562/2021
        System.out.println(text);
        System.out.println("substring is "+ text.substring(42));
        ReferenceNumber =text.substring(42);

        System.out.println(ReferenceNumber);
        System.out.println("Investigations Case Reference Number is " +ReferenceNumber);
        sharedatastep.InvestigationsCaseRef = ReferenceNumber;
        Thread.sleep(2000);

    }
}



