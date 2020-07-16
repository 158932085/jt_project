package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.experimental.Accessors;

@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("tb_item_param")	//指定表名称
@Data					
@Accessors(chain=true)
public class ItemParam extends BasePojo
{
	private Long   id;           //ID
	private Long itemCatId;  //商品类目ID
	private String paramData;   //text参数数据

}
