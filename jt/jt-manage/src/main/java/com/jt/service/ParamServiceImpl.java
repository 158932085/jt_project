package com.jt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.ParamMapper;
import com.jt.pojo.ItemParam;
import com.jt.vo.EasyUITable;
@Service
public class ParamServiceImpl implements ParamService{
    @Autowired
	private ParamMapper paramMapper;
	@Override
	public EasyUITable findItemByPage(int page, int rows) {
		// TODO Auto-generated method stub
		//使用mybatisPlus的分页插件实现分页
				//传递Page对象之后动态获取所有的分页数据
				IPage<ItemParam> iPage=new Page<>(page,rows);
				QueryWrapper<ItemParam> queryWrapper=new QueryWrapper<ItemParam>();
				//降序排序
				queryWrapper.orderByDesc("updated");
				iPage=paramMapper.selectPage(iPage, queryWrapper);
				//total记录数
				//Integer total=itemMapper.selectCount(null);
				int total=(int)iPage.getTotal();
				List<ItemParam> itemList=iPage.getRecords();
				//list分页之后的结果
				//int start=(page-1)*rows;
				//List<Item> itemList=itemMapper.findItemPage(start, rows);
				return new EasyUITable(total,itemList);	
	}

}
