package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.base.TestBase;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;
	CartPage cartPage;
	String[] sortOptions = { "Name (A to Z)", "Name (Z to A)", "Price (low to high)", "Price (high to low)" };
	static String productName = "'Sauce Labs Backpack'";

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		loginPage = new LoginPage();
		homePage = loginPage.loginPage(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Swag Labs", "Title is not same"); // message will be printed only if test case will
																		// fail
	}

	@Test(priority = 2)
	public void verifyDropdownOptions() {
		homePage.clicksortDropdownOptions(sortOptions);

	}

	@Test(priority = 3)
	public void addProductToCart() {
		boolean addProduct = homePage.verifyAddProduct(productName);
		Assert.assertTrue(addProduct);
	}

	@Test(priority = 3)
	public void selectProduct() {
		productPage = homePage.ClickOnProduct(productName);

	}

	@Test(priority = 4)
	public void selectCart() {
		cartPage = homePage.clickOnCart();

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
