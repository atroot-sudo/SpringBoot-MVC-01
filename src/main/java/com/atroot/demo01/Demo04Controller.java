package com.atroot.demo01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description:
 *
 * @author atroot@126.com  @ZYD
 * @create 2021.4.27 17:19
 */
@Controller
public class Demo04Controller {
    @GetMapping(value = "/atroot")
    public String atroot(Model model){
        //Model中的数据会被放到Request请求域中
        model.addAttribute("msg","测试thymeleaf");
        model.addAttribute("test1","https:www.iqiyi.com");
        return "success";
    }
}
