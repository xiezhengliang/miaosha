package com.xzl.miaosha.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.xzl.miaosha.domain.MiaoshaUser;

/**
* @author xiezhengliang
* @date 2018年11月14日 上午11:42:07
*/
@Mapper
public interface MiaoshaUserDao {

	@Select("select * from miaosha_user where id = #{id}")
	public MiaoshaUser getById(long id);
}
