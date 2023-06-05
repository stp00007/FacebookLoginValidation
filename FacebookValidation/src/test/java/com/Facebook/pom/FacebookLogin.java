package com.Facebook.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLogin {
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement un;
	@FindBy(xpath="//input[@id='pass']")
	private WebElement pass;
	@FindBy(xpath = "//button[@name='login']")
	private WebElement but;
	public FacebookLogin(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void log(String user, String password) 
	{
		un.sendKeys(user);
		pass.sendKeys(password);
		but.click();
	}
	

}
