package hrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hrm.base.TestBase;
import hrm.pages.AddEmpPage;
import hrm.pages.HomePage;
import hrm.pages.LoginPage;
import hrm.pages.PIMPage;
import hrm.util.TestUtil;

public class PIMPageTest extends TestBase {
	
	LoginPage loginpg;
	HomePage homepg;
	PIMPage pimpg;
	AddEmpPage addemp;
	TestUtil testutil;
	
	
	public PIMPageTest(){
		super();//first super constructor is called , goes to testbase constroucter
		        //first, before initialization.
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
	    loginpg = new LoginPage();//pre-req to check homepag	
	    homepg= loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
	    homepg.clickonPIMLink();
	    pimpg =new PIMPage();
	     testutil = new TestUtil();
	}
 
	@Test
	public void verifyaddempTest(){
		addemp = pimpg.clickonaddemp();
	}

	@AfterMethod
	public void teardown() throws InterruptedException{
		testutil.logout();
		driver.quit();
	}

}
