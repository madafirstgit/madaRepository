package test;

import com.pzj.base.common.global.PasswordGenerateUtil;
import org.junit.Test;

/**
 * Created by Administrator on 2016-8-5.
 */
public class PasswordTest {

    @Test
    public void genPassword() {
        String password = PasswordGenerateUtil.generatePassword(100003L, "18174305656", "123456");
        System.out.println("password = " + password);
        System.out.println();

    }
}
