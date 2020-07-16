package com.jt.service;

import com.jt.vo.EasyUITable;

public interface ParamService {

	public EasyUITable findItemByPage(int page, int rows);
}
