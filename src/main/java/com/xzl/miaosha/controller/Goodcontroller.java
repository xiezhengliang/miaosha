package com.xzl.miaosha.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.xzl.miaosha.domain.MiaoshaUser;
import com.xzl.miaosha.service.GoodsService;
import com.xzl.miaosha.service.MiaoshaUserService;
import com.xzl.miaosha.vo.GoodsVo;

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
	@Autowired
	GoodsService goodsService;
	
	@RequestMapping("/to_list")
	public String toList(Model model,MiaoshaUser user){
		List<GoodsVo> goodsList = goodsService.listGoodsVo();
		model.addAttribute("goodsList",goodsList);
		model.addAttribute("user", user);
		return "goods_list";
	}
	
	@RequestMapping("/to_detail/{goodsId}")
	public String toDetail(Model model,MiaoshaUser user,
			@PathVariable("goodsId")long goodsId){
model.addAttribute("user", user);
    	
    	GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
    	model.addAttribute("goods", goods);
    	
    	long startAt = goods.getStartDate().getTime();
    	long endAt = goods.getEndDate().getTime();
    	long now = System.currentTimeMillis();
    	
    	int miaoshaStatus = 0;
    	int remainSeconds = 0;
    	if(now < startAt ) {//秒杀还没开始，倒计时
    		miaoshaStatus = 0;
    		remainSeconds = (int)((startAt - now )/1000);
    	}else  if(now > endAt){//秒杀已经结束
    		miaoshaStatus = 2;
    		remainSeconds = -1;
    	}else {//秒杀进行中
    		miaoshaStatus = 1;
    		remainSeconds = 0;
    	}
    	model.addAttribute("miaoshaStatus", miaoshaStatus);
    	model.addAttribute("remainSeconds", remainSeconds);
        return "goods_detail";
	}
	
}
