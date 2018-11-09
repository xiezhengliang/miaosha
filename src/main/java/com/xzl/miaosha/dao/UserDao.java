package com.xzl.miaosha.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.xzl.miaosha.domain.User;

/**
* @author xiezhengliang
* @date 2018年11月5日 下午4:32:35
*/
@Mapper
public interface UserDao {
	
	@Select("select * from user where id = #{id}")
	public User getById(int id);
	
	@Insert("insert user(id,name) value (#{id},#{name})")
	public int insert(User user);
}
