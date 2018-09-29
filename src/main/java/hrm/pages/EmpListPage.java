package hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrm.base.TestBase;

public class EmpListPage extends TestBase{
	@FindBy(id="empsearch_id")
	WebElement idtextbx;
	@FindBy(id="searchBtn")
	WebElement searchbtn;
	
	@FindBy(xpath="//*[@id='resultTable']/tbody/tr/td[3]")
	WebElement firstname;
	@FindBy(xpath="//*[@id='resultTable']/tbody/tr/td[4]")
	WebElement lastname;
	
	public EmpListPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void search(String str){
		idtextbx.clear();
		idtextbx.sendKeys(str);
		searchbtn.click();
	}

	public String fname(){
		String fname=firstname.getText();
		return fname;
	}
	
	public String lname(){
		String lname=lastname.getText();
		return lname;
	}
}
