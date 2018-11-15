package com.xzl.miaosha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xzl.miaosha.dao.GoodsDao;
import com.xzl.miaosha.domain.Goods;
import com.xzl.miaosha.domain.MiaoshaUser;
import com.xzl.miaosha.domain.OrderInfo;
import com.xzl.miaosha.vo.GoodsVo;

/**
* @author xiezhengliang
* @date 2018年11月15日 下午5:18:28
*/
@Service
public class MiaoshaService {

	@Autowired 
	GoodsService goodService;
	@Autowired
	OderService orderService;
	
	@Transactional
	public OrderInfo miaosha(MiaoshaUser user,GoodsVo goods){
		goodService.reduceStocke(goods);
		//创建订单
		OrderInfo orderInfo = orderService.createOrder(user,goods);
		return orderInfo;
	}
}
