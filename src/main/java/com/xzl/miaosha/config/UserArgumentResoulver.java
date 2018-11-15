package com.xzl.miaosha.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.druid.util.StringUtils;
import com.xzl.miaosha.domain.MiaoshaUser;
import com.xzl.miaosha.service.MiaoshaUserService;

/**
* @author xiezhengliang
* @date 2018年11月15日 上午11:02:41
*/
@Service
public class UserArgumentResoulver implements HandlerMethodArgumentResolver{

	@Autowired
	MiaoshaUserService miaoshaUserService;
	@Override
	public Object resolveArgument(MethodParameter arg0, ModelAndViewContainer arg1, NativeWebRequest webRequest,
			WebDataBinderFactory arg3) throws Exception {
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
		
		String paramToken = request.getParameter(MiaoshaUserService.COOKIE_NAME_TOKEN);
		String cookieToken = getCookieValue(request,MiaoshaUserService.COOKIE_NAME_TOKEN);
		if(StringUtils.isEmpty(cookieToken)&&StringUtils.isEmpty(paramToken)){
			return "login";
		}
		String token = StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
		MiaoshaUser miaoshaUser = miaoshaUserService.getByToken(response,token);
		return miaoshaUser;
	}

	private String getCookieValue(HttpServletRequest request, String cookieNameToken) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals(cookieNameToken)){
				return cookie.getValue();
			}
		}
		return null;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		Class<?> clazz = parameter.getParameterType();
		return clazz == MiaoshaUser.class;
	}

}
