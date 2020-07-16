package com.jt.controller;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.Item;
import com.jt.pojo.ItemContent;
import com.jt.pojo.ItemDesc;
import com.jt.service.ContentService;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;

@RestController
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	@RequestMapping("/query/list")
	public EasyUITable finitemByPage(int page,int rows)
	{
		return contentService.findItemByPage(page, rows);
	};
	//@RequestMapping("/category/list")
	
	@RequestMapping("/edit")
	public SysResult saveItem(ItemContent itemContent) {
	contentService.editContent(itemContent);
	return SysResult.Success();
	}
	
	@RequestMapping("/update")	
	public SysResult updateItem(ItemContent itemContent) {
		contentService.updateContent(itemContent);
		return SysResult.Success();
	}
	}



