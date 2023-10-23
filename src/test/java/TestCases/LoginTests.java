package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Components.BaseT;
import Pages.LoginPage;
import junit.framework.Assert;

public class LoginTests extends BaseT{
	
	
	@Test
	public void validLogin() throws IOException {	 		   
		   lp.loginFunction("standard_user","secret_sauce");
	}
	
	@Test
	public void invalidLogin() throws IOException {	 		   
		   lp.loginFunction("standard_userd","secret_sauce");
		   Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", lp.loginErrorMessage());
	}
	

}
