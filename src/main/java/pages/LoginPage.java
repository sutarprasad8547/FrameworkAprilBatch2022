package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
	
	//1.Web Element repository
	 
	//username text box
	@FindBy(name="username")
	WebElement usernameTxtBox;
	
	//Password text box
	@FindBy(css="[placeholder='Password']")
	WebElement passwordTxtBox;
	
	//login button
	@FindBy(xpath = " //input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(className="img-responsive")
	WebElement logoImg;
	
	@FindBy(xpath="//td[contains(text(),'GANESH KAKADE')]")
	WebElement userID;
	
	
	//2.action
	public HomePage login(String username, String password) {
		usernameTxtBox.sendKeys(username);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	public String getUserId() {
		return userID.getText();
		
		}
	public boolean is_Logo_Displayed() {
	return	logoImg.isDisplayed();
		
	//3. We will use page factory class to initialize webelements
	}
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	}
	
