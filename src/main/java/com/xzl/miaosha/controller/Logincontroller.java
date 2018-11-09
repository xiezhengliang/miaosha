package com.xzl.miaosha.controller;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;
import com.xzl.miaosha.result.CodeMsg;
import com.xzl.miaosha.result.Result;
import com.xzl.miaosha.util.ValidatorUtil;
import com.xzl.miaosha.vo.LoginVo;

/**
* @author xiezhengliang
* @date 2018年11月7日 上午11:00:57
*/
@RequestMapping("/login")
@Controller
@EnableAutoConfiguration
public class Logincontroller {

	private Logger log = LoggerFactory.getLogger(Logincontroller.class);
	
	@RequestMapping("/to_login")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/do_login")
	public Result<Boolean> doLogin(LoginVo loginVo){
		log.info(loginVo.toString());
		String passInput = loginVo.getPassword();
		String mobile = loginVo.getMobile();
		if(StringUtils.isEmpty(passInput)){
			return Result.error(CodeMsg.PASSWORD_EMPTY);
		}if(StringUtils.isEmpty(mobile)){
			return Result.error(CodeMsg.MOBILE_EMPTY);
		}
		if(ValidatorUtil.isMobile(mobile)){
			return Result.error(CodeMsg.MOBILE_EMPTY);
		}
		if(!ValidatorUtil.isMobile(mobile)){
			return Result.error(CodeMsg.MOBILE_ERROR);
		}
		return null;
	}
}
