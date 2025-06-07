package books;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectrepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_DWS_001_Test extends BaseClass {
	@Test
	public void clickOnBooks() {
		HomePage hp = new HomePage(driver);
		hp.getBookslink().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis");
		test.log(Status.PASS, "Books page is displayed");
	}

}
