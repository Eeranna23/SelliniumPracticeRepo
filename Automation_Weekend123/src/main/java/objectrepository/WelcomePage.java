package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	@FindBy(linkText = "Register")
	private WebElement registerlink;
	
	@FindBy(linkText = "Log in")
	private WebElement loginlink;
	
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public WebElement getRegisterLink() {
		return registerlink;
	}
	public WebElement getLoginLink() {
		return loginlink;
	}

}
