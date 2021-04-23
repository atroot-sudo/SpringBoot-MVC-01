package com.theoldzheng.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

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
     *
     * @return methodFilter
     */
//    @Bean
//    public HiddenHttpMethodFilter getMethodFilter(){
//        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
//        methodFilter.setMethodParam("_m");
//        return methodFilter;
//    }
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }
}
