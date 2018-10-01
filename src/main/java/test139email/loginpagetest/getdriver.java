package test139email.loginpagetest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class getdriver {
	public static WebDriver driver;
	
    public static WebDriver getiedriver() throws MalformedURLException{
    	DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
    	capability.setBrowserName("internetExplorer");
    	capability.setPlatform(Platform.WIN10);
    	driver = new RemoteWebDriver(capability);
    	return driver;
    }
    public static WebDriver getfirefoxdriver() throws MalformedURLException{
    	DesiredCapabilities capability = DesiredCapabilities.firefox();
    	capability.setBrowserName("firefox");
    	capability.setPlatform(Platform.WIN10);
    	driver = new RemoteWebDriver(capability);
    	return driver;
    }
    public static WebDriver getchromefoxdriver() throws MalformedURLException{
    	DesiredCapabilities capability = DesiredCapabilities.chrome();
    	capability.setBrowserName("chrome");
    	capability.setPlatform(Platform.WIN10);
    	driver = new RemoteWebDriver(capability);
    	return driver;
    }
}
