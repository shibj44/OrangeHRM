package hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hrm.base.TestBase;

public class JobPage extends TestBase{
	
	@FindBy(id="btnSave")
	WebElement savebtn;
	
	@FindBy(name="job[job_title]")
	WebElement jobtitle;
	
	@FindBy(xpath="//*[@id='job_job_title']/option[3]")
	WebElement selectoption;
	@FindBy(xpath="//*[@id='menu_pim_viewEmployeeList']")
	WebElement emplist;
	
	public JobPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickonsavebutton(){
		savebtn.click();
	}
	public void selectoption(String opt){
		savebtn.click();
		Select sel = new Select(jobtitle);
		//jobtitle.click();	
		sel.selectByVisibleText(opt);				
	}
	public EmpListPage clickonemplist(){
		emplist.click();
	return new EmpListPage();
	}
}
