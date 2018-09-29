package hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hrm.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//Page Factory or Object Repository
	@FindBy(name="txtUsername")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id='divLogo']/img")
	WebElement loginLogo;
	
	//Initialize all the webelements/page objects here.
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateHRMImage(){
		return loginLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
