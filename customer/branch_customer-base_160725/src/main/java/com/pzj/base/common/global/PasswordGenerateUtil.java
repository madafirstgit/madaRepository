package com.pzj.base.common.global;

import com.pzj.base.common.security.MD5Utils;

public class PasswordGenerateUtil {

    public static String generatePassword(Long id, String loginName,
            String passwd) {
        if (id == null || loginName == null || passwd == null)
            return null;

        StringBuffer sb = new StringBuffer();
        loginName = loginName.toLowerCase();
        sb.append(loginName.substring(0, 1)).append(passwd.substring(0, 2))
                .append(loginName.substring(1, 2))
                .append(passwd.substring(2, 6)).append(id)
                .append(loginName.substring(2, 4))
                .append(passwd.substring(6, passwd.length()))
                .append(loginName.substring(4, loginName.length()));
        String password = MD5Utils.getMD5DigestHex(sb.toString());
        return password;
    }
    
    public static String generatePasswordTwice(Long id, String loginName,
            String passwd) {
        String pwd = generatePassword(id,loginName,passwd);
        return generatePassword(id,loginName,pwd);
    }
    
    public static void main(String[] args) {
    	
        System.out.println(generatePassword(2216619736565867L,"dongchf","12345678"));
        
        System.out.println(generatePasswordTwice(2216619736565865l,"dongchunfu","123456"));
        
    }
}
