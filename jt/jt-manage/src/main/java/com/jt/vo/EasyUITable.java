package com.jt.vo;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class EasyUITable {
	private long total; //定义总数记录
	private List rows;	//定义集合信息，写的就是用户展现的记录

}
