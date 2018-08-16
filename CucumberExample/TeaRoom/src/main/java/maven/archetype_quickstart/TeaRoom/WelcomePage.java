package maven.archetype_quickstart.TeaRoom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage {

	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	WebElement menuBtn;
	
	public void SelectMenuMenu()
	{
		menuBtn.click();
	}
}
