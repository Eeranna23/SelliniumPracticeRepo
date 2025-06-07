package computers;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectrepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_DWS_010_Test extends BaseClass {
	@Test
	public void clickOnComputers() {
		test.log(Status.INFO,"Test execution started");
		HomePage hp = new HomePage(driver);
		hp.getComputerslink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Computers");
		test.log(Status.PASS, "Computers page is displayed");
	}

}
