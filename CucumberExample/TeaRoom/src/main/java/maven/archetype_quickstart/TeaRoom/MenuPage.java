package maven.archetype_quickstart.TeaRoom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage 
{
	@FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span")
	WebElement checkoutbtn;
	
	public boolean itemsExist()
	{
		return checkoutbtn.isDisplayed();
	}
	
	public void CheckoutItem()
	{
		checkoutbtn.click();
	}
}
