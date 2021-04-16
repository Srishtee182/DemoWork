package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends LoginPage {

	@FindBy(className = "//img[@class=\"inventory_details_img\"]")
	WebElement productImage;

	@FindBy(xpath = "//div[text()=\"Swag Labs\"]")
	WebElement pageHeader;

	@FindBy(xpath = "//button[contains(text(),'Back')]")
	WebElement backButton;

	@FindBy(xpath = "//button[contains(text(),'REMOVE')]")
	WebElement removeButton;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateTitleProductPage() {
		return driver.getTitle();

	}

	public String validateNameProductPage() {
		pageHeader.isDisplayed();
		return driver.findElement(By.className("inventory_details_name")).getText();

	}

	public boolean removeItemProductPage() {
		removeButton.click();
		return HomePage.cartIcon.isDisplayed();
	}

	public HomePage backButtonProductPage() {
		backButton.click();
		return new HomePage();

	}
}
