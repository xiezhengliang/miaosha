package com.xzl.miaosha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzl.miaosha.dao.GoodsDao;
import com.xzl.miaosha.vo.GoodsVo;

/**
* @author xiezhengliang
* @date 2018年11月15日 下午2:02:18
*/
@Service
public class GoodsService {

	@Autowired
	GoodsDao goodsDao;
	
	public List<GoodsVo> listGoodsVo(){
		return goodsDao.getGoodsVo();
	}

	public GoodsVo getGoodsVoByGoodsId(long goodsId) {
		return goodsDao.getGoodsByGoodsId(goodsId);
	}
}
