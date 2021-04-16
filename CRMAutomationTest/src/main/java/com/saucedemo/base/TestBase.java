package com.saucedemo.base;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.saucedemo.utilities.TestUtil;
import com.saucedemo.utilities.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	static EventFiringWebDriver eventfiring;

	public TestBase() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("Resources//config.properties"));
			prop = new Properties();
			try {
				prop.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void launchBrowser() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"SauceDemoAutomationTest/src/main/java/com/saucedemo/utilities/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//listener code
		eventfiring = new EventFiringWebDriver(driver);
		WebEventListener eventListner = new WebEventListener();
		eventfiring.register(eventListner);
		driver = eventfiring;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}