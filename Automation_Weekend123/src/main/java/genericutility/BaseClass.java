package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

public class BaseClass {
	public static ExtentReports eReports;
	public static ExtentTest test;
	public static WebDriver driver;
	public JavaUtility jUtil= new JavaUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public FileUtility fUtil=new FileUtility();
	public ExcelUtility eUtil= new ExcelUtility();
	
	@BeforeSuite
	public void reportConfig() {
		ExtentSparkReporter spark= new ExtentSparkReporter("./HTML_Reports/extentReport_"+jUtil.getSystemTime()+".html");
		eReports = new ExtentReports();
		eReports.attachReporter(spark);
		
	}
	
	@BeforeClass
	public void  openBrowser() throws IOException {
		driver=new ChromeDriver();
		wUtil.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(fUtil.getDataFromProperty("url"));
	}
	
	@BeforeMethod
	public void login() throws IOException {
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		LoginPage Ip=new LoginPage(driver);
		Ip.getEmailTextField().sendKeys(fUtil.getDataFromProperty("email"));
		Ip.getPasswordTextField().sendKeys(fUtil.getDataFromProperty("password"));
		Ip.getLoginButton().click();
		
		
	}
	@AfterMethod
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.getLogoutlink().click();
		
	}
	

	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup() {
		eReports.flush();
	}

}
