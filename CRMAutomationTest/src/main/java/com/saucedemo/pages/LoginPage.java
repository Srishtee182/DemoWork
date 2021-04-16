package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginButton;

	@FindBy(className = "login_logo")
	WebElement loginLogo;

	// initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this); // this will point current class object
	}

	public String validateTitleLoginPage() {
		return driver.getTitle();

	}

	public boolean validateLogoLoginPage() {
		return loginLogo.isDisplayed();

	}

	public HomePage loginPage(String un,String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginButton.click();
		
		return new HomePage();
	}
}
