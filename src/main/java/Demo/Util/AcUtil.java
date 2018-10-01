package Demo.Util;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import Demo.Base.base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class AcUtil extends base {

	/**
	 * 清空数据操作
	 * 
	 * @param id
	 *            元素
	 */
	public static void clear_id(String id) {
		driver.findElement(By.id(id)).clear();
	}

	/**
	 * 清空数据操作
	 * 
	 * @param name
	 */
	public static void clear_name(String name) {
		driver.findElement(By.name(name)).clear();
	}

	/**
	 * 清空数据操作
	 * 
	 * @param xpath
	 */
	public static void clear_xpath(String xpath) {
		driver.findElement(By.xpath(xpath)).clear();
	}

	/**
	 * 点击操作
	 * 
	 * @param id
	 *            元素
	 */
	public static void click_id(String id) {
		driver.findElement(By.id(id)).click();
	}

	/**
	 * 点击元素
	 * 
	 * @param name
	 */
	public static void click_name(String name) {
		driver.findElement(By.name(name)).click();
	}

	/**
	 * 点击操作
	 * 
	 * @param xpath
	 */
	public static void click_xpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	/**
	 * 超链接 href
	 */
	public static void click_linktext(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}

	/**
	 * 输入数据 id
	 * 
	 * @param id
	 *            元素
	 * @param value
	 *            输入数据
	 */
	public static void input_id(String id, String value) {
		driver.findElement(By.id(id)).clear();
		driver.findElement(By.id(id)).sendKeys(value);
	}

	/**
	 * 输入数据
	 * 
	 * @param name
	 *            元素
	 * @param value
	 *            输入数据
	 */
	public static void input_name(String name, String value) {
		driver.findElement(By.name(name)).clear();
		driver.findElement(By.name(name)).sendKeys(value);
	}

	/**
	 * 输入数据
	 * 
	 * @param xpath
	 *            元素
	 * @param value
	 *            输入数据
	 */
	public static void input_xpath(String xpath, String value) {
		driver.findElement(By.name(xpath)).clear();
		driver.findElement(By.name(xpath)).sendKeys(value);
	}

	/**
	 * 显示等待
	 * 
	 * @cssSelector
	 * @param cssSelector
	 *            元素
	 * 
	 */
	public static void wait_css(String cssSelector) {
		WebDriverWait wait = null;
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
	}

	/**
	 * 显示等待
	 * 
	 * @cssSelector
	 * @param id
	 *            元素
	 * 
	 */
	public static void wait_id(String id) {
		WebDriverWait wait;
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	}

	/**
	 * 显示等待
	 * 
	 * @cssSelector
	 * @param name
	 *            元素
	 * 
	 */
	public static void wait_name(String name) {
		WebDriverWait wait = null;
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
	}

	/**
	 * 显示等待
	 * 
	 * @xpath
	 * @param xpath
	 *            元素
	 * 
	 */
	public static void wait_xpath(String xpath) {
		WebDriverWait wait = null;
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}

	/**
	 * 自定义显示等待:直到某个元素出现
	 * 
	 * @param time
	 *            等待时间
	 * @param ele
	 *            id定位 等待元素
	 */

	public static void wait_until(int time, final String ele) {
		// logUtil log = new logUtil();
		WebDriverWait wait;
		wait = new WebDriverWait(driver, time);
		try {
			WebElement ss = wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.id(ele));
				}
			});
			// log.info("找到元素：" + ele);
		} catch (Exception e) {
			// log.debug("未找到元素" + ele);
			Assert.fail("当前未找到元素：" + ele);
		}
	}

	public static boolean iswait_until(int time, final String ele) {
		// logUtil log = new logUtil();
		WebDriverWait wait;
		wait = new WebDriverWait(driver, time);
		try {
			WebElement w = wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.id(ele));
				}
			});
			// log.info("找到元素：" + ele);
		} catch (Exception e) {
			// log.debug("未找到元素" + ele);
			Assert.fail("当前未找到元素：" + ele);
		}
		return false;
	}

	/**
	 * boolean 类型的定位
	 * 
	 */
	/**
	 * id boolean
	 */
	public static boolean click_i(String id) {
		driver.findElement(By.id(id));
		return false;
	}

	/**
	 * name boolean
	 */
	public static boolean click_n(String name) {
		driver.findElement(By.name(name));
		return false;
	}

	/**
	 * xpath boolean
	 */
	public static boolean click_x(String xpath) {
		driver.findElement(By.xpath(xpath));
		return false;
	}

	/**
	 * 返回属性类型的 返回值
	 * 
	 */

	/**
	 * 输出以id定位的 value属性的返回值Attribute
	 * 
	 * @param id
	 *            定位元素
	 * @param value
	 *            属性类型
	 */
	public static String return_s_i(String id, String value) {
		return driver.findElement(By.id(id)).getAttribute(value);
	}

	/**
	 * 输出以name定位的 value属性的返回值 Attribute
	 * 
	 * @param name
	 *            定位元素
	 * @param value
	 *            属性类型
	 */
	public static String return_s_n(String name, String value) {
		return driver.findElement(By.name(name)).getAttribute(value);
	}

	/**
	 * 输出以xpath定位的 Attribute的value属性的返回值
	 * 
	 * @param xpath
	 *            定位元素
	 * @param value
	 *            Attribute：返回属性类型
	 */
	public static String return_s_x(String xpath, String value) {
		return driver.findElement(By.xpath(xpath)).getAttribute(value);
	}

	/**
	 * 返回string类型的 文本值
	 * 
	 * @param id
	 */
	public static String return_text_id(String id) {
		return driver.findElement(By.id(id)).getText();
	}

	/**
	 * 返回string类型的 文本值
	 * 
	 * @param name
	 */
	public static String return_text_name(String name) {
		return driver.findElement(By.name(name)).getText();
	}

	/**
	 * 返回string类型的 文本值
	 * 
	 * @param xpath
	 */
	public static String return_text_xpath(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}

	/**
	 * 返回webElement 元素
	 * 
	 * @param id
	 * @return
	 */
	public static WebElement return_e_id(String id) {
		return driver.findElement(By.id(id));
	}

	/**
	 * 返回webElement 元素
	 * 
	 * @param name
	 * @return
	 */
	public static WebElement return_e_name(String name) {
		return driver.findElement(By.name(name));
	}

	/**
	 * 返回webElement 元素
	 * 
	 * @param xpath
	 * @return
	 */
	public static WebElement return_e_xpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * 鼠标模拟操作
	 */
	/**
	 * 鼠标点击
	 * 
	 * @param id
	 */
	public static void mouseclick() {
		Actions a = new Actions(driver);
		a.click();
	}

	public static void mouseclick_i(String id) {
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.id(id)));
	}

	/**
	 * 鼠标点击
	 * 
	 * @param name
	 */
	public static void mouseclick_n(String name) {
		Actions a = new Actions(driver);
		a.click(driver.findElement(By.name(name)));
	}

	/**
	 * 鼠标点击
	 * 
	 * @param path
	 */
	public static void mouseclick_x(String path) {
		Actions a = new Actions(driver);
		a.click(driver.findElement(By.xpath(path)));
	}

	/**
	 * 鼠标双击
	 * 
	 * @param id
	 */
	public static void mousedoble() {
		Actions a = new Actions(driver);
		a.doubleClick();
	}

	public static void mousedouble_i(String id) {
		Actions a = new Actions(driver);
		a.doubleClick(driver.findElement(By.id(id)));
	}

	/**
	 * | 鼠标双击
	 * 
	 * @param name
	 */
	public static void mousedouble_n(String name) {
		Actions a = new Actions(driver);
		a.doubleClick(driver.findElement(By.name(name)));
	}

	/**
	 * 鼠标双击
	 * 
	 * @param xpath
	 */
	public static void mousedouble_x(String xpath) {
		Actions a = new Actions(driver);
		a.doubleClick(driver.findElement(By.xpath(xpath)));
	}

	/**
	 * 鼠标释放
	 */
	public static void mousere() {
		Actions a = new Actions(driver);
		a.release();
	}

	public static void mousere_i(String id) {
		Actions a = new Actions(driver);
		a.release(driver.findElement(By.id(id)));
	}

	public static void mousere_n(String name) {
		Actions a = new Actions(driver);
		a.release(driver.findElement(By.name(name)));
	}

	public static void mousere_x(String xpath) {
		Actions a = new Actions(driver);
		a.release(driver.findElement(By.xpath(xpath)));
	}

	public static void clickkey(String key) {
		Actions a = new Actions(driver);
		a.keyDown(key);
		a.keyUp(key);
	}

	/**
	 * 键盘模拟 点击F5 按钮 在释放按钮
	 */
	public static void click_F5() {
		Actions a = new Actions(driver);
		a.keyDown(Keys.F5);
		a.keyUp(Keys.F5);
	}

	/**
	 * 键盘模拟 点击enter 按钮 在释放按钮
	 */
	public static void click_enter() {
		Actions a = new Actions(driver);
		a.keyDown(Keys.ENTER);
		a.keyUp(Keys.ENTER);
	}

	/**
	 * 键盘模拟 点击esc 按钮 在释放按钮
	 */
	public static void click_esc() {
		Actions a = new Actions(driver);
		a.keyDown(Keys.ESCAPE);
		a.keyUp(Keys.ESCAPE);
	}

	/**
	 * 键盘模拟 点击tab 按钮 在释放按钮
	 */
	public static void click_tab() {
		Actions a = new Actions(driver);
		a.keyDown(Keys.TAB);
		a.keyUp(Keys.TAB);
	}

	/**
	 * 键盘模拟 点击backspace 按钮 在释放按钮
	 */
	public static void click_backspace() {
		Actions a = new Actions(driver);
		a.keyDown(Keys.BACK_SPACE);
		a.keyUp(Keys.BACK_SPACE);
	}

	public static void keydown(String bb) {
		Actions a = new Actions(driver);
		a.keyDown(bb);
	}

	public static void keyup(String up) {
		Actions a = new Actions(driver);
		a.keyUp(up);

	}

	/**
	 * 模拟键盘在ele输入框中输入关键字value
	 * 
	 * @param ele
	 * @param value
	 */
	public static void sendkeys(String ele, String value) {
		Actions a = new Actions(driver);
		a.sendKeys(ele, value).perform();

	}

	/**
	 * JS事件，操作页面滚动条
	 */
	/**
	 * 向下拉到底
	 */
	public static void godowm() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollTo(0,10000)");

	}

	/**
	 * 向上拉到顶
	 */
	public static void gotop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollTo(0,1)");
	}

	/**
	 * 拉到中间
	 */
	public static void gomid_height() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 0-document.body.scrollHeight *1/2)");
	}

	/**
	 * 左右拉到中间
	 */
	public static void gomid_widht() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 0-document.body.scrollWidht *1/2)");
	}

	/**
	 * 移动到与ele元素的顶端，与当前窗口的顶端对齐
	 * 
	 * @param ele
	 */
	public static void gotop(String ele) {
		JavascriptExecutor s = (JavascriptExecutor) driver;
		s.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	/**
	 * 移动到与ele元素的底部，与当前窗口的底部对齐
	 * 
	 * @param ele
	 */
	public static void godown(String ele) {
		JavascriptExecutor s = (JavascriptExecutor) driver;
		s.executeScript("arguments[0].scrollIntoView(false);", ele);
	}

	/**
	 * 移动到页面最底部
	 */
	public static void godownjs() {
		JavascriptExecutor s = (JavascriptExecutor) driver;
		s.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * 移动到指定坐标
	 */
	public static void move(int a, int b) {
		JavascriptExecutor s = (JavascriptExecutor) driver;
		s.executeScript("window.scrollBy('" + a + "', '" + b + "')");
	}

	/**
	 * 切换windows窗口
	 * 
	 * @param x
	 *            0是初始窗口，1是新窗口
	 * @throws InterruptedException 
	 */
	
	public static void switchWindows() throws InterruptedException {
		
		Set<String> handles = driver.getWindowHandles();
		
		List<String> list = new ArrayList<String>(handles);
	
//		driver.switchTo().window(list.get(x));
		// driver.close();//关闭新窗口
		
		
//		Set<String> handles = driver.getWindowHandles();
//		List<String> list = new ArrayList<String>(handles);
//		Thread.sleep(2000);
//		driver.switchTo().window(list.get(1));
//		System.out.println(driver.getCurrentUrl());
//		Thread.sleep(2000);
//		driver.switchTo().window(list.get(0));
//		System.out.println(driver.getCurrentUrl());
//		Thread.sleep(2000);

	
	}

	// public static void main(String[] args) {
	//
	// ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 700)");
	// }
	/**
	 * 精简后的js操作滚动条代码
	 */
	/**
	 * 向下拉到底
	 */
	// ((JavascriptExecutor)driver).executeScript("scrollTo(0,10000)");
	/**
	 * 向上拉到顶
	 */
	// ((JavascriptExecutor)driver).executeScript("scrollTo(0,1)");
	/**
	 * 将页面滚动条拖到底部
	 */
	// ((JavascriptExecutor)driver).executeScript("document.documentElement.scrollTop=10000");
	/**
	 * 将页面滚动条拖到顶部
	 */
	// ((JavascriptExecutor)driver).executeScript("document.documentElement.scrollTop=0");

	/**
	 * 中文封装：
	 * 
	 * @throws InterruptedException
	 */
	public static void 暂停5秒() throws InterruptedException {
		Thread.sleep(5000);
	}

	/**
	 * 截图：保存特定目录；
	 * 
	 * @path
	 * @throws IOException
	 */

	public static void scropath() throws IOException {
		String path = "D:\\1";
		// 截图到output
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(path + "1.png"));
	}

	/**
	 * 截图：截取当前窗口的图片
	 * 
	 * @param savapath
	 *            保存路径
	 * @throws IOException
	 * 
	 */

	public static void copyscr(String screenPath) throws IOException {
		logUtil logg = new logUtil();
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(screenPath));

		} catch (IOException e) {
			System.out.println("Screen shot error: " + screenPath);
			logg.info("截图异常：查看截图路径" + screenPath);
		}

	}

	/**
	 * 根据元素进行 截图
	 * 
	 * @param element
	 *            需要截图的 元素定位
	 */
	public static File captureElement(WebElement element) throws Exception {

		WrapsDriver wrapsDriver = (WrapsDriver) element;
		// 截图整个页面
		File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
		BufferedImage img = ImageIO.read(screen);
		// 获得元素的高度和宽度
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		// 创建一个矩形使用上面的高度，和宽度
		Rectangle rect = new Rectangle(width, height);
		// 得到元素的坐标
		Point p = element.getLocation();
		BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
		// 存为png格式
		ImageIO.write(dest, "png", screen);
		return screen;
	}

	/**
	 * 杀掉进程
	 * 
	 */
	public static void killProcess() {
		// kill firefox
		WindowsUtils.killByName("firefox.exe");
		// kill IE
		WindowsUtils.killByName("iexplore.exe");
		// kill chrome
		WindowsUtils.killByName("chrome.exe");
	}

}
