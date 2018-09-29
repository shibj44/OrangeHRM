package hrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hrm.base.TestBase;
import hrm.pages.AddEmpPage;
import hrm.pages.HomePage;
import hrm.pages.LoginPage;
import hrm.pages.PIMPage;
import hrm.pages.PersonalDetailsPage;
import hrm.util.TestUtil;

public class AddEmpTest extends TestBase{
	
	public static String emp;
	LoginPage loginpg;
	HomePage homepg;
	PIMPage pimpg;
	AddEmpPage addemppg;
	PersonalDetailsPage personalpg;
	TestUtil testutil;
	String sheetname= "emplist";
	
	public AddEmpTest(){
		super();//first super constructor is called , goes to testbase constroucter
		        //first, before initialization.
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
	    loginpg = new LoginPage();//pre-req to check homepag	
	    homepg= new HomePage();
	    pimpg= new PIMPage();
	    homepg= loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
	    pimpg = homepg.clickonPIMLink();
	    pimpg.clickonaddemp();
	    addemppg = new AddEmpPage();
	    testutil=new TestUtil();
	    //pimpg =new PIMPage();
	}
 
//	@Test
//	public void addEmpvalueTest(){
//		
//		 emp = addemppg.validatempid();
//		 System.out.println("Employee ID is "+ emp);
//		personalpg = addemppg.addemp("abcd", "zer1");	
//		
//	}
	
	@DataProvider
	public Object[][] gettestdata(){
		Object[][] data = TestUtil.testdata(sheetname);
		return data;
	}
	
	
	@Test(dataProvider="gettestdata")
	public void addMultiplevaluesTest(String fname, String lname){
		personalpg = addemppg.addemp(fname,lname);
		
	}

	@AfterMethod
	public void teardown() throws InterruptedException{
		testutil.logout();
		driver.quit();
	}
	
}
