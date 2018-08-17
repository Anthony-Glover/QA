package maven_archtype_quickstart.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _BasePage 
{
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Audit Trail'])[1]/following::span[3]")
	private WebElement menuPIM;
	
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Employee List'])[1]/following::span[3]")
	private WebElement menuEmployee;
	
	@FindBy(id = "menu_pim_viewEmployeeList")
	private WebElement menuEmployeeList;
	
	@FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/div")
	private WebElement menuPIMModule;
	public void selectMenuPIM()
	{
		menuPIM.click();
	}

	public void selectMenuAddEmployee(WebDriver driver)
	{
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(menuEmployee)); 
		myDynamicElement.click();
	}
	
	public void selectMenuEmployeeList(WebDriver driver)
	{
		WebElement myDynamicElement = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(menuEmployeeList)); 
		myDynamicElement.click();
	}
}
