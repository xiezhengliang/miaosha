package com.xzl.miaosha.vo;

import java.util.Date;

import com.xzl.miaosha.domain.Goods;

/**
* @author xiezhengliang
* @date 2018年11月15日 下午2:05:07
*/
public class GoodsVo extends Goods{
	private Integer stockCount;
	private Date startDate;
	private Date endDate;
	private Double miaoshaPrice;
	public Integer getStockCount() {
		return stockCount;
	}
	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Double getMiaoshaPrice() {
		return miaoshaPrice;
	}
	public void setMiaoshaPrice(Double miaoshaPrice) {
		this.miaoshaPrice = miaoshaPrice;
	}
	
}
