package Demo.Util;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

public class ScreenShot {

	static String path = System.getProperty("user.dir");


	/**
	 * 全屏截图：
	 * @param driver  
	 * @param imgName  图片名称
	 */
	public static void takeScreenshot(WebDriver driver, String imgName) {
		String screenName = imgName + DateTimeUtil.getCurrentDateTime() + ".jpg";

		String fileString = path + "\\report\\screenfile\\test";
		if (!(new File(fileString).isDirectory())) { // 判断是否存在该目录
			new File(fileString).mkdir(); // 如果不存在则新建一个目录
		}
		File dir = new File(fileString);
		if (!dir.exists())
			dir.mkdirs();

		String screenPath = dir.getAbsolutePath() + "\\" + screenName;
		Screeshot(screenPath, driver);
	}
	/**
	 * 全屏截图
	 * @param screenPath  截图位置
	 * @param driver
	 */
	public static void Screeshot(String screenPath, WebDriver driver) {
		try {
			// 指定了OutputType.FILE做为参数传递给getScreenshotAs()方法，其含义是将截取的屏幕以文件形式返回。
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
			// 利用FileUtils工具类的copyFile()方法保存getScreenshotAs()返回的文件对象。
			FileUtils.copyFile(scrFile, new File(screenPath)); 
		} catch (IOException e) {
			System.out.println("Screen shot error: " + screenPath);
			System.out.println("该错误可以查看截图：" + screenPath);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	
	
	 
    
  /**
   * 根据元素截图
   * @param ele  元素
   * @param filepath  截图位置
   */
    public static void CaptureElement(WebElement ele,String filepath){          
        try {  
            FileUtils.copyFile(captureElement(ele), new File(filepath));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
     
    }
    //页面元素截图  
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
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width,rect.height);  
        //存为png格式  
        ImageIO.write(dest, "png", screen);  
        return screen;  
    } 

}
