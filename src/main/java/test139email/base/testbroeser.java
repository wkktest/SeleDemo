package test139email.base;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testbroeser {
	public static WebDriver driver;
	public static String baseurl="www.baidu.com";
	
	
	@BeforeClass
	public static void beforetTest(String browser) throws MalformedURLException{
		if(browser.equalsIgnoreCase("firefox")){
			driver=GetDriver.getfirefoxdriver(baseurl);
			
		}else if(browser.equalsIgnoreCase("ie")){
			driver = GetDriver.getiedriver(baseurl);
			
		}else if(browser.equalsIgnoreCase("chrome")){
			
			driver = GetDriver.getchromefoxdriver(baseurl);
			
		}else {
			System.out.println("shuru ceuoweu :");
		}
	}
	
	@Test
	public void test() {
	
		
	}
	
	@AfterClass
	public static void aftertest(){
		driver.quit();
	}

}
