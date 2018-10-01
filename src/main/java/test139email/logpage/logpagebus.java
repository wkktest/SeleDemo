package test139email.logpage;

import java.io.IOException;


import Demo.Asset.assrt;
import Demo.Util.AcUtil;
import Demo.Util.ScreenShot;
import org.openqa.selenium.By;
import org.testng.Assert;


import test139email.Action.Ac;
import test139email.base.base;

public class logpagebus extends base {
	/**
	 * 成功登陆操作
	 */
//	public static void login_sucess(String username, String password) {
//		logUtil logg = new logUtil();
//		// 输入用户名
//		if (assrt.isElementPresent(By.id(logpageele.user_id))) {
//			Ac.input_id((logpageele.user_id), username);
//			logg.info("输入用户名：" + username);
//		} else {
//			logg.debug("未找到页面元素-用户名: logpageele-user_id" + logpageele.user_id);
//			Assert.fail("元素没有找到:" + logpageele.user_id);
//		}
//		// 输入密码
//		if (assrt.isElementPresent(By.id(logpageele.user_id))) {
//			Ac.input_id((logpageele.pwd_id), password);
//			logg.info("输入密码：" + password);
//		} else {
//			logg.debug("未找到页面元素-用户名: logpageele-pwd_id" + logpageele.pwd_id);
//			Assert.fail("元素没有找到:" + logpageele.pwd_id);
//		}
//
//		// 选择是否保存密码信息
//		// Ac.click_id(logpageele.cbauto_id);
//		if (assrt.isElementPresent(By.id(logpageele.cbauto_id))) {
//			Ac.click_id(logpageele.cbauto_id);
//
//		} else {
//			logg.debug("未找到元素：" + logpageele.cbauto_id);
//			Assert.fail("not find element:" + logpageele.cbauto_id);
//		}
//
//		// 点击登录按钮
//		if (assrt.is_wait_until(5, logpageele.button_id) == true) {
//			Ac.click_id(logpageele.button_id);
//			logg.info("点击登录按钮：");
//		} else {
//			logg.debug("未找到元素 登录按钮：" + logpageele.button_id);
//			Assert.fail("未找到元素 登录按钮：" + logpageele.button_id);
//
//		}
//		// 验证登录成功：首页
////		assrt.isElementPresent(By.xpath(logpageele.personxpath));
//		logpagebus.yanzheng();
//		logg.info("登录成功：页面显示：首页的 xpath：" + logpageele.cbauto_id);
//
//	}
	

	/**
	 * 失败登登录操作：验证用户名，密码错误
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 */
	public static void login_test(String username, String password) {
		
		// 输入用户名
		if (assrt.isElementPresent(By.id(logpageele.user_id))) {
//		if(assrt.iselement(logpageele.user_id)){
			Ac.input_id((logpageele.user_id), username);
			log.info("输入用户名：" + username);
		} else {
			Assert.fail("元素没有找到:" + logpageele.user_id);
			log.error("未找到页面元素-用户名: logpageele-user_id" + logpageele.user_id);
			
			try {
				AcUtil.scropath();
				System.out.println("查看失败截图：");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.info("截图失败：");
			}
		}
		// 输入密码
		if (assrt.isElementPresent(By.id(logpageele.user_id))) {
//		if(assrt.iselement(logpageele.pwd_id)){
			Ac.input_id((logpageele.pwd_id), password);
			log.info("输入密码：" + password);
		} else {
			log.debug("未找到页面元素-用户名: logpageele-pwd_id" + logpageele.pwd_id);
			Assert.fail("元素没有找到:" + logpageele.pwd_id);
			try {
				AcUtil.scropath();
				log.info("查看失败截图：");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.info("截图失败：");
			}
		}
		// 选择是否保存密码信息
		// Ac.click_id(logpageele.cbauto_id);

		// 点击登录按钮
		if (assrt.wait_untel_b(5, logpageele.button_id)) {
//		if(assrt.iselement(logpageele.button_id)){
			Ac.click_id(logpageele.button_id);
			log.info("点击登录按钮：");
		} else {
			log.debug("未找到元素 登录按钮：" + logpageele.button_id);
			Assert.fail("未找到元素 登录按钮：" + logpageele.button_id);
			try {
				AcUtil.scropath();
				System.out.println("查看失败截图：");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("截图失败：");
			}
		}
		// 验证密码错误是否出现提示：
//		Ac.wait_id(logpageele.wait_id);
		logpagebus.yanzheng();
		
	}

	
	
	
	
	
	public static void yanzheng() {
		if (assrt.isElementPresent(By.id(logpageele.relogin_id))) {
//		if(assrt.iselement(logpageele.relogin_id)){
			log.info("存在注册按钮，证明所在登录界面：验证登录失败：");
			Ac.wait_id(logpageele.wait_id);
			ScreenShot.takeScreenshot(driver, "testlogin");
		} else {
			log.debug("未找到注册按钮：验证是否进入成功" );
			assrt.isElementPresent(By.xpath(logpageele.personxpath));
			
		}
	}

	/**
	 * 进入注册界面业务
	 */
	/**
	 * 进入注册界面
	 */
	public static void click_butreg() {
		// logUtil log = new logUtil();
		// if(asert.isElementPresent(By.id(logpageele.relogin_id))){
		// Ac.click_id(logpageele.relogin_id);
		// log.info("点击注册按钮：");
		// }else {
		// log.debug("未找到注册按钮："+logpageele.relogin_id);
		// Assert.fail("未找到注册按钮："+logpageele.relogin_id);
		// }
	}

	
	
	
	
	
	
	
	
	
	
	

	/**
	 * 失败登登录操作：验证用户名，密码错误
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 */
	public static void login_test1(String username, String password) {
		
		// 输入用户名
//		if (assrt.isElementPresent(By.id(logpageele.user_id))) {
//		if(assrt.iselement(logpageele.user_id)){
			Ac.input_id((logpageele.user_id), username);
//			log.info("输入用户名：" + username);
//		} else {
//			Assert.fail("元素没有找到:" + logpageele.user_id);
//			log.error("未找到页面元素-用户名: logpageele-user_id" + logpageele.user_id);
//			
//			try {
//				AcUtil.scropath();
//				System.out.println("查看失败截图：");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
////				log.info("截图失败：");
//			}
//		}
		// 输入密码
//		if (assrt.isElementPresent(By.id(logpageele.user_id))) {
//		if(assrt.iselement(logpageele.pwd_id)){
			Ac.input_id((logpageele.pwd_id), password);
//			log.info("输入密码：" + password);
//		} else {
//			log.debug("未找到页面元素-用户名: logpageele-pwd_id" + logpageele.pwd_id);
//			Assert.fail("元素没有找到:" + logpageele.pwd_id);
//			try {
//				AcUtil.scropath();
//				log.info("查看失败截图：");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				log.info("截图失败：");
//			}
//		}
		// 选择是否保存密码信息
		// Ac.click_id(logpageele.cbauto_id);

		// 点击登录按钮
//		if (assrt.is_wait_until(5, logpageele.button_id)) {
//		if(assrt.iselement(logpageele.button_id)){
			Ac.click_id(logpageele.button_id);
//			log.info("点击登录按钮：");
//		} else {
//			log.debug("未找到元素 登录按钮：" + logpageele.button_id);
//			Assert.fail("未找到元素 登录按钮：" + logpageele.button_id);
//			try {
//				AcUtil.scropath();
//				System.out.println("查看失败截图：");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("截图失败：");
//			}
//		}
		// 验证密码错误是否出现提示：
//		Ac.wait_id(logpageele.wait_id);
//		logpagebus.yanzheng();
}
}