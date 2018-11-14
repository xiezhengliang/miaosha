package com.xzl.miaosha.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.xzl.miaosha.validator.IsMobile;

/**
* @author xiezhengliang
* @date 2018年11月7日 上午11:34:03
*/
public class LoginVo {

	@NotNull
	@IsMobile
	private String mobile;
	@NotNull
	@Length(min=32)
	private String password;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginVo [mobile=" + mobile + ", password=" + password + "]";
	}
	
	
}
