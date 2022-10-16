package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.page.BeautyandPersonalCarePage;
import com.amazon.qa.page.GiftIdeasPage;
import com.amazon.qa.page.HealthAndHouseholdPage;
import com.amazon.qa.page.HomePage;
import com.amazon.qa.page.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage ;
	HomePage homePage;
	GiftIdeasPage giftIdeasPage;
	HealthAndHouseholdPage healthAndHouseholdPage;
	BeautyandPersonalCarePage beautyandPersonalCarePage;
	
//	HomePage homePage =new HomePage() ;
	
		
	public HomePageTest() {
		super();
		}
	@BeforeMethod
	public void setUp(){
		initialization();
		
		loginPage = new LoginPage();	
		giftIdeasPage=new GiftIdeasPage();
		healthAndHouseholdPage= new HealthAndHouseholdPage();
		beautyandPersonalCarePage=new BeautyandPersonalCarePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void VerifyHomePageTitleTest() throws InterruptedException {
		Thread.sleep(3000);		
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items","HomePage Title not Match");
	}
	@Test(priority=2)
	public void varifyUserLoginTest(){
		boolean userName = homePage.varifyUserLogin();
		//Assert.assertEquals(userName, "Hello, Parth");
		Assert.assertTrue(userName);
	}
	
	@Test(priority=3)
		public void varifybeautyandPersonalCareTest(){
			beautyandPersonalCarePage=homePage.clickOnbeautyandPersonalCare();
		}
	
	@Test(priority=4)
	public void varifyGiftIdeasPageTest(){
		giftIdeasPage=homePage.clickOngiftIdeas();
	}
	@Test(priority=5)
	public void varifyHealthAndHouseholdPageTest(){
		healthAndHouseholdPage=homePage.clickOnhealthAndHousehold();
	}


	//@Test(priority=3)
	public void VerifySerchDropdownTest() throws InterruptedException {
		Thread.sleep(3000);		
		String option = homePage.verifysearchdropdownbox();
		Assert.assertEquals(option, "Baby","dropdown option not Match");
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
