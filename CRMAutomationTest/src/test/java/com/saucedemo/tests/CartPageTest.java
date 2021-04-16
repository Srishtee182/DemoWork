package com.saucedemo.tests;

import java.awt.Checkbox;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.base.TestBase;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckOutPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;

public class CartPageTest extends TestBase {

	public class ProductPageTest extends TestBase {
		LoginPage loginPage;
		HomePage homePage;
		boolean productPage;
		CartPage cartPage;
		CheckOutPage checkoutPage;
		public ProductPageTest() {
			super();
		}

		@BeforeMethod
		public void setUp() {
			launchBrowser();
			loginPage = new LoginPage();
			homePage = loginPage.loginPage(prop.getProperty("username"), prop.getProperty("password"));
			productPage = homePage.verifyAddProduct(HomePageTest.productName);
			cartPage = homePage.clickOnCart();
		}

		@Test
		public void clickOnCheckout() {
			checkoutPage = cartPage.clickCheckOut();
		
		}

		@AfterMethod
		public void closeBrowser() {
			driver.quit();
		}
	}
}