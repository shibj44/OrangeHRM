package hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrm.base.TestBase;

public class PersonalDetailsPage extends TestBase{
	@FindBy(xpath="//*[@id='sidenav']/li[6]")
	WebElement job;

	public PersonalDetailsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public JobPage clickonjob(){
		 job.click();
		 return new JobPage();
	}
	

}

