package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Components.BaseT;
import Pages.LoginPage;


public class LoginTests extends BaseT{
	
	
	//Verify successfull login
	@Test (priority = 0) 
	public void validLogin() throws IOException {	 		   
		   lp.loginFunction("standard_user","secret_sauce");
	}
	
	//Verify the unsuccessfull login
	@Test (priority = 1) 
	public void invalidLogin() throws IOException {	 		   
		   lp.loginFunction("standard_userd","secret_sauce");
		   Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", lp.loginErrorMessage());
	}
	
	
	//Checking the login function without inserting Username and Password
	@Test (priority = 2) 
	public void emptyFields() throws IOException {	 		   
		   lp.loginFunction("","");
		 Assert.assertEquals("Epic sadface: Username is required", lp.loginErrorMessage());
	}
	
	
	//Checking the login function without inserting Username
	@Test (priority = 3) 
	public void emptyUserName() throws IOException {	 		   
		   lp.loginFunction("","secret_sauce");
		 Assert.assertEquals("Epic sadface: Username is required", lp.loginErrorMessage());
	}
	
	//Checking the login function without inserting Password
	@Test (priority = 4) 
	public void emptPassWord() throws IOException {	 		   
		   lp.loginFunction("standard_userd","");
		 Assert.assertEquals("Epic sadface: Password is required", lp.loginErrorMessage());
	}
	

}
