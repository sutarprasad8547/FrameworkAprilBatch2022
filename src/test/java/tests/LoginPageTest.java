package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	
	@BeforeMethod
		public void initialization() throws IOException {
		init();
		loginPage = new LoginPage();
	}
	@Parameters({"usename","password"})
	@Test
	public void validateLoginTest(String uid, String pwd) {
		loginPage.login("Speedway2016", "Speedway@2016");
		
		driver.switchTo().frame("mainpanel");
		String userName = loginPage.getUserId();
		System.out.println(userName);
		Assert.assertEquals(userName,"  User: GANESH KAKADE");
		
	}
	@Test
	public void validateLogoTest() {
		boolean logoStatus = loginPage.is_Logo_Displayed();
		Assert.assertEquals(logoStatus, true);
	}
	//validateTitleTest
	//validateLinks
	//validateForgotPassword
		
	
	@AfterMethod
	public void closeResources() {
		driver.close();
	}
}
