package com.st.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	protected WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {

		System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@AfterSuite
	public void afterSuite() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null != driver) {
			driver.close();
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

}
