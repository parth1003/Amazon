package com.amazon.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase{
	//Page Factory - OR:
						
			@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
			WebElement userNameLabel;
			
			@FindBy(xpath="//select[@id='searchDropdownBox']")
			WebElement dropdownsearchbox;
			
			@FindBy(xpath="//a[contains(text(),'Gift Ideas')]")
			WebElement giftIdeas;
			
			@FindBy(xpath="//a[contains(text(),'Health & Household')]")
			WebElement healthAndHousehold;
			
			@FindBy(xpath="//a[contains(text(),'Beauty & Personal Care')]")
			WebElement beautyandPersonalCare;
			
			@FindBy(xpath="//a[@id='nav-link-accountList']")
			WebElement Youraccount;
			
			
			
			//Initializing the Page Objects:
			public HomePage(){
				PageFactory.initElements(driver, this);
				
				
			}
			
			//Actions:
			public String validateHomePageTitle(){
				return driver.getTitle();
			}
			public boolean varifyUserLogin(){
				return userNameLabel.isDisplayed();
			}
			public String verifysearchdropdownbox() {
				JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", dropdownsearchbox);
				Select s = new Select( dropdownsearchbox);
				 s.selectByVisibleText("Baby");
				 return dropdownsearchbox.getText();				
			}
			
			
			
			public BeautyandPersonalCarePage clickOnbeautyandPersonalCare() {
				beautyandPersonalCare.click();
				return new BeautyandPersonalCarePage();
			}
			
			public HealthAndHouseholdPage clickOnhealthAndHousehold() {
				healthAndHousehold.click();
				return new HealthAndHouseholdPage();
			}
			public GiftIdeasPage clickOngiftIdeas() {
				giftIdeas.click();
				return new GiftIdeasPage();
			}
			
			public YouraccountPage clickYouraccount() {
				Youraccount.click();
				return new YouraccountPage();
			}
		
		

}
