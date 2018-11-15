package com.xzl.miaosha.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.xzl.miaosha.domain.MiaoshaUser;
import com.xzl.miaosha.service.MiaoshaUserService;

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
	public String toList(HttpServletResponse response,Model model,
			MiaoshaUser user){
		model.addAttribute("user", user);
		return "goods_list";
	}
	
	
}
