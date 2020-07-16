package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.service.ItemService;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;
@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired

	
	private ItemService itemService;
	@RequestMapping("/query")
	public EasyUITable finitemByPage(int page,int rows)
	{
		return itemService.findItemByPage(page, rows);
	};
	@RequestMapping("/save")
	public SysResult saveItem(Item item,ItemDesc itemDesc)
	{
		itemService.saveItem(item,itemDesc);
		return SysResult.Success();
		
	}
	@RequestMapping("/update")	
	public SysResult updateItem(Item item,ItemDesc itemDesc) {
		itemService.updateItem(item,itemDesc);
		return SysResult.Success();
	}
	/**
	 * 商品删除
	 * @param ids
	 * @return
	 */
	
	@RequestMapping("/delete")
	public SysResult deleteItems(Long[] ids) {
	itemService.deleteItems(ids);
	return SysResult.Success();
	}
	@RequestMapping("/updateStatus/{status}")
	public SysResult updateStatus(@PathVariable int status,Long... ids) {
	//Long... ids这种写法为可变参
	//可以先输出一下，前台传过来的参数
	//System.out.println(status+":"+ids);
	itemService.updateStatus(status,ids);
	return SysResult.Success();
	}
	/*
	 * ur1:http://localhost:8091/query/item/desc
	 * 请求参数：无
	 * 返回值类型：SysResult对象
	 */
	@RequestMapping("/query/item/desc/{itemId}")
	public SysResult findItemDescById(@PathVariable Long itemId) {
		ItemDesc itemDesc=itemService.findItemDescById(itemId);
		return SysResult.Success(itemDesc);
		
	}


	
}
