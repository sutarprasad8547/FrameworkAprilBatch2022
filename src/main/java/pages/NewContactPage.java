package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class NewContactPage extends TestBase{
	
	//Element repository

	@FindBy(xpath = "//*[text()='Contact Information']")
	WebElement contactPageTxt;
	
	@FindBy(name= "first_name")
	WebElement firsNameTxtBox;
	
	@FindBy(id="surname")
	WebElement lastNameTxtBox;
	
	@FindBy(name="client_lookup")
	WebElement companyNameTxtBox;
	
	@FindBy(id="mobile")
	WebElement mobileNumberTxtBox;
	
	@FindBy(name="address")
	WebElement addressTxtBox;
	
	@FindBy(xpath="/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	
	//To create contact WebElements
			
	//Action
	
	public String getContactPageTxt() {
		String txt = contactPageTxt.getText();
		return txt;
	}
	
	public void createContact(String FN,String LN,String compName, String MobNumber,String add) {
		firsNameTxtBox.sendKeys(FN);
		lastNameTxtBox.sendKeys(LN);
		companyNameTxtBox.sendKeys(compName);
		mobileNumberTxtBox.sendKeys(MobNumber);
		addressTxtBox.sendKeys(add);
		saveBtn.click();
		
	}
	
	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}
}
