package com.pzj.core.smp.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMVCController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView testController(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletRequest request) {
        System.out.println("请求到达代码里面");
        // 跳转到business.jsp页面
        ModelAndView business = new ModelAndView("business");
        business.addObject("userName", userName);
        business.addObject("password", password);
        return business;
        //return "business";
    }
}
