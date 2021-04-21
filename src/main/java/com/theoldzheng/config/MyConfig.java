package com.theoldzheng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.21 20:01
 */
@Configuration(proxyBeanMethods = false)
public class MyConfig {
    /**
     * 自定义 "_method" -> "_m"
     * @return methodFilter
     */
    @Bean
    public HiddenHttpMethodFilter getMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_m");
        return methodFilter;
    }
}
