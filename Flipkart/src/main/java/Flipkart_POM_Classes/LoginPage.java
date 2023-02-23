package Flipkart_POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath="//input[@maxlength='auto']")
	WebElement mobileOrEmail;
	
	@FindBy (xpath="//span[text()='CONTINUE']")
	WebElement continew;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobileOrEmail() {
		mobileOrEmail.sendKeys("797223815");
	}
	public void clickOnContinueButton() {
		continew.click();
	}

}
