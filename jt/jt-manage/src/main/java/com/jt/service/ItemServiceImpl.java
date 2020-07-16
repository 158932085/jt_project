package com.jt.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.ItemDescMapper;
import com.jt.mapper.ItemMapper;
import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.vo.EasyUITable;


@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper itemMapper;
	@Override
	//@Service
	public EasyUITable findItemByPage(int page,int rows)
	{
		//使用mybatisPlus的分页插件实现分页
		//传递Page对象之后动态获取所有的分页数据
		IPage<Item> iPage=new Page<>(page,rows);
		QueryWrapper<Item> queryWrapper=new QueryWrapper<Item>();
		//降序排序
		queryWrapper.orderByDesc("updated");
		iPage=itemMapper.selectPage(iPage, queryWrapper);
		//total记录数
		//Integer total=itemMapper.selectCount(null);
		int total=(int)iPage.getTotal();
		List<Item> itemList=iPage.getRecords();
		//list分页之后的结果
		//int start=(page-1)*rows;
		//List<Item> itemList=itemMapper.findItemPage(start, rows);
		return new EasyUITable(total,itemList);	
	}
	
	
	//入库操作
	@Autowired
	private ItemDescMapper itemDescMapper;
	@Override
	@Transactional

	public void saveItem(Item item,ItemDesc itemDesc) {
		// 入库
		item.setStatus(1)
		.setCreated(new Date())
		.setUpdated(item.getCreated()); 
		itemMapper.insert(item);
		
		//实现tb_itemDesc入库操作
		itemDesc.setItemId(item.getId()) 
		.setCreated(item.getCreated()) 
		.setUpdated(item.getUpdated());
		itemDescMapper.insert(itemDesc);
	}
	
	@Override
	public void updateItem(Item item,ItemDesc itemDesc) {
		// TODO Auto-generated method stub
		item.setUpdated(new Date());
		itemMapper.updateById(item);
		//2.同时更新属性
		itemDesc.setItemId(item.getId()).setUpdated(item.getUpdated());
		itemDescMapper.updateById(itemDesc);
	}
	
	@Override
	public void deleteItems(Long[] ids)
	{
	//List<Long> idList = Arrays.asList(ids);
	//方式一：MP方式实现数据删除
	//itemMapper.deleteBatchIds(idList);
	//方式二:复杂的业务就必须使用mybatis手动的实现数据删除操作
	//在ItemMapper接口中添加deleteItems方法
	itemMapper.deleteItems(ids);
	itemDescMapper.deleteItemDesc(ids);
	}
	
	public void updateStatus(int status, Long[] ids){
   //1.使用MP的方式实现数据更新 entity修改修改的数据,updateWrapper
	Item item = new Item();
	item.setStatus(status).setUpdated(new Date());
	UpdateWrapper<Item> updateWrapper =
	new UpdateWrapper<Item>();
	updateWrapper.in("id", Arrays.asList(ids));
	itemMapper.update(item, updateWrapper);
	//2.作业 使用sql的方式实现该业务.
	}

    @Override
    public ItemDesc findItemDescById(Long itemId) {
    	return itemDescMapper.selectById(itemId);
    }

	
		
	
}
