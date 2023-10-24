package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstract {
	
	WebDriver driver;

	public Abstract(WebDriver driver) {
		this.driver=driver;		
	}
	
	
	public WebDriverWait waitForByElement(By element) {
		WebDriverWait waitBy=new WebDriverWait(driver,Duration.ofSeconds(5));
		waitBy.until(ExpectedConditions.visibilityOfElementLocated(element));
		
		return waitBy;
	}
	
	
    public WebDriverWait waitForWebElement(WebElement element) {
		WebDriverWait waitweb=new WebDriverWait(driver,Duration.ofSeconds(5));
		waitweb.until(ExpectedConditions.visibilityOf(element));
		return waitweb;
	}


}
