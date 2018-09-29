package hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrm.base.TestBase;

public class AddEmpPage extends TestBase{
	
	@FindBy(id ="firstName")
	WebElement firstname;
	@FindBy(id="lastName")
	WebElement lastname;
	@FindBy(id="btnSave")
	WebElement savebtn;
	
	//@FindBy(xpath="//*[@id='employeeId']")
	@FindBy(name="employeeId")
	WebElement empid;
	
	public AddEmpPage(){
		PageFactory.initElements(driver, this);
	}
	
	public PersonalDetailsPage addemp(String fn, String ln){
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		savebtn.click();
		return new PersonalDetailsPage();
	}
	public String validatempid(){
		
		String ei = empid.getAttribute("value");
		//int ei= Integer.parseUnsignedInt(ei);
		return ei;
	}
}
