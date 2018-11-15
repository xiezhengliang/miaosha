package com.xzl.miaosha.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xzl.miaosha.domain.Goods;
import com.xzl.miaosha.domain.MiaoshaGoods;
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
	
	@Update("update miaosha_goods set stock_count = stock_count-1 where goods_id = #{goodsId} ")
	public void reduceStock(MiaoshaGoods g);
}
