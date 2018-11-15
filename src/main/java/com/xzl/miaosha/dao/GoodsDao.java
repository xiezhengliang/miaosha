package com.xzl.miaosha.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xzl.miaosha.vo.GoodsVo;

/**
* @author xiezhengliang
* @date 2018年11月15日 下午2:02:41
*/
@Mapper
public interface GoodsDao {
	@Select("select g.*,mg.stock_count,mg.start_date,mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id")
	public List<GoodsVo> getGoodsVo();
	@Select("select g.*,mg.stock_count,mg.start_date,mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id= #{goodsId}")
	public GoodsVo getGoodsByGoodsId(@Param("goodsId")long goodsId);
}
