package hrm.pages;

import hrm.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

public class HomePage extends TestBase{
	
	@FindBy(id="welcome")
	WebElement usernamelabel;
	@FindBy(xpath="//*[@id='menu_pim_viewPimModule']/b")
	WebElement pimlink;
	@FindBy(xpath="//*[@id='menu_admin_viewAdminModule']/b")
	WebElement adminlink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyHomepageTitle(){
		 return driver.getTitle();
	}

	public boolean verifyHomepageUserLabel(){
		return usernamelabel.isDisplayed();		
	}
	public PIMPage clickonPIMLink(){
		pimlink.click();
		return new PIMPage();
	}
	public AdminPage clickonAdminLink(){
		adminlink.click();
		return new AdminPage();
	}
}
