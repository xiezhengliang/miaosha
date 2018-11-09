package com.xzl.miaosha.redis;
/**
* @author xiezhengliang
* @date 2018年11月6日 下午4:19:04
*/
public interface KeyPrefix {

	public int expireSeconds();
	
	public String getPrefix();
	
}
