package com.Facebook.test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.Facebook.pom.FacebookLogin;


public class FacebookLoginTest {
	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void precondition() {
		
		driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void postcondition() {
		driver.close();
	}

	@DataProvider(name = "login")
	public Object[][] data() {
		Object[][] rv = new Object[3][2];
		rv[0][0] = "admin1";
		rv[0][1] = "manager1";
		rv[1][0] = "admin2";
		rv[1][1] = "manager2";
		rv[2][0] = "admin3";
		rv[2][1] = "manager3";
		return rv;
	}

	@Test(dataProvider = "login")
	public void logg(String user,String password) {
		FacebookLogin f1 = new FacebookLogin(driver);
		f1.log(user, password);
	}

}
