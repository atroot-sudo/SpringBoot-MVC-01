package com.atroot.demo01;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 请求参数
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.22 15:15
 */
@RestController
public class Demo02Controller {
    @RequestMapping(value = "/user/{id}/name/{name}")
    public Map<String, Object> getPerson(@PathVariable("id") String id,
                                         @PathVariable("name") String name,
                                         @PathVariable Map<String, String> pv, //将请求地址中的所有参数，用map封装
                                         @RequestHeader("User-Agent") String userAgent,
                                         @RequestHeader Map<String, String> Headers,
                                         @RequestParam("username") String username,
                                         @RequestParam("hobby") List<String> list,
                                         @RequestParam Map<String, String> param,
                                         @CookieValue Cookie cookie,
                                         @CookieValue("_ga") String _ga) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(id, name);
        map.put("pv", pv);
//        map.put("User-Agent", userAgent);
//        map.put("Headers", Headers);
        map.put("username", username);
        map.put("hobby", list);
        map.put("param", username);
        map.put("cookie", cookie);
        map.put("_ga", _ga);
        System.out.println(name + " > " + id);
        return map;
    }

    @PostMapping(value = "/save")
    public Map postMethod(@RequestBody String content) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }
}
