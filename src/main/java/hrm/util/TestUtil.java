package hrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;



import hrm.base.TestBase;


public class TestUtil extends TestBase{
	
	public static long page_load_timeout=20;
	public static long implicit_wait=10;
	
	public static String sheetpath = "E:\\Selenium_Training\\OrangeHRMApplication\\src\\main\\java\\hrm\\testdata\\HRMEmp.xlsx";
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	
			
	
	public void logout() throws InterruptedException{
		WebElement welcomename = driver.findElement(By.xpath("//*[@id='welcome']"));
		welcomename.click();
		Thread.sleep(1000);
		WebElement logout1 = driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]"));
		logout1.click();
	}
	
	public static Object[][] testdata(String sheetname){
		FileInputStream fl=null;
		try {
			 fl= new FileInputStream(sheetpath);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		try {
			book= new XSSFWorkbook(fl);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++){
			for (int j=0; j<sheet.getRow(i).getLastCellNum(); j++){
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}
	
	public static void takeScreenShotTest() throws IOException{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user.dir");
	FileUtils.copyFile(srcfile, new File(currentdir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
				
		
	}
}
