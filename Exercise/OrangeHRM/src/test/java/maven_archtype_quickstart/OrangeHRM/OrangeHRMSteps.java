package maven_archtype_quickstart.OrangeHRM;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMSteps 
{
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;
	private Scenario scenario;
	private static boolean bFirstTime = true;
	
	private LoginPage loginPage;
	private _BasePage basePage;
	private AddEmployeePage addEmployeePage;
	private EmployeeListPage employeeListPage;
	private PersonalDetailsPage personalDetailsPage;
	
	private String username;
	private String firstname;
	private String lastname;

	public OrangeHRMSteps()
	{
		extent = new ExtentReports(Constants.ReportLoc, bFirstTime);
		
		if (bFirstTime)
			bFirstTime = false;
	}
	
	@Before 
	public void setup(Scenario scenarioInput) 
	{ 
		System.setProperty(Constants.DriverType, Constants.WebDriverPath); 
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		  		  
		// initialize / start the test
		scenario = scenarioInput;
		test = extent.startTest(scenario.getName());
	} 
	
	@After 
	public void tearDown() throws InterruptedException 
	{ 
		extent.flush();
		driver.close(); 
		driver.quit(); 
	} 
	
	@Given("^the login page$")
	public void the_login_page() 
	{	    
		test.log(LogStatus.INFO, "Navigating to: " + Constants.BaseURL);
	    driver.get(Constants.BaseURL);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}

	@When("^I login$")
	public void i_login() 
	{
		String user = "Admin";
		String password = "AdminAdmin";
		
		test.log(LogStatus.INFO, "Login in using: " + user + " " + password);		
		loginPage.login(user, password);    
	}

	@When("^I click the PIM tab$")
	public void i_click_the_PIM_tab() 
	{
		test.log(LogStatus.INFO, "Selecting 'PIM' menu item");
		basePage = PageFactory.initElements(driver, _BasePage.class);
		basePage.selectMenuPIM();
	}

	@When("^then the Add Employee Tab$")
	public void then_the_Add_Employee_Tab() 
	{
		test.log(LogStatus.INFO, "Selecting 'Add Employee' menu item");
		basePage.selectMenuAddEmployee(driver);
	}

	@When("^I fill out the Add Employee Details correctly$")
	public void i_fill_out_the_Add_Employee_Details_correctly() 
	{
		firstname = "TonyTheGod";
		lastname = "Gorgous";
		
		test.log(LogStatus.INFO, "Add Employee with details: " + firstname + " " + lastname);
		addEmployeePage = PageFactory.initElements(driver, AddEmployeePage.class);
		addEmployeePage.AddEmployee(driver, firstname, lastname);
	}

	@When("^I choose to create Login Details by clicking the appropriate button$")
	public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button()
	{
		test.log(LogStatus.INFO, "Click login details");
		addEmployeePage.clickLoginDetails(driver);
	}

	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() 
	{
		username = "TonyGorgous12";
		String password = "TonyGTonyG";
		test.log(LogStatus.INFO, "Set Employee login details to: " + username + " " + password);
		addEmployeePage.SetLoginDetails(driver, username, password);
	}

	@When("^I click the Save button$")
	public void i_click_the_Save_button() 
	{
		test.log(LogStatus.INFO, "Click save button");
		addEmployeePage.clickSave();
	}

	@Then("^I can search for the Employee I have just created$")
	public void i_can_search_for_the_Employee_I_have_just_created()
	{
//		test.log(LogStatus.INFO, "Select 'Employee List' menu item");
//		basePage = PageFactory.initElements(driver, _BasePage.class);
//		basePage.selectMenuEmployeeList(driver);
		
		test.log(LogStatus.INFO, "Search for Employee just created: " + firstname + " " + lastname);
		employeeListPage = PageFactory.initElements(driver, EmployeeListPage.class);
		employeeListPage.SearchForEmployee(driver, firstname);
	}

	@Then("^select them for inspection$")
	public void select_them_for_inspection() 
	{
		test.log(LogStatus.INFO, "Select Employee for inspection");
		
	    driver.get("https://qa-trials641.orangehrmlive.com/client/#/pim/employees");
		
		personalDetailsPage = PageFactory.initElements(driver, PersonalDetailsPage.class);
		
		if (personalDetailsPage.getFirstName(driver).equals(firstname) && personalDetailsPage.getFirstName(driver).equals(lastname))
			test.log(LogStatus.PASS, "Employee found");
		else
			test.log(LogStatus.FAIL, "Employee not found");
		
		assertTrue(personalDetailsPage.getFirstName(driver).equals(firstname));
		assertTrue(personalDetailsPage.getFirstName(driver).equals(lastname));
	}

}
