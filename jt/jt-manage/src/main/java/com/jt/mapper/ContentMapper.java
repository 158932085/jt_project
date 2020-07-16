package com.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.Item;
import com.jt.pojo.ItemContent;

public interface ContentMapper extends BaseMapper<ItemContent>{

	@Select("select * from tb_content  order by updated desc limit #{start},#{rows}")
	List<Item> findItemPage(int start,int rows);
	
}
