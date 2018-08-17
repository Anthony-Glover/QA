package maven_archtype_quickstart.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalDetailsPage 
{
	@FindBy(id = "first_name")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "last_name")
	private WebElement lastNameTextbox;
	
	public String getFirstName(WebDriver driver)
	{
		WebElement myDynamicElement = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(firstNameTextbox)); 
		return myDynamicElement.getText();
	}
	
	public String getLastName(WebDriver driver)
	{
		WebElement myDynamicElement = (new WebDriverWait(driver, 40)).until(ExpectedConditions.elementToBeClickable(lastNameTextbox)); 
		return myDynamicElement.getText();
	}
}
