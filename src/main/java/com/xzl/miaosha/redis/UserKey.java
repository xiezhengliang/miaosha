package com.xzl.miaosha.redis;
/**
* @author xiezhengliang
* @date 2018年11月6日 下午4:34:49
*/
public class UserKey extends BasePrefix {

	
	
	private UserKey(String prefix) {
		super(prefix);
	}

	public static UserKey getById = new UserKey("id");
	public static UserKey getByName = new UserKey("name");
}
