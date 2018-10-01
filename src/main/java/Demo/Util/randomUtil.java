package Demo.Util;

import java.math.BigDecimal;
import java.util.Random;

public class randomUtil {
	
	/**
	 * 生成指定最小值min与最大值max范围内的整数随机数，不包括指定最大值max本身
	 * 
	 * @param min
	 *            生成随机数的最小值范围
	 * @param max
	 *            生成随机数的最大值范围
	 * @return int 生成的整数随机数
	 */
	public static int getRandomNumber(int min, int max) {
		Random random = new Random();
		int number = random.nextInt(max) % (max - min) + min;
		return number;
	}
	/**
	 * 生成一个随机的整数:小于 9999
	 * @param intnumber
	 *        intnumber 随机整数
	 */
	public static int num(){
		 
		int intnumber =randomUtil.getRandomNumber(0, 9999);
		return intnumber;
	}

	/**
	 * 生成指定最小值min与最大值max范围内的double随机数，不包括指定最大值max本身
	 * 
	 * @param min
	 *            生成随机数的最小值范围
	 * @param max
	 *            生成随机数的最大值范围
	 * @param scale
	 *            保留小数点位数
	 * @return double 生成的double随机数
	 */
	public static double getRandomDouble(double min, double max, int scale) {
		double number = Arith.add((Arith.mul(Math.random(), Arith.sub(max, min))), min);
		BigDecimal bg = new BigDecimal(number);
		return bg.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	/**
	 * 随机生成一个保留小数点的数
	 * @param doublenumber
	 *       100 以内  保留一位
	 * 
	 */
	public static double dobnuber_100(){
		double doubernumber = randomUtil.getRandomDouble(0, 100, 1);
		return doubernumber;
	}

	/**
	 * 生成指定范围内的整数随机数，不包括指定范围本身
	 * 
	 * @param extent
	 *            生成随机数的范围
	 * 
	 * @return int 生成的整数随机数
	 */
	public static int getExtentRandomNumber(int extent) {
		int number = (int) (Math.random() * extent);
		return number;
	}

	/**
	* 生成指定范围内的整数随机数，不包括指定范围本身
	 * 
	 * 
	 * @return exnuber 
	 *         生成的整数随机数 
	 */
	
	public static int rndnubm(){
		int exnuber = randomUtil.getExtentRandomNumber(9999);
	    return exnuber;
	}
	
	/**
	 * 生成N个指定范围内的不重复的整数随机，不包括指定范围本身
	 * 
	 * @param extent
	 *            生成随机数的范围
	 * @param number
	 *            生成随机数的个数
	 * 
	 * @return int[] 生成的不重复的整数随机数数组
	 */
	public static int[] getExtentRandomNumbers(int extent, int number) {
		int[] rs = new int[number];
		for (int i = 0; i < number; i++) {
			int temp = getExtentRandomNumber(extent);
			boolean isHave = false;
			// 判断是否存在该随机数
			for (int j = 0; j < rs.length; j++) {
				if (rs[j] == temp) {
					isHave = true;
					break;
				}
			}
			if (isHave == true) {
				i--;
				continue;
			}
			rs[i] = temp;
		}
		return rs;
	}

	/**
	 * 生成带有数字的指定长度字符串.
	 * 
	 * @param lengthOfNumber
	 *           要创建的数字字符串的长度。
	 */
	public static String getRndNumByLen(int lengthOfNumber) {
		int i, count = 0;

		StringBuffer randomStr = new StringBuffer("");
		Random rnd = new Random();

		while (count < lengthOfNumber) {
			i = Math.abs(rnd.nextInt(9));
			if (i == 0 && count == 0) {
			} else {
				randomStr.append(String.valueOf(i));
				count++;
			}
		}
		return randomStr.toString();
	}

	/**
	 * 生成带有chars的指定长度字符串.
	 * 
	 * @param lengthOfString
	 *            要创建的字符串的长度.
	 */
	public static String getRndStrByLen(int lengthOfString) {
		int i, count = 0;
		final String chars = "1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
		String[] charArr = chars.split(",");

		StringBuffer randomStr = new StringBuffer("");
		Random rnd = new Random();

		while (count < lengthOfString) {
			i = Math.abs(rnd.nextInt(35) % charArr.length);
			randomStr.append(charArr[i]);
			count++;
		}
		return randomStr.toString();
	}
	/**
	 * 随机生成字符串  长度为10
	 * @param args
	 */
	public static String RndStr(){
		String args = randomUtil.getRndStrByLen(10);
		return args;
	}
	
	/**
	 * 生成带有chars的指定长度特殊字符串.
	 * 
	 * @param lengthOfString
	 *            要创建的字符串的长度.
	 */
	public static String getRndsupStrByLen(int lengthOfString) {
		int i, count = 0;
		final String chars = "1,2,3,4,5,6,7,A,B,C,D,E,!,@,#,$,%,^,&,*,<,>,?,',},{,";
		String[] charArr = chars.split(",");

		StringBuffer randomStr = new StringBuffer("");
		Random rnd = new Random();

		while (count < lengthOfString) {
			i = Math.abs(rnd.nextInt(35) % charArr.length);
			randomStr.append(charArr[i]);
			count++;
		}
		return randomStr.toString();
	}
	/**
	 * 生成带有chars的指定长度特殊字符串.
	 * 
	 * @param lengthOfString
	 *            要创建的字符串的长度30.
	 */
	public static String RndsupStr(){
		String supstr=randomUtil.getRndsupStrByLen(30);
		return supstr;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public static void main(String[] args) {
//		System.out.println("Random.getRandomNumber:" + random.getRandomNumber(100, 999));
//		System.out.println("Random.getExtentRandomNumber:" + random.getExtentRandomNumber(999));
//		System.out.println("Random.getExtentRandomNumbers:" + random.getExtentRandomNumbers(999, 1)[0]);
//		System.out.println("Random.getRndNumByLen:" + random.getRndNumByLen(1));
//		System.out.println("Random.getRndStrByLen:" + random.getRndStrByLen(1));
//		System.out.println("Random.getRandomDouble:" + random.getRandomDouble(100.5, 150.5, 2));
//	}
}
