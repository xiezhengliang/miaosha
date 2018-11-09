package com.xzl.miaosha.redis;
/**
* @author xiezhengliang
* @date 2018年11月6日 下午4:20:41
*/
public abstract class BasePrefix implements KeyPrefix {

	private int expireSeconds;
	private String prefix;
	
	public BasePrefix(String prefix) {
		this(0, prefix);
	}
	
	public  BasePrefix(int expireSeconds,String prefix) {
		this.expireSeconds = expireSeconds;
		this.prefix = prefix;
	}
	
	@Override
	public int expireSeconds() {//默认0代表永不过期
		return expireSeconds;
	}

	@Override
	public String getPrefix() {
		String calssName =getClass().getSimpleName();
		return calssName + ":" + prefix;
	}

}
