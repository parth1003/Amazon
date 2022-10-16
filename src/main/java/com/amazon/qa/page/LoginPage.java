package com.amazon.qa.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;


public class LoginPage extends TestBase {
	//Page Factory - OR:
		@FindBy(name="email")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginBtn;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement contBtn;
		
		@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		WebElement signUpBtn;
		
		@FindBy(xpath="//i[@class='a-icon a-icon-logo']")
		WebElement crmLogo;
		
		@FindBy(xpath="//a[@id='nav-link-accountList']")
		WebElement signIn;
		
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
			signIn.click();
			
			
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			
						return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return crmLogo.isDisplayed();
		}
		
		public HomePage login(String un, String pwd){
			username.sendKeys(un);
			contBtn.click();
			password.sendKeys(pwd);
			//contBtn.click();
			//loginBtn.click();
			    	JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", contBtn);
			    	
			return new HomePage();
		}
		
	}


