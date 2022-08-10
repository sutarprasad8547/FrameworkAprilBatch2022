package tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.NewContactPage;
import util.Utility;

public class NewContactPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	NewContactPage contactPage;

	@BeforeMethod
	public void initialization() throws IOException {
		init();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@DataProvider(name="empData")
	public String[][] passData() {
		String data [][] = Utility.getData;
		return data;
	}
	
	@Test(dataProvider ="empData")
	public void validateNewCreateContactTest(String FN,String LN,String compName, String MobNumber,String add) {
		Utility.switchToMainFrame();
		contactPage = homePage.clickOnNewContact();
		contactPage.createContact(FN,LN,compName,MobNumber,add);
	}

	
	@AfterMethod()
		public void closeResources() {
			
		}
	}
