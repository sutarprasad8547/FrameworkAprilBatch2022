package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.NewContactPage;
import util.Utility;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	NewContactPage newContactPage;
	CreateCompanyPage createCompanyPage ;
	
	@Parameters({"username","password"})
	@BeforeMethod
	public void initialize(String uname, String pwd) throws IOException {
		init();
		loginPage = new LoginPage();
		newContactPage = new NewContactPage();
		createCompanyPage = new CreateCompanyPage();
		homePage = loginPage.login(uname, pwd);//it will perform login return HomePage object
	}
	
	@Test
	public void validateLogoutTest() {
		Utility.switchToMainFrame();
		homePage.logout();
		boolean logoStatus = loginPage.is_Logo_Displayed();//true
		Assert.assertTrue(logoStatus);
	}
	@Test
	public void validateRedirectionOfNewContactLink() {
	Utility.switchToMainFrame();
	homePage.clickOnNewContact();
	Assert.assertEquals(newContactPage.getContactPageTxt(), prop.getProperty("ContactPageTxt"));
	}
	
	@Test
	
	public void validateRedirectionOfNewCompanyLink() {
		Utility.switchToMainFrame();
		homePage.clickOnNewCompany();
		Assert.assertEquals(createCompanyPage.getcompanyPageTxt(), prop.getProperty("Create New  Company"));
	}
	
	
	@AfterMethod
	public void closeResources() {
		driver.close();
	}
}
