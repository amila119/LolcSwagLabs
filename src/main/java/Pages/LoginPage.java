package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
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
	
	
	public void goTo() {
		driver.get("https://www.saucedemo.com/");
	}
	
	
	public void loginFunction(String Uname,String Pword) {
		Username.sendKeys(Uname);
		password.sendKeys(Pword);
		logButton.click();
	}
	
	public String loginErrorMessage() {
		return errorM.getText();
	}
	
	
	
	

}
