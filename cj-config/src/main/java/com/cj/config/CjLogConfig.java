package com.cj.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 日志管理
 */
public class CjLogConfig {
	/**
	 * 根据业务需要，可将日志风别打印到不同文件中
	 */
	private final static Logger log = LoggerFactory.getLogger("BLL-LOG");
	/**
	 * 根据业务需要，可修改为不同模块的名称
	 * @param info
	 */
	public static void log(String info) {
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss:SSS");
		String strTime=dateFormat.format(calendar.getTime());
		CjLogConfig.log.info(strTime+"---业务模块日志信息："+info);
		System.out.println(strTime+"---业务模块日志信息："+info);
	}
}
