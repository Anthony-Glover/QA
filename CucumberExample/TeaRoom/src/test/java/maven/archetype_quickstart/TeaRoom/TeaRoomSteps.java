package maven.archetype_quickstart.TeaRoom;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TeaRoomSteps {
	
	private WelcomePage welcomePage;
	private MenuPage menuPage;
	WebDriver driver;
	private ExtentReports extent;
	ExtentTest test;
	private Scenario scenario;
	private static boolean bFirstTime = true;

	public TeaRoomSteps()
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
		
	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() 
	{
		test.log(LogStatus.INFO, "Clicking Checkout");
		menuPage.CheckoutItem();
	}
	
	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page()
	{
		if (driver.getCurrentUrl().equals(Constants.CheckoutURL))
			test.log(LogStatus.PASS, "Taken to the checkout page. " + scenario.getStatus());
		else
			test.log(LogStatus.FAIL, "Not taken to the checkout page. " + scenario.getStatus());
		
		assertTrue("Items checked out", driver.getCurrentUrl().equals(Constants.CheckoutURL));
	}
	
	@Then("^I can browse a list of the available products$")
	public void i_can_browse_a_list_of_the_available_products()
	{
		if (menuPage.itemsExist())
			test.log(LogStatus.PASS, "Items in menu page. " + scenario.getStatus());
		else
			test.log(LogStatus.FAIL, "Items not in menu page. " + scenario.getStatus());
		
		assertTrue("Items do not Exist", menuPage.itemsExist());
	}

	@Given("^the correct \"([^\"]*)\" web address$")
	public void the_correct_web_address(String arg1) 
	{
		test.log(LogStatus.INFO, "Navigate to web address" + arg1);
		driver.get(arg1);
		welcomePage = PageFactory.initElements(driver, WelcomePage.class);
	}

	@When("^I navigate to the 'Menu' page  \"([^\"]*)\"$")
	public void i_navigate_to_the_Menu_page(String arg1) 
	{
		test.log(LogStatus.INFO, "Navigate to Menu page");
		welcomePage.SelectMenuMenu();
		menuPage = PageFactory.initElements(driver, MenuPage.class);
	}
}
