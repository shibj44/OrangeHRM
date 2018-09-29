package hrm.testcases;

import hrm.base.TestBase;
import hrm.pages.AddEmpPage;
import hrm.pages.EmpListPage;
import hrm.pages.HomePage;
import hrm.pages.JobPage;
import hrm.pages.LoginPage;
import hrm.pages.PIMPage;
import hrm.pages.PersonalDetailsPage;
import hrm.util.TestUtil;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JobPageTest extends TestBase {
	
	LoginPage loginpg;
	HomePage homepg;
	PIMPage pimpg;
	AddEmpPage addemppg;
	PersonalDetailsPage personalpg;
	JobPage jobpage;
	EmpListPage emplist;
	TestUtil testutil;
	
	public JobPageTest(){
		super();//first super constructor is called , goes to testbase constroucter
		        //first, before initialization.
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
	    loginpg = new LoginPage();//pre-req to check homepag	
	    homepg= new HomePage();
	    pimpg= new PIMPage();
	    addemppg= new AddEmpPage();
	    personalpg= new PersonalDetailsPage();
	    testutil = new TestUtil();
	    homepg= loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
	    pimpg = homepg.clickonPIMLink();
	    addemppg = pimpg.clickonaddemp();
	    personalpg = addemppg.addemp("abcd", "zero11");
	    jobpage		= personalpg.clickonjob();
	}
	@Test
	public void addJobDetailsTest(){
		jobpage.selectoption("CEO");
		jobpage.clickonsavebutton();
		emplist = jobpage.clickonemplist();
		
	}

	@AfterMethod
	public void teardown() throws InterruptedException{
		testutil.logout();
		driver.quit();
	}
	
}
