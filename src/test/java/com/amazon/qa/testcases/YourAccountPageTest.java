package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.page.BeautyandPersonalCarePage;
import com.amazon.qa.page.GiftIdeasPage;
import com.amazon.qa.page.HealthAndHouseholdPage;
import com.amazon.qa.page.HomePage;
import com.amazon.qa.page.LoginPage;
import com.amazon.qa.page.MakeupProductlPage;
import com.amazon.qa.page.YouraccountPage;
import com.amazon.qa.util.TestUtil;

public class YourAccountPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	YouraccountPage accountPage;
	TestUtil testutilPage;
	String sheetName="addAddress";
	public YourAccountPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		accountPage=new YouraccountPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	//@Test(priority=1)
	public void VerifyBeautyPageTitleTest() throws InterruptedException {
		Thread.sleep(3000);		
		String title = accountPage.validateYouraccountPageTitle();
		Assert.assertEquals(title, "Your Account");
	}
	@DataProvider
	public Object[][] getAmazonTestData()
	{
		Object[][] data=TestUtil.getTestData(sheetName);
		return data;	
	}
	
	@Test(priority=2, dataProvider="getAmazonTestData")
	public void varifycreateNewContact(String fullName,String phonenumber, String address,String city, String postalcode){
		homePage.clickYouraccount();
		//accountPage.addAddressPage("parthmukeshbhai", "9974668296", "vdgdssddf", "NorthYork", "M3J2Z3");
		accountPage.addAddressPage(fullName, phonenumber, address, city, postalcode);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
