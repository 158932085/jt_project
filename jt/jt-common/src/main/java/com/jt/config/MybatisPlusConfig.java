package com.jt.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;


/*
 * 配置类,定义MybatisPlus的分页插件
 * @author gcl
 * */
@Configuration

public class MybatisPlusConfig {
	@Bean
	public PaginationInterceptor  paginationInterceptor()
	{
		return new PaginationInterceptor();
	}
	

}
