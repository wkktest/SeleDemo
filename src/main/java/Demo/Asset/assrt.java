package Demo.Asset;

import Demo.Base.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class assrt extends base {
	/**
	 * 判断页面元素是否存在
	 */
	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 
	 * 自定义显示等待:判断直到某个元素出现
	 * 
	 *  id
	 *            :id定位元素
	 * @param time
	 *            ：直到多少时间
	 * @param ele
	 *            ：元素
	 * @return
	 */
	public static boolean wait_untel_b(int time, final String ele) {
		boolean flag = true;
		WebDriverWait wait;
		wait = new WebDriverWait(driver, time);
		try {
			WebElement wl = wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.id(ele));
				}
			});
		
			flag = true;

		} catch (Exception e) {
			flag = false;
			Assert.fail("not  find :"+ele);
			
		}
		return flag;
	}

	// 显示等待页面元素出现的封装方法，参数为页面元素的By对象
    public static WebElement waitWebElement(WebDriver driver, final By by, int second) {
        WebElement waitElement = null;
        WebDriverWait wait = new WebDriverWait(driver, second);
        try {
            // 创建一个新的ExpectedCondition接口，实现apply方法
            waitElement = wait.until(new ExpectedCondition<WebElement>(){
                public WebElement apply(WebDriver d) {
                    return d.findElement(by);
                }
            });
        } catch (Exception e) {
        	Assert.fail("not find :"+by);
            System.out.println(by.toString() + " is not exist until " + second);
        }
        return waitElement;
    }
}


