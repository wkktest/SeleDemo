package Demo.Base;

import Demo.Util.logUtil;

/**
 * 测试日志输出
 */

public class log  {

	public static void main(String args[]){
		logUtil logg = new logUtil();
		logg.info("1111");
		logg.debug("2222");
		logg.warn("3333");
		logg.error("4444");
	}
}