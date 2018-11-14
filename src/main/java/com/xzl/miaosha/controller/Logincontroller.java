package com.xzl.miaosha.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.xzl.miaosha.result.CodeMsg;
import com.xzl.miaosha.result.Result;
import com.xzl.miaosha.service.MiaoshaUserService;
import com.xzl.miaosha.util.ValidatorUtil;
import com.xzl.miaosha.vo.LoginVo;

/**
* @author xiezhengliang
* @date 2018年11月7日 上午11:00:57
*/
@RequestMapping("/login")
@Controller
public class Logincontroller {

	private Logger log = LoggerFactory.getLogger(Logincontroller.class);
	
	@Autowired
	MiaoshaUserService miaoshaUserService;
	
	@RequestMapping("/to_login")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/do_login")
	@ResponseBody
	public Result<Boolean> doLogin(HttpServletResponse response ,@Valid LoginVo loginVo){
		log.info(loginVo.toString());
//		String passInput = loginVo.getPassword();
//		String mobile = loginVo.getMobile();
//		if(StringUtils.isEmpty(passInput)){
//			return Result.error(CodeMsg.PASSWORD_EMPTY);
//		}if(StringUtils.isEmpty(mobile)){
//			return Result.error(CodeMsg.MOBILE_EMPTY);
//		}if(!ValidatorUtil.isMobile(mobile)){
//			return Result.error(CodeMsg.MOBILE_ERROR);
//		}
		//登录
		miaoshaUserService.login(response, loginVo);
    	return Result.success(true);
		
	}
}
