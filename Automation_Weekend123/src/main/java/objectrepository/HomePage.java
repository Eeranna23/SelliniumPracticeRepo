package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(linkText = "Log out")
	private WebElement logoutlink;
	
	@FindBy(partialLinkText = "BOOKS")
	private WebElement bookslink;
	
	@FindBy(partialLinkText = "COMPUTERS")
	private WebElement computerslink;
	
	@FindBy(partialLinkText ="ELECTRONICS")
	private WebElement electronicslink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getElectronicslink() {
		return electronicslink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}

	public WebElement getBookslink() {
		return bookslink;
	}

	public WebElement getComputerslink() {
		return computerslink;
	}
	
}
