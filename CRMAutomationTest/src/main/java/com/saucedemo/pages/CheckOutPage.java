package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.base.TestBase;

public class CheckOutPage extends TestBase {
	@FindBy(className = "app_logo")
	WebElement appLogoIcon;

	@FindBy(id = "first-name")
	WebElement firstName;

	@FindBy(id = "last-name")
	WebElement lastName;

	@FindBy(id = "postal-code")
	WebElement postalCode;

	@FindBy(xpath = "//input[@value=\"CONTINUE\"]")
	WebElement continueButton;

	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}

	public void userDataCheckoutPage(String first, String last, String code) {
		firstName.sendKeys(first);
		lastName.sendKeys(last);
		postalCode.sendKeys(code);
		continueButton.click();
	}

	public boolean textPresentCheckoutPage(String texts) {
			return driver.findElement(By.xpath("//div[contains(text(),"+ texts +")]")).isDisplayed();
	}
}
