package com.xzl.miaosha.redis;
/**
* @author xiezhengliang
* @date 2018年11月6日 下午4:35:21
*/
public class OrderKey extends BasePrefix {

	public OrderKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}

}
