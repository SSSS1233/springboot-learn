package com.subing.handler;

import com.subing.po.User;
import com.subing.po.UserExpand;
import com.subing.service.UserServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/5/17 23:37.
 * @Comment
 */
@Controller

public class UserHandler {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/index")
    @ApiOperation(value = "显示表格", notes = "")
    /* @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })*/
    public String index(Model m, HttpSession session) {
        m.addAttribute("demo", "hello");
        session.setAttribute("name", "宿冰");
        return "index";
    }

    @ApiOperation(value = "初始登陆", notes = "")
    @RequestMapping("/login")
    public String login(Model m, HttpSession session) {
        return "login";
    }

    @RequestMapping("/add.do")
    public String addUser(User user) {
        userService.insert(user);
        return "index";
    }

    @ApiOperation(value = "登陆验证", notes = "")
    @ResponseBody
    @RequestMapping("/checks.do")
    public Map<String, Object> checks(User user) {
        System.out.println(user.getName() + " " + user.getPassword());
        Map<String, Object> map = new HashMap<>();
        if (userService.selectName(user) != null) {
            if (user.getPassword().equals(userService.selectpass(user))) {
                map.put("message", "用户存在");
            } else {
                map.put("message", "密码错误");
            }

        } else {
            map.put("message", "用户不存在");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/check.do")
    public List<User> check(UserExpand user) {
        System.out.println(user.getNum() + "PAGE");
        List l = userService.selectAll(user.getNum(), 2);
        System.out.println(l.size());
        return l;
    }

}
