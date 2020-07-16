package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)

public class FileImage
{
	private Integer error; //=0
	private String url;
	//1.2.3编辑FileController
	//1.2.4编辑pro配置文件
	//说明:在jt-manage中编辑image.properties文件.信息如下
	//1.2.5编辑FileService
	private Integer width;
	private Integer height;
	public static FileImage success(String url,Integer width,Integer height) {
	return new FileImage(0, url, width, height);
	}
	public static FileImage fail() {
	return new FileImage(1, null, null, null);
	}


}
