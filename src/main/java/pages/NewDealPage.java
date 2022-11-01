package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class NewDealPage extends TestBase{
	
	//elelemnt initialization
	public NewDealPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
//Element repo
	@FindBy (xpath = "")
	WebElement element;
	
	//Action
	
}
