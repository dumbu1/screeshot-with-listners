package module;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class CommonMethods {
	
	public void getScreenshot(WebDriver wd, String testName) {
		
		//taking screenshot
				//add commons-io dependency
		TakesScreenshot obj_TakesScreenshot=(TakesScreenshot)wd;
		File sourceFile=obj_TakesScreenshot.getScreenshotAs(OutputType.FILE);
		
		
		File destinationFile=new File(System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+testName+".png");
		
		
		try {
			FileUtils.copyFile(sourceFile,destinationFile);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
