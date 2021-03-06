package com.demo.factory;

import java.util.LinkedHashMap;

/**
 * @author ldd
 * @desc
 * @create 2019-03-30 21:28
 **/
public class FilterChainDefinitionMapBuilder {
    public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/login.jsp","anon");
        map.put("/shiro/login","anon");
        map.put("/shiro/logout","logout");
        map.put("/user.jsp","authc,roles[user]");
        map.put("/admin.jsp","authc,roles[admin]");
        map.put("/list.jsp","user");
        map.put("/**","authc");
        return map;
    }
}
