package com.theoldzheng.demo01;

import org.springframework.web.bind.annotation.*;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.21 19:55
 */
@RestController
public class Demo01Controller {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping(value = "/user")
    public String getUser() {
        return "GET-张三";
    }

    @PostMapping(value = "/user")
    public String saveUser() {
        return "POST-张三";
    }


    @PutMapping(value = "/user")
    public String putUser() {
        return "PUT-张三";
    }

    @DeleteMapping(value = "/user")
    public String deleteUser() {
        return "DELETE-张三";
    }

}
