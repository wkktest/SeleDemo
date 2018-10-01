package Demo.Util;

import Demo.Base.base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



public class ScrennFailtureListener extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println("执行onTestFailure");

		base aa = (base) tr.getInstance();
		WebDriver driver = aa.getDriver();
		ScreenShot.takeScreenshot(driver, "testimage");
		super.onTestFailure(tr);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		
//		System.out.println("test is  successs");
//		super.onTestSuccess(tr);

	}

	// @Override
	// public void onTestFailure(ITestResult tr) {
	// m_allTestMethods.add(tr.getMethod());
	// m_failedTests.add(tr);
	// }

	@Override
	public void onTestSkipped(ITestResult tr) {

		super.onTestSkipped(tr);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {

	}

	@Override
	public void onStart(ITestContext testContext) {

		System.out.println("tets is  start:");
		super.onStart(testContext);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		
		System.out.println("test is finish:");
		super.onFinish(testContext);
		
	}
}
