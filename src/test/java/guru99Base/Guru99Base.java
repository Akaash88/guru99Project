package guru99Base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import guru99Util.ExcelUtil;
import guru99Util.ExtentManager;


public class Guru99Base {

	WebDriver driver;
	public String expectedTitle = "Guru99 Bank Manager HomePage";
	public String EXPECT_ERROR = "User or Password is not valid";
	By UserName = By.name("uid");
	By password = By.name("password");
	By Login = By.name("btnLogin");
	By managerID = By.xpath("//td[contains(text(),'Manger Id : mngr241471')]");
	
public	Guru99Base(WebDriver driver){
		 this.driver = driver;
}
	public static ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest eTest;
	
	public void log_in(String userid,String pass)
	{

	driver.findElement(UserName).sendKeys(userid);
	driver.findElement(password).sendKeys(pass);
	driver.findElement(Login).click();
	
}
	public  Object[][] testData(String excelPath, String sheetName) {
		ExcelUtil excel = new ExcelUtil(excelPath, sheetName);
		int rowcount = excel.getRowCount(); 
		int colcount = excel.getColCount();

		Object data[][] = new Object[rowcount-1][colcount]; 

		for(int i =1;i<rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				String cellData = excel.getData(i, j);
				data[i-1][j] = cellData;  
			}

		}
		return data;
	}
	
	public  void captureScreenShot(WebDriver driver, String ScreenShotName) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("./ScreenShot/"+ScreenShotName+".png"));
			System.out.println("ScreenShot taken");
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	
}
}

