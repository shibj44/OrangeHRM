package hrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hrm.base.TestBase;
import hrm.pages.AddEmpPage;
import hrm.pages.EmpListPage;
import hrm.pages.HomePage;
import hrm.pages.JobPage;
import hrm.pages.LoginPage;
import hrm.pages.PIMPage;
import hrm.pages.PersonalDetailsPage;
import hrm.util.TestUtil;

public class EmpListTest extends TestBase {
	
	LoginPage loginpg;
	HomePage homepg;
	PIMPage pimpg;
	AddEmpPage addemppg;
	PersonalDetailsPage personalpg;
	JobPage jobpage;
	EmpListPage emplist;
	public static String empiid;
	TestUtil testutil;
	public EmpListTest(){
		super();//first super constructor is called , goes to testbase constroucter
		        //first, before initialization.
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
	    loginpg = new LoginPage();//pre-req to check homepag	
	    homepg= loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
	    pimpg = homepg.clickonPIMLink();
	    addemppg = pimpg.clickonaddemp();
	    empiid = addemppg.validatempid();
		System.out.println(empiid);
	    personalpg = addemppg.addemp("abcd", "zero11");
	    jobpage		= personalpg.clickonjob();
	    emplist = jobpage.clickonemplist();
	    testutil= new TestUtil();
	}

	@Test
	public void verifyEmpList(){
		
			emplist= new EmpListPage();
			emplist.search(empiid);
	Assert.assertEquals(emplist.fname(), "abcd","NO match");
	Assert.assertEquals(emplist.lname(), "zero11");
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException{
		testutil.logout();
		driver.quit();
	}
}
