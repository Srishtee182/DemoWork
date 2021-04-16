package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saucedemo.base.TestBase;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckOutPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import com.saucedemo.utilities.TestUtil;

public class CheckOutPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	boolean productPage;
	CartPage cartPage;
	CheckOutPage checkoutPage;
	TestUtil utilities;
	static String sheetName = "userdata";
	static String checkoutSheet = "checkoutdata";

	public CheckOutPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		loginPage = new LoginPage();
		homePage = loginPage.loginPage(prop.getProperty("username"), prop.getProperty("password"));
		productPage = homePage.verifyAddProduct(HomePageTest.productName);
		cartPage = homePage.clickOnCart();
		checkoutPage = cartPage.clickCheckOut();

	}

	@Test(dataProvider = "testData")
	public void userData(String fn, String ln, String code) {
		checkoutPage.userDataCheckoutPage(fn, ln, code);
	}

//	@Test(dataProvider = "testData")
//	public void checkoutPageText(String pageText) {
//		
//		boolean texts = checkoutPage.textPresentCheckoutPage(pageText);
//		Assert.assertTrue(texts);
//
//	}

	@DataProvider
	public Object[][] testData() {

		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@DataProvider
	public Object[][] checkoutPageText() {

		Object data[][] = TestUtil.getTestData(checkoutSheet);
		return data;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
