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
import com.amazon.qa.page.MakeupProductlPage;

public class BeautyandPersonalCarePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	GiftIdeasPage giftIdeasPage;
	HealthAndHouseholdPage healthAndHouseholdPage;
	BeautyandPersonalCarePage beautyandPersonalCarePage;
	MakeupProductlPage makeupProductlPage;
	//HomePage homePage =new HomePage() ;
	
	
	public BeautyandPersonalCarePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		giftIdeasPage=new GiftIdeasPage();
		makeupProductlPage = new MakeupProductlPage();
		healthAndHouseholdPage= new HealthAndHouseholdPage();
		beautyandPersonalCarePage=new BeautyandPersonalCarePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		beautyandPersonalCarePage=homePage.clickOnbeautyandPersonalCare();
		
	}
	
	@Test(priority=1)
	public void VerifyBeautyPageTitleTest() throws InterruptedException {
		Thread.sleep(3000);		
		String title = beautyandPersonalCarePage.validateBeautyandPersonalCarePageTitle();
		Assert.assertEquals(title, "Amazon.ca: Beauty & Personal Care","HomePage Title not Match");
	}
	
	@Test(priority=2)
	public void varifyBeautyLabelTest(){
		boolean userName = beautyandPersonalCarePage.validateBeautyLabel();
		//Assert.assertEquals(userName, "Beauty Store");
		Assert.assertTrue(userName);
	}
	@Test(priority=3)
	public void varifyHaircareProductLabellTest(){
		boolean userName = beautyandPersonalCarePage.validteHaircareProductLabel();
		//Assert.assertEquals(userName, "Beauty Store");
		Assert.assertTrue(userName);
	}
	
	
	@Test(priority=4)
	public void varifyMakeupProductlLableLinkTest(){
		beautyandPersonalCarePage.valideteMakeupProductlLableLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
