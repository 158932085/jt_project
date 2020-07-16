package com.jt.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.ItemCat;
import com.jt.vo.EasyUITree;
@Service
public class ItemCatServiceImpl implements ItemCatService{
	@Autowired
	ItemCatMapper itemCatMapper;
	@Override
	public ItemCat findItemCatNameById(Long itemCatId) {
		// TODO Auto-generated method stub
		return itemCatMapper.selectById(itemCatId);
	}
	@Override
	public List<EasyUITree> findItemCatList(Long parentId) {
		// TODO Auto-generated method stub
		//1.利用parentId查询数据库记录
		List<ItemCat> catList=findItemCatListByParentId(parentId);
		List<EasyUITree> treeList=new ArrayList<EasyUITree>();
		//利用循环方式实现数据遍历
		for(ItemCat itemCat:catList)
		{
			Long id=itemCat.getId();
			String text=itemCat.getName();
			String state=itemCat.getIsParent()?"close":"open";
			EasyUITree tree=new EasyUITree(id,text,state);
			treeList.add(tree);
		}
		return treeList;
	}
	
	private List<ItemCat> findItemCatListByParentId(Long parentId) {
		// TODO Auto-generated method stub
		QueryWrapper<ItemCat> queryWrapper=new QueryWrapper<ItemCat>();
		queryWrapper.eq("parent_id", parentId);
		return itemCatMapper.selectList(queryWrapper);
	}
	
	
	
};
