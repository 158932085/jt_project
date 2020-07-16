package com.jt.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.ContentMapper;
import com.jt.pojo.ItemContent;
import com.jt.vo.EasyUITable;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private ContentMapper contentMapper;

	@Override
	public EasyUITable findItemByPage(int page, int rows) {
		// TODO Auto-generated method stub
		// 使用mybatisPlus的分页插件实现分页
		// 传递Page对象之后动态获取所有的分页数据
		IPage<ItemContent> iPage = new Page<>(page, rows);
		QueryWrapper<ItemContent> queryWrapper = new QueryWrapper<ItemContent>();
		// 降序排序
		queryWrapper.orderByDesc("updated");
		iPage = contentMapper.selectPage(iPage, queryWrapper);
		// total记录数
		// Integer total=itemMapper.selectCount(null);
		int total = (int) iPage.getTotal();
		List<ItemContent> itemList = iPage.getRecords();
		// list分页之后的结果
		// int start=(page-1)*rows;
		// List<Item> itemList=itemMapper.findItemPage(start, rows);
		return new EasyUITable(total, itemList);
	}

	public void editContent(ItemContent itemContent) {
		// 入库
		itemContent.setId(itemContent.getId()).setCreated(new Date()).setUpdated(itemContent.getCreated());
		contentMapper.insert(itemContent);
	}

	public void updateContent(ItemContent itemContent) {
		// TODO Auto-generated method stub
		itemContent.setUpdated(new Date());
		contentMapper.updateById(itemContent);

	}
}
