package maven_archtype_quickstart.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	@FindBy(id = "txtUsername")
	private WebElement usernameTextBox;

	@FindBy(id = "txtPassword")
	private WebElement passwordTextBox;
	
	@FindBy(id = "btnLogin")
	private WebElement loginBtn;
	
	public void login(String username, String password)
	{
		usernameTextBox.click();
		usernameTextBox.clear();
		usernameTextBox.sendKeys(username);
		passwordTextBox.click();
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		loginBtn.click();
	}
}
