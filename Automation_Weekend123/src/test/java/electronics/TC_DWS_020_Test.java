package electronics;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectrepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_DWS_020_Test extends BaseClass{
	@Test
	public void clickOnElectronics() {
		test.log(Status.INFO, "test execution started");
		HomePage hp = new HomePage(driver);
		hp.getElectronicslink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Electronics");
		test.log(Status.PASS, "Electronics page is displayed");
	}
	

}
