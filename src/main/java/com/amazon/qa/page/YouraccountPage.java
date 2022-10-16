package com.amazon.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class YouraccountPage extends TestBase {
	@FindBy(xpath="//div[@data-card-identifier='AddressesAnd1Click']")
	WebElement youraddressoption;
	
	
	@FindBy(xpath="//div[@class='a-box first-desktop-address-tile']")
	WebElement addaddressoption;
	
	@FindBy(id="address-ui-widgets-enterAddressFullName")
	WebElement fullName;
	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber")
	WebElement phonenumber;
	@FindBy(id="address-ui-widgets-enterAddressLine1")
	WebElement address;
	@FindBy(id="address-ui-widgets-enterAddressCity")
	WebElement sity;
	
	
	@FindBy(xpath="//span[@id='address-ui-widgets-enterAddressStateOrRegion']//span[contains(@class,'a-button-inner')]//span[contains(@class,'a-button-text a-declarative')]")
	WebElement prov1;
	@FindBy(xpath="//a[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8']")
	WebElement prov2;
	@FindBy(id="address-ui-widgets-enterAddressPostalCode")
	WebElement postalcode;
	@FindBy(xpath="//span[@id='address-ui-widgets-form-submit-button']")
	WebElement clickonsubmit;
	@FindBy(id="address-ui-widgets-original-address-block_id-outer")
	WebElement originaladdress;
	@FindBy(xpath="//span[@id='a-autoid-2']//span[@class='a-button-inner']")
	WebElement saveaddress;
	
	
	

	
	
	//Initializing the Page Objects:
	public YouraccountPage(){
		PageFactory.initElements(driver, this);
		}
	
	public String validateYouraccountPageTitle() throws InterruptedException{	
		youraddressoption.click();
		addaddressoption.click();
		Thread.sleep(3000);
		return driver.getTitle();
		}
	
	
	public void addAddressPage(String fulname, String phonnum , String addres,String city,String pstcode ) {
		youraddressoption.click();
		addaddressoption.click();
		fullName.sendKeys(fulname);
		phonenumber.sendKeys(phonnum);
		address.sendKeys(addres);
		sity.sendKeys(city);
		prov1.click();
		prov2.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		postalcode.sendKeys(pstcode);
		clickonsubmit.click();
		originaladdress.click();
		saveaddress.click();
			
		}

}
