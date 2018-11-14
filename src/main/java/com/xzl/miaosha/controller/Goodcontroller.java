package com.xzl.miaosha.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.xzl.miaosha.domain.MiaoshaUser;
import com.xzl.miaosha.result.CodeMsg;
import com.xzl.miaosha.result.Result;
import com.xzl.miaosha.service.MiaoshaUserService;
import com.xzl.miaosha.service.UserService;
import com.xzl.miaosha.util.ValidatorUtil;
import com.xzl.miaosha.vo.LoginVo;

/**
* @author xiezhengliang
* @date 2018年11月7日 上午11:00:57
*/
@RequestMapping("/goods")
@Controller
public class Goodcontroller {

	private Logger log = LoggerFactory.getLogger(Goodcontroller.class);
	
	@Autowired
	MiaoshaUserService miaoshaUserService;
	
	@RequestMapping("/to_list")
	public String toList(Model model,
			@CookieValue(value = MiaoshaUserService.COOKIE_NAME_TOKEN,required=false)String cookieToken,
			//兼容把cookie放到参数的方式
			@RequestParam(value = MiaoshaUserService.COOKIE_NAME_TOKEN,required=false)String paramTonken){
		if(StringUtils.isEmpty(cookieToken)&&StringUtils.isEmpty(paramTonken)){
			return "login";
		}
		String token = StringUtils.isEmpty(paramTonken)?cookieToken:paramTonken;
		MiaoshaUser miaoshaUser = miaoshaUserService.getByToken(token);
		model.addAttribute("user", miaoshaUser);
		return "goods_list";
	}
	
	
}
