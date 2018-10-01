package Demo.Util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class getipUtil {
    logUtil logutil = new logUtil(this.getClass());
    /**
     * 获取本机ip名称信息
     * 
     */
	public static void getip() {
		try {
			System.out.println("本机的IP:本机名称/ip= " + InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			e.printStackTrace();
			
		}
	}
  
	/**
	 * 获取本机ip：
	 */
	public static void getlocalip() {
		InetAddress ia = null;
		try {
			ia = ia.getLocalHost();
			String localip = ia.getHostAddress();
			System.out.println("当前主机的I-P是：" + localip);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取本机名称：
	 */
	public static void getlocalname() {
		InetAddress ia = null;
		try {
			ia = ia.getLocalHost();
			String localname = ia.getHostName();
			System.out.println("当前主机的名称是：" + localname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
//	/** 
//	   * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址, 
//	   * 
//	   * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？ 
//	   * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。 
//	   * 
//	   * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 
//	   * 192.168.1.100 
//	   * 
//	   * 用户真实IP为： 192.168.1.110 
//	   * 
//	   * @param request 
//	   * @return 
//	   */
//	  public static String getIpAddress(HttpServletRequest request) { 
//	    String ip = request.getHeader("x-forwarded-for"); 
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	      ip = request.getHeader("Proxy-Client-IP"); 
//	    } 
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	      ip = request.getHeader("WL-Proxy-Client-IP"); 
//	    } 
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	      ip = request.getHeader("HTTP_CLIENT_IP"); 
//	    } 
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
//	    } 
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	      ip = request.getRemoteAddr(); 
//	    } 
//	    return ip; 
//	  } 
	public static void main(String[] args) {
		getipUtil.getip();
		getipUtil.getlocalname();
		getipUtil.getlocalip();
        
	}

}
