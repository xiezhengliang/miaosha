package com.xzl.miaosha.redis;
/**
* @author xiezhengliang
* @date 2018年11月6日 下午4:34:49
*/
public class MiaoshaUserKey extends BasePrefix {

	private static int TOKEN_EXPIRE= 60*60*24*2;
	
	private MiaoshaUserKey(int expireSecondes,String prefix) {
		super(expireSecondes,prefix);
	}

	public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE,"tk");
}
