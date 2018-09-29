package hrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hrm.base.TestBase;
import hrm.pages.HomePage;
import hrm.pages.LoginPage;
import hrm.util.TestUtil;

public class LoginpageTest extends TestBase{
	
	LoginPage loginpg;
	HomePage homepg;
	TestUtil testutil;
	
	public LoginpageTest(){
		super();//first super constructor is called , goes to testbase constroucter
		        //first, before initialization.
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
	    loginpg = new LoginPage();	
	    testutil = new TestUtil();
	}
	
	@Test
	public void loginpageTitleTest() throws InterruptedException{
		String title = loginpg.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
		Thread.sleep(1000);
	}
	
	@Test
	public void hrmLogoTest(){
		boolean bn = loginpg.validateHRMImage();
		Assert.assertTrue(bn);
	}
	
	@Test
	public void loginTest(){
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teardown() throws InterruptedException{
		//testutil.logout();
		driver.quit();
	}
	
	
	
	
	
	

}
