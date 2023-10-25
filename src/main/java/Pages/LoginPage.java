package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Abstract;

public class LoginPage extends Abstract{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
		
	@FindBy(xpath="//input[@id='user-name']")
	WebElement Username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement logButton;	
	
	@FindBy(css=".error-message-container")
	WebElement errorM;
	
	//URL
	public void goTo() {
		driver.get("https://www.saucedemo.com/");
	}
	
	
	public void loginFunction(String Uname,String Pword) {
		Username.sendKeys(Uname);
		password.sendKeys(Pword);
		logButton.click();	
		
	}
	
	public String loginErrorMessage() {
		waitForWebElement(errorM);
		return errorM.getText();
	}
	
	
	
	

}
