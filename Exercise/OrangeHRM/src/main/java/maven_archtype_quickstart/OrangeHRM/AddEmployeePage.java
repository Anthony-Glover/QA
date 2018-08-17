package maven_archtype_quickstart.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage 
{
	@FindBy(id = "firstName")
	private WebElement firstNameTextBox;

	@FindBy(id = "lastName")
	private WebElement lastNameTextBox;
	
	@FindBy(xpath = "//*[@id=\"location_inputfileddiv\"]/div/input")
	private WebElement RegionBox;
		
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Australia'])[1]/following::span[1]")
	private WebElement RegionBoxAustralia;

	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='*'])[3]/following::label[2]")
	private WebElement LoginDetailsCheckbox;

	@FindBy(id = "username")
	private WebElement usernameTextBox;

	@FindBy(id = "password")
	private WebElement passwordTextBox;

	@FindBy(id = "confirmPassword")
	private WebElement confirmPasswordTextBox;

	@FindBy(id = "systemUserSaveBtn")
	private WebElement systemUserSaveBtn;

	public void AddEmployee(WebDriver driver, String firstName, String lastName)
	{
		WebElement myDynamicElement = (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(firstNameTextBox)); 
		myDynamicElement.click();
		myDynamicElement.clear();
		myDynamicElement.sendKeys(firstName);

		lastNameTextBox.click();
		lastNameTextBox.clear();
		lastNameTextBox.sendKeys(lastName);
		
		RegionBox.click();
		myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(RegionBoxAustralia)); 
		myDynamicElement.click();
	}

	public void clickLoginDetails(WebDriver driver)
	{
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(LoginDetailsCheckbox)); 
		myDynamicElement.click();
	}
	
	public void SetLoginDetails(WebDriver driver, String username, String password)
	{
		WebElement myDynamicElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(confirmPasswordTextBox)); 
		usernameTextBox.click();
		usernameTextBox.clear();
		usernameTextBox.sendKeys(username);

		passwordTextBox.click();
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);

		confirmPasswordTextBox.click();
		confirmPasswordTextBox.clear();
		confirmPasswordTextBox.sendKeys(password);
	}
	public void clickSave()
	{
		systemUserSaveBtn.click();
	}
}
