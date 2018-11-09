package com.xzl.miaosha.result;
/**
* @author xiezhengliang
* @date 2018年11月5日 下午2:58:08
*/
public class CodeMsg {

	private int code;
	private String msg;
	
	public static CodeMsg SUCCESS = new CodeMsg(0,"success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100,"服务端异常");
	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211,"密码不能为空");
	public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212,"手机号不能为空");
	public static CodeMsg MOBILE_ERROR = new CodeMsg(500213,"手机号格式错误");
	
	private CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
		
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
}
