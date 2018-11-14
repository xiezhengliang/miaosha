package com.xzl.miaosha.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.mysql.fabric.Response;
import com.xzl.miaosha.dao.MiaoshaUserDao;
import com.xzl.miaosha.domain.MiaoshaUser;
import com.xzl.miaosha.exception.GlobalException;
import com.xzl.miaosha.redis.MiaoshaUserKey;
import com.xzl.miaosha.redis.RedisService;
import com.xzl.miaosha.result.CodeMsg;
import com.xzl.miaosha.util.MD5Util;
import com.xzl.miaosha.util.UUIDUtil;
import com.xzl.miaosha.vo.LoginVo;


/**
* @author xiezhengliang
* @date 2018年11月14日 上午11:47:54
*/
@Service
public class MiaoshaUserService {

	public static final String COOKIE_NAME_TOKEN = "token";
	@Autowired
	MiaoshaUserDao maioshaUserDao;
	@Autowired
	RedisService redisService;
	public MiaoshaUser getById(Long id){
		return maioshaUserDao.getById(id);
	}

	public boolean login(HttpServletResponse response, LoginVo loginVo) {
		if(loginVo == null){
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		String mobile = loginVo.getMobile();
		String formPassword = loginVo.getPassword();
		MiaoshaUser user = getById(Long.parseLong(mobile));
		//验证手机号是否存在
		if(user ==null){
			throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
		}
		//验证密码
		String dbPass = user.getPassword();
		String saltDB = user.getSalt();
		String calcpass= MD5Util.formPassToDBPass(formPassword, saltDB);
		if(!calcpass.equals(dbPass)){
			throw new GlobalException(CodeMsg.PASSWORD_ERROR);
		}
		//生成cookie
		String token = UUIDUtil.uuid();
		redisService.set(MiaoshaUserKey.token, token, user);
		Cookie cookie = new Cookie(COOKIE_NAME_TOKEN,token);
		cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
		cookie.setPath("/");
		response.addCookie(cookie);
		
		return true;
	}

	public MiaoshaUser getByToken(String token) {
		if(StringUtils.isEmpty(token)){
			return null;
		}
		return redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
	}
}
