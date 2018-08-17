package maven_archtype_quickstart.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeListPage extends _BasePage
{
	@FindBy(id = "employee_name_quick_filter_employee_list_value")
	private WebElement SearchTextBox;

	
//	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='No results found'])[1]/following::div[1]")
	@FindBy(xpath = "//*[@id=\"right-side\"]/header/div/nav/div/div/ul[2]/li[2]/a")
	private WebElement SearchBtn;

	public void SearchForEmployee(WebDriver driver, String username)
	{
		WebElement myDynamicElement = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(SearchTextBox)); 
		myDynamicElement.click();
		myDynamicElement.clear();
		myDynamicElement.sendKeys(username);	
		SearchBtn.click();	
	}
	
	public void SelectFirstEmployee()
	{
//	    driver.get("https://qa-trials641.orangehrmlive.com/client/#/pim/employees");
//	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Supervisor'])[1]/following::td[2]")).click();
	}
}
