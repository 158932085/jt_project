package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jt.service.ParamService;
import com.jt.vo.EasyUITable;

@RestController
@RequestMapping("/item")
public class ParamController {

	@Autowired
	private ParamService paramService;
	@RequestMapping("/param/list")
	public EasyUITable finitemByPage(int page,int rows)
	{
		return paramService.findItemByPage(page, rows);
	};
	
}