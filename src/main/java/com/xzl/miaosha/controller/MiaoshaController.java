package com.xzl.miaosha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xzl.miaosha.domain.MiaoshaOrder;
import com.xzl.miaosha.domain.MiaoshaUser;
import com.xzl.miaosha.domain.OrderInfo;
import com.xzl.miaosha.result.CodeMsg;
import com.xzl.miaosha.service.GoodsService;
import com.xzl.miaosha.service.MiaoshaService;
import com.xzl.miaosha.service.OderService;
import com.xzl.miaosha.vo.GoodsVo;

/**
* @author xiezhengliang
* @date 2018年11月15日 下午4:25:39
*/
@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

	@Autowired
	GoodsService goodsService;
	@Autowired
	OderService orderService;
	@Autowired
	MiaoshaService miaoshaService;
	@RequestMapping("/do_miaosha")
	public String toList(Model model,MiaoshaUser user,
			@RequestParam("goodsId")long goodsId){
		if(user==null){
			return "login";
		}
		//判断库存
		GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
		int stock = goods.getStockCount();
		if(stock<=0){
			model.addAttribute("errmsg", CodeMsg.MIAOSHA_OVER.getMsg());
			return "miaosha_fail";
		}
		//判断是否已经秒杀到
		MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(),goodsId);
		if(order!=null){
			model.addAttribute("errmsg", CodeMsg.MIAOSHA_REPEATE.getMsg());
			return "miaosha_fail";
		}
		//减库存，下订单，写入秒杀订单
		OrderInfo orderInfo = miaoshaService.miaosha(user,goods);
		model.addAttribute("orderInfo", orderInfo);
		model.addAttribute("goods", goods);
		return "order_detail";
	}
}
