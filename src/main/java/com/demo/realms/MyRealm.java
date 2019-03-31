package com.demo.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;

/**
 * @author ldd
 * @desc
 * @create 2019-03-30 10:45
 **/
public class MyRealm extends AuthorizingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("[FIRST]    doGetAuthenticationInfo");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        if ("unknown".equals(username)) {
            System.out.println("用户名不存在");
            throw new UnknownAccountException("用户名不存在！");
        }
        if ("monster".equals(username)) {
            System.out.println("用户名被锁定");
            throw new LockedAccountException("用户被锁定!");
        }
        String principle = username;
        String credentials = null;
        ByteSource salt = ByteSource.Util.bytes(username);
        if ("user".equals(username)) {
            credentials ="5164884438285847a48d98419d9baf22";
        } else if ("admin".equals(username)) {
            credentials = "025f3bdcdb8a8121a3d529d5f461d2b4";
        }
//        String credentials = "asdfgh";
        String realName = getName();
        SimpleAuthenticationInfo info = null;
        info = new SimpleAuthenticationInfo(principle,credentials,salt,realName);
        return info;
    }

    public static void main(String[] args) {
        String hashAlgorithName = "MD5";
        ByteSource salt = ByteSource.Util.bytes("admin");
        int hashIterations = 1024;
        String credentials = "asdfgh";
        SimpleHash result = new SimpleHash(hashAlgorithName, credentials, salt, hashIterations);
        System.out.println(result);
    }

//    授权被shiro 回调的方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("doGetAuthorizationInfo .......");
        Object principal = principals.getPrimaryPrincipal();
        HashSet<String> roles = new HashSet<>();
        roles.add("user");
        if ("admin".equals(principal)) {
            roles.add("admin");
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);


        return info;
    }
}
