package hrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hrm.base.TestBase;
import hrm.pages.AddEmpPage;
import hrm.pages.HomePage;
import hrm.pages.JobPage;
import hrm.pages.LoginPage;
import hrm.pages.PIMPage;
import hrm.pages.PersonalDetailsPage;
import hrm.util.TestUtil;

public class PersonalDetailsTest extends TestBase{
	
	LoginPage loginpg;
	HomePage homepg;
	PIMPage pimpg;
	AddEmpPage addemppg;
	PersonalDetailsPage personalpg;
	JobPage jobpage;
	TestUtil testutil;
	
	public PersonalDetailsTest(){
		super();//first super constructor is called , goes to testbase constroucter
		        //first, before initialization.
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
	    loginpg = new LoginPage();//pre-req to check homepag
	    testutil = new TestUtil();
	    homepg= loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
	    pimpg = homepg.clickonPIMLink();
	    addemppg = pimpg.clickonaddemp();
	    personalpg = addemppg.addemp("abcd", "zero11");
	    
	 
	}

	@Test
	public void verifyClickonJobTest(){
	jobpage	= personalpg.clickonjob();
	}

	@AfterMethod
	public void teardown() throws InterruptedException{
		testutil.logout();
		driver.quit();
	}
}
