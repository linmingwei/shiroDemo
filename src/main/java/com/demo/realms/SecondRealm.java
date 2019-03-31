package com.demo.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * @author ldd
 * @desc
 * @create 2019-03-30 10:45
 **/
public class SecondRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("[SECOND]    doGetAuthenticationInfo");
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
            credentials ="2bcd8769a887c2cdacb152ea44ecc2621bc66d4a";
        } else if ("admin".equals(username)) {
            credentials = "c30713493ec7125e9e54db9e09b02bbc7bfb0d7d";
        }
//        String credentials = "asdfgh";
        String realName = getName();
        SimpleAuthenticationInfo info = null;
        info = new SimpleAuthenticationInfo(username,credentials,salt,realName);
        return info;
    }

    public static void main(String[] args) {
        String hashAlgorithName = "SHA1";
        ByteSource salt = ByteSource.Util.bytes("user");
        int hashIterations = 1024;
        String credentials = "asdfgh";
        SimpleHash result = new SimpleHash(hashAlgorithName, credentials, salt, hashIterations);
        System.out.println(result);
    }
}
