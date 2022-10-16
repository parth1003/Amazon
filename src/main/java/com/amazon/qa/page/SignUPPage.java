package com.amazon.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class SignUPPage extends TestBase {
	//Page Factory - OR:
			@FindBy(id="createAccountSubmit")
			WebElement createaccount;
			
			@FindBy(name="password")
			WebElement password;
			
			@FindBy(xpath="//input[@type='submit']")
			WebElement loginBtn;
			
			@FindBy(xpath="//a[@id='nav-link-accountList']")
			WebElement signIn;
			
			
			
			//Initializing the Page Objects:
			public SignUPPage(){
				PageFactory.initElements(driver, this);
				signIn.click();
				
				
			}
			
	

}

