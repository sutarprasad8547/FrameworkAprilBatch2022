package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{
	
	//1.Web Element repository
	
	@FindBy(xpath="//*[contains(text(),'Logout')]")
	WebElement logoutBtn;
	
	@FindBy(xpath = " //a[text()='Contacts']")
	WebElement contacts;
	
	@FindBy(xpath= " //a[text()='New Contact']")
	WebElement createContactLink;
	
	@FindBy(xpath = " //a[text()='Companies']")
	WebElement company;
	
	
	@FindBy(xpath=" //a[text()='New Company']")
	WebElement createCompanyLink;
	

	//2.actions
	public void logout() {
		logoutBtn.click();
	}
	
	
	public NewContactPage clickOnNewContact() {
		Actions act = new Actions(driver);
		act.moveToElement(contacts).build().perform();
		createContactLink.click();
		return null;
	}
	
	public void clickOnNewCompany() {
		Actions act = new Actions(driver);
		act.moveToElement(company).build().perform();
		createCompanyLink.click();
	}
	
	//3. We will use page factory class to initialize webelements

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
}
