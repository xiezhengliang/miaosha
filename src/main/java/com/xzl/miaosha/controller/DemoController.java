package com.xzl.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xzl.miaosha.domain.User;
import com.xzl.miaosha.redis.RedisService;
import com.xzl.miaosha.redis.UserKey;
import com.xzl.miaosha.result.CodeMsg;
import com.xzl.miaosha.result.Result;
import com.xzl.miaosha.service.UserService;

/**
 * @author xiezhengliang
 * @date 2018年11月5日 上午11:01:03
 */
@Controller
@EnableAutoConfiguration
public class DemoController {

	@Autowired
	UserService userService;

	@Autowired
	RedisService redisService;
	
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "hello World";
	}

	@RequestMapping("/hello")
	@ResponseBody
	public Result<String> hello() {
		return Result.success("hello,xzl");
	}

	@RequestMapping("/helloError")
	@ResponseBody
	public Result<String> helloErro() {
		return Result.error(CodeMsg.SERVER_ERROR);
	}

	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model) {
		model.addAttribute("name", "xiezhengliang");
		return "hello";
	}

	@RequestMapping("/db/get")
	@ResponseBody
	public Result<User> dbGet() {
		User user = userService.getById(1);
		return Result.success(user);
	}
	
	@RequestMapping("/db/tx")
	@ResponseBody
	public boolean dbTx() {
		return userService.tx();
	}
	
	@RequestMapping("/redis/get")
	@ResponseBody
	public Result<User> redisGet() {
		User user = redisService.get(UserKey.getById,""+1,User.class);
		return Result.success(user);
	}
	
	@RequestMapping("/redis/set")
	@ResponseBody
	public Result<Boolean> redisSet() {
		User user = new User();
		user.setId(1);
		user.setName("xiezhengliang");
		redisService.set(UserKey.getById,""+1,user);
		return Result.success(true);
	}
	
	@RequestMapping("/redis/decr")
	@ResponseBody
	public Result<Boolean> redisDecr() {
		redisService.decr(UserKey.getById,"key1");
		return Result.success(true);
	}

}
