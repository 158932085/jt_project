package com.jt.pojo;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.experimental.Accessors;

@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("tb_content")	//指定表名称
@Data					
@Accessors(chain=true)
public class ItemContent extends BasePojo { 
	private Long   id;
	private Long   categoryId;  //内容类目ID
	private String title;        //内容标题
	private String subTitle;    //varchar(100)子标题
	private String  titleDesc;  //varchar(500)标题描述
	private String  url;         //varchar(500)链接
	private String  pic;         //varchar(300)图片绝对路径
	private String  pic2;        //varchar(300)图片2
	private String  content;     //text内容

	
	
	
}
