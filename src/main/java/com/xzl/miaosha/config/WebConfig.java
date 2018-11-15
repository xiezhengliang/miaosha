package com.xzl.miaosha.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
* @author xiezhengliang
* @date 2018年11月15日 上午10:59:22
*/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	@Autowired
	UserArgumentResoulver userArgumentResolver;
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
		argumentResolvers.add(userArgumentResolver);
		
	}
	
}
