package com.xzl.miaosha.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.druid.util.StringUtils;

/**
* @author xiezhengliang
* @date 2018年11月7日 上午11:53:50
*/
public class ValidatorUtil {
	
	private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");
	public static boolean isMobile(String src){
		if(StringUtils.isEmpty(src)){
			return false;
		}
		Matcher m = mobile_pattern.matcher(src);
		return m.matches();
	}
}
