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
	
	
	@Test
	public void emptyFields() throws IOException {	 		   
		   lp.loginFunction("","");
		 Assert.assertEquals("Epic sadface: Username is required", lp.loginErrorMessage());
	}
	
	@Test
	public void emptUserName() throws IOException {	 		   
		   lp.loginFunction("","secret_sauce");
		 Assert.assertEquals("Epic sadface: Username is required", lp.loginErrorMessage());
	}
	
	@Test
	public void emptPassWord() throws IOException {	 		   
		   lp.loginFunction("standard_userd","");
		 Assert.assertEquals("Epic sadface: Password is required", lp.loginErrorMessage());
	}
	

}
