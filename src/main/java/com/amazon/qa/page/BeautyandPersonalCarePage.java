package com.amazon.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class BeautyandPersonalCarePage extends TestBase {
	@FindBy(xpath="//h1[contains(text(),'Beauty Store')]")
	WebElement beautyLabel;
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-bold'][contains(text(),'Hair Care')]")
	WebElement hairCareProduct;
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-bold'][contains(text(),'Makeup')]")
	WebElement makeupProduct;
	
	//Initializing the Page Objects:
	public BeautyandPersonalCarePage(){
		PageFactory.initElements(driver, this);
		}
	
	public String validateBeautyandPersonalCarePageTitle(){	
		
		return driver.getTitle();
		}
	
	public boolean validateBeautyLabel(){
		return beautyLabel.isDisplayed();
		}
	
	public boolean validteHaircareProductLabel() {
		return hairCareProduct.isDisplayed();
	}
	
	public MakeupProductlPage valideteMakeupProductlLableLink() {
		makeupProduct.click();
		return new MakeupProductlPage();
		
	}

	
	

}
