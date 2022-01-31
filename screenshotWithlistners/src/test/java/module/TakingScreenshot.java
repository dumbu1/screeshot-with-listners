package module;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakingScreenshot {
	static WebDriver wd;
	@Test
	public void takingScreenShot() {
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.get("http://the-internet.herokuapp.com/");
		
		
		Assert.assertEquals(wd.getTitle(),"mohan");
		
		//CommonMethods obj_CommonMethods=new CommonMethods();
		
		//obj_CommonMethods.getScreenshot(wd, "takingScreenShot");
		
		
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) {
		System.out.println(result.getStatus());
		
		if(result.FAILURE==result.getStatus()) {
			
			CommonMethods obj_CommonMethods=new CommonMethods();
			
			obj_CommonMethods.getScreenshot(wd, result.getName());
		}
		wd.close();
	}

}
