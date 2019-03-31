package com.demo.controller;

import com.demo.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author ldd
 * @desc
 * @create 2019-03-30 11:16
 **/
@Controller
@RequestMapping("/shiro")
public class ShiroController {
    @Autowired
    private ShiroService shiroService;

    @RequestMapping("/annotation")
    public String testShiroAnnotation(HttpSession session) {
        session.setAttribute("key","testShiroSession");
        shiroService.testMethod();
        return "redirect:/list.jsp";
    }

    @RequestMapping("/login")
    public String login(String username, String password) {
        Subject current = SecurityUtils.getSubject();
        if (!current.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                current.login(token);
            } catch (AuthenticationException e) {
                System.out.println("登录失败："+e.getMessage());
            }
        }
        return "redirect:/list.jsp";
    }
}
