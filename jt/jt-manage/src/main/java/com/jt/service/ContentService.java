package com.jt.service;

import com.jt.pojo.ItemContent;
import com.jt.vo.EasyUITable;

public interface ContentService {

	EasyUITable findItemByPage(int page, int rows);

	void editContent(ItemContent itemContent);

	void updateContent(ItemContent itemContent);

}
