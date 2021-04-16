package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.base.TestBase;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;

public class ProductPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ProductPage productPage;

	public ProductPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		loginPage = new LoginPage();
		homePage = loginPage.loginPage(prop.getProperty("username"), prop.getProperty("password"));
		productPage = homePage.ClickOnProduct(HomePageTest.productName);
	}

	@Test(priority = 1)
	public void verifyTitleOfProductPage() {
		String title = productPage.validateTitleProductPage();
		Assert.assertEquals(title, "Swag Labs");
	}

	@Test(priority = 2)
	public void verifyNameOfProductPage() {
		String title = productPage.validateNameProductPage();
		Assert.assertEquals(title, HomePageTest.productName);
	}

	@Test(priority = 3)
	public void removeItemProductPage() {
		boolean cart = productPage.removeItemProductPage();
		Assert.assertFalse(cart);

	}

	@Test(priority = 4)
	public void backButtonProductPage() {
		homePage = productPage.backButtonProductPage();

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
