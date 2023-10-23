package Components;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseT {
	
	public WebDriver driver;
	public LoginPage lp;
	
	public WebDriver driverInitialize() throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\amila\\eclipse-workspace\\LolcApplicationNew\\src\\main\\java\\Resourses\\Resourses.properties");
		prop.load(file);
		String browser=prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver();
			driver=new ChromeDriver();
		}
		
		
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.edge.driver", "browser");
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	@BeforeMethod
	public LoginPage launchingApp() throws IOException {
		driver=driverInitialize();
		lp=new LoginPage(driver);
		lp.goTo();	
		return lp;
	}
	
	
	@AfterMethod
	public void closeBrowser() {
			driver.close();
	}

}
