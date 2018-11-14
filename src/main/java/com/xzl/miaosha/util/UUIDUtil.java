package com.xzl.miaosha.util;

import java.util.UUID;

/**
* @author xiezhengliang
* @date 2018年11月14日 下午6:29:47
*/
public class UUIDUtil {

	public static String uuid(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
