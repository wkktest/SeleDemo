package test139email.loginpagetest;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import test139email.base.base;
import test139email.logpage.logpagebus;

//@Listeners({ScrennFailtureListener.class,ReportUtil.class})
public class logintest extends base {
	// public static WebDriver driver;
	static String username = "1500039";
	static String password = "awe";
	static String url = "https://mail.10086.cn/";
	static String path = System.getProperty("user.dir");
	static String driverpath = path + "\\drivers\\chromedriver.exe" ;

	@BeforeClass(description = "测试类的初始化")
	public static void setup() throws MalformedURLException {
		// 关闭后台浏览器
		// AcUtil.killProcess();
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		// getdriver.getchromefoxdriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass(description = "测试类结束")
	public static void down() {
		driver.quit();
	}

	// 成功验证
	@Test(description = "成功的登录验证", groups = "登录页面")
	public static void login139_sucess() throws InterruptedException {
		logpagebus.login_test(username, password);

	}

//	 数据驱动验证
//	@Test(dataProvider = "sss", description = "数据驱动验证：登录数据", groups = "登录页面")
//	public static void lgoin139_eles(String username, String password) throws InterruptedException {
//		logpagebus.login_test(username, password);
//		Thread.sleep(5000);
//	}
//
//	@DataProvider(name = "sss")
//	public static Object[][] words() throws IOException {
//		return importreadfileUtil.readCsvFile(path + "\\用户登录.csv", 1);
//	}
}