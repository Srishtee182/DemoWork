package com.saucedemo.tests;

import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.saucedemo.base.TestBase;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage; 
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualTitle= loginPage.validateTitleLoginPage();
		Assert.assertEquals(actualTitle, "Swag Labs");
	}
	
	@Test(priority = 2)
	public void loginPageLogoTest() {
		boolean flag = loginPage.validateLogoLoginPage();
		Assert.assertTrue(flag);
	}
	@Test(priority = 3)
	public void loginPageTest() {
		homePage = loginPage.loginPage(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
