package com.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.saucedemo.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[text()='Products']")
	WebElement homePageHeader;

	@FindBy(className = "product_sort_container")
	WebElement sortDropdown;

	@FindAll(@FindBy(how = How.XPATH, using = "//select[@class=\"product_sort_container\"]/option"))
	List<WebElement> sortDropdownOptions;

	@FindBy(xpath = "//div[text()=\"Sauce Labs Backpack\"]//following::button[contains(text(),'ADD TO CART')]")
	WebElement addToCartButton;

	@FindBy(xpath = "//*[contains(@class,'shopping_cart_badge')]")
	static WebElement cartIcon;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public void clicksortDropdownOptions(String[] ex) {
		sortDropdown.click();
		for (int i = 0; i < ex.length; i++) {
			System.out.println(sortDropdownOptions.get(i).getText());
			Assert.assertEquals(ex[i], sortDropdownOptions.get(i).getText());
		}

	}

	public boolean verifyAddProduct(String productName) {
		driver.findElement(
				By.xpath("//div[text()=" + productName + "]//following::button[contains(text(),'ADD TO CART')]"))
				.click();
		return cartIcon.isDisplayed();
	}

	public ProductPage ClickOnProduct(String productName) {
		driver.findElement(By.xpath("//div[text()=" + productName + "]")).click();
		return new ProductPage();
	}

	public CartPage clickOnCart() {
		cartIcon.click();
		return new CartPage();
	}
}