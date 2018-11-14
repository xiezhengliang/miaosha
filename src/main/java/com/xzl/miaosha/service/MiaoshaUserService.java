package com.xzl.miaosha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzl.miaosha.dao.MiaoshaUserDao;
import com.xzl.miaosha.domain.MiaoshaUser;
import com.xzl.miaosha.exception.GlobalException;
import com.xzl.miaosha.result.CodeMsg;
import com.xzl.miaosha.util.MD5Util;
import com.xzl.miaosha.vo.LoginVo;

/**
* @author xiezhengliang
* @date 2018年11月14日 上午11:47:54
*/
@Service
public class MiaoshaUserService {

	@Autowired
	MiaoshaUserDao maioshaUserDao;
	
	public MiaoshaUser getById(Long id){
		return maioshaUserDao.getById(id);
	}

	public boolean login(LoginVo loginVo) {
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
		
		return true;
	}
}
