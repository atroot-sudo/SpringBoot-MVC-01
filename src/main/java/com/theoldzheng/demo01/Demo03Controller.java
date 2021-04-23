package com.theoldzheng.demo01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 请求域数据的存放以及提取。
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.23 19:10
 */
@Controller
public class Demo03Controller {
    @GetMapping(value = "/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "msg获取成功！");
        request.setAttribute("code", "200 OK");
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping(value = "/success")
    public Map successPage(@RequestAttribute String msg,
                           @RequestAttribute String code,
                           HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("code", code);
        System.out.println("msg" + msg);
        System.out.println("code" + code);

        Object msg1 = request.getAttribute("msg");
        Object code1 = request.getAttribute("code");
        Object msg11 = map.put("msg1", msg1);
        Object code11 = map.put("code1", code1);
        System.out.println("msg11" + msg11);
        System.out.println("code11" + code11);
        return map;
    }

    @ResponseBody
    @GetMapping(value = "/cars/{path}")
    public Map carsSell(@MatrixVariable("brand") String brand,
                        @MatrixVariable("price") List<Integer> price,
                        @PathVariable("path") String path) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("brand", brand);
        map.put("price", price);
        map.put("path", path);

        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/boss/{bossId}/{employeeId}")
    public Map employee(@MatrixVariable(value = "id", pathVar = "bossId") String bid,
                        @MatrixVariable(value = "id", pathVar = "employeeId") String eid) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("bid",bid);
        map.put("eid",eid);
        return map;
    }

}
