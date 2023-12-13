package com.example.crud.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyx
 */
@Configuration
public class MapperConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        定义mapper拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        添加具体的拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
