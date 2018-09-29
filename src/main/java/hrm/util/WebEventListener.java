package hrm.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import hrm.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigate to : '" +url +"'");		
	}
	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After Navigae to : '" + url +"'");		
	}
	
	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keystoSend){
	 //System.out.println("The value of" + element.toString() + "before any changes");	
	}
	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keystoSend ){
		
		//System.out.println("Element value changed to" + element.toString());	
	}
	
	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
	System.out.println("Trying to click on" + element.toString());	
	}
	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("After click" + element.toString());
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
		
	}
	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating to next page");
		
	}
	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated to next page");
		
	}
	@Override
	public void onException(Throwable error, WebDriver driver) {
	System.out.println("eception occured" + error);
		try{
			TestUtil.takeScreenShotTest();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to Find Element By :" + by.toString());
		
	}
	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By :" + by.toString());
		
	}
	@Override
	public void beforeScript(String script, WebDriver driver) {
		
	}
	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub		
	}


	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}	

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	
}
