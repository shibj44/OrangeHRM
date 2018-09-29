package hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrm.base.TestBase;

public class PIMPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Add Employee')]")
	WebElement addemplink;
	
	@FindBy(xpath="//*[@id='menu_pim_viewEmployeeList']")
	WebElement emplist;
	
	public PIMPage(){
		PageFactory.initElements(driver, this);
	}
   
	public AddEmpPage clickonaddemp(){
		addemplink.click();
		return new AddEmpPage();
	}
	public EmpListPage clickonemplist(){
		emplist.click();
		return new EmpListPage();
	}
}
