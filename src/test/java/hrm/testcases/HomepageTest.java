package hrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hrm.base.TestBase;
import hrm.pages.HomePage;
import hrm.pages.LoginPage;
import hrm.pages.PIMPage;
import hrm.util.TestUtil;

public class HomepageTest extends TestBase {
	
	LoginPage loginpg;
	HomePage homepg;
	PIMPage pimpg;
	TestUtil testutil;
	
	public HomepageTest(){
		super();//first super constructor is called , goes to testbase constroucter
		        //first, before initialization.
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization();
		Thread.sleep(2000);
	    loginpg = new LoginPage();//pre-req to check homepag
	    homepg= new HomePage();
	    homepg= loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
	    pimpg =new PIMPage();
	    testutil = new TestUtil();
	}
 
	@Test
	public void verifyHomepageTitleTest(){
		String pagetitle = homepg.verifyHomepageTitle();
		Assert.assertEquals(pagetitle, "OrangeHRM","Homepage title not matched");
	}
	
	@Test
	public void verifyHomepageLabeltest(){
		Assert.assertTrue(homepg.verifyHomepageUserLabel());
	}
	@Test
	public void verifyPIMLinkTest(){
		pimpg = homepg.clickonPIMLink();
	}

	
	@AfterMethod
	public void teardown() throws InterruptedException{
		testutil.logout();
		driver.quit();
	}
	
}
