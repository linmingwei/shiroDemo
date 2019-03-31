package com.demo.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ldd
 * @desc
 * @create 2019-03-30 21:02
 **/
//@Service
public class ShiroService {
    @RequiresRoles({"admin"})
    public void testMethod() {
        System.out.println("now time:"+new Date());
        Session session = SecurityUtils.getSubject().getSession();
        System.out.println(session.getAttribute("key"));
    }
}
