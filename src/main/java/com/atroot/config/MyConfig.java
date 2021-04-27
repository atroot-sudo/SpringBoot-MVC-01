package com.atroot.config;

import com.atroot.converter.MyConverter;
import com.atroot.pojo.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    //自定义Spring的入口
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                HashMap<String, MediaType> mediaType = new HashMap<>();
                mediaType.put("json", MediaType.APPLICATION_JSON);
                mediaType.put("xml", MediaType.APPLICATION_XML);
                mediaType.put("mm", MediaType.parseMediaType("application/my-converter"));
                //指定解析哪些参数对应的媒体类型
                ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(mediaType);
//                parameterStrategy.setParameterName("自定义");
                HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();
                configurer.strategies(Arrays.asList(parameterStrategy, headerStrategy));
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new MyConverter());
            }

            //打开矩阵变量支持--->关闭自动去除分号;
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            //自定义Bean的绑定--->自定义转换器Converter
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String s) {
                        Pet pet = new Pet();
                        String[] split = s.split(",");
                        pet.setName(split[0]);
                        pet.setAge(Integer.parseInt(split[1]));
                        return pet;
                    }
                });
            }
        };
    }
}
