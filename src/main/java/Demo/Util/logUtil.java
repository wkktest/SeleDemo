package Demo.Util;

import org.apache.log4j.Logger;
import org.testng.Reporter;

public class logUtil {

	private Logger logger;

	public logUtil(Class<?> clazz) {
		logger = Logger.getLogger(clazz);
	}

	public logUtil(String s) {
		logger = Logger.getLogger(s);
	}

	public logUtil() {
		logger = Logger.getLogger("");
	}

	public void info(Object message) {
		logger.info(message);
		this.testngLogOutput(message);
	}

	public void error(Object message) {
		logger.error(message);
		this.testngLogOutput(message);
	}

	public void warn(Object message) {
		logger.warn(message);
		this.testngLogOutput(message);
	}

	public void debug(Object message) {
		logger.debug(message);
		this.testngLogOutput(message);
	}

	private void testngLogOutput(Object message) {
		Reporter.log(message.toString());
	}

}
