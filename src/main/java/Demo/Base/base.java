package Demo.Base;

import org.openqa.selenium.WebDriver;

public class base {

	public static WebDriver driver;

	public WebDriver getDriver() {
		
		return driver;
	}

	public static void getInstance(WebDriver superdriver) {
		if (driver == null) {
			driver = superdriver;
		}
	}
}
