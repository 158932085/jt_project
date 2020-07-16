package com.jt.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors
@NoArgsConstructor
@AllArgsConstructor
public class SysResult {
	private Integer status;
	private String  msg;
	private  Object data;
	public static SysResult Success()
	{
		return new SysResult(200,"操作成功",null);
		
	}
	public static SysResult Success(Object data)
	{
		return new SysResult(200,"操作成功",data);
		
	}
	public static SysResult Success(String msg,Object data)
	{
		return new SysResult(200,msg,data);
		
	}
	public static SysResult fail()
	{
		return new SysResult(201,"业务调用失败",null);
		
	}
	
}
