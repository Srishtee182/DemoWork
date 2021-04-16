package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.base.TestBase;

public class CartPage extends TestBase {

	@FindBy(className = "app_logo")
	WebElement appLogoIcon;
		
	@FindBy(xpath = "//a[contains(text(),'CHECKOUT')]")
	WebElement checkoutButton;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean logoCartPage() {
		return appLogoIcon.isDisplayed();
		
	}
	
	public CheckOutPage clickCheckOut() {
		checkoutButton.click();
		return new CheckOutPage();
		
	}
}
