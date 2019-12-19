package com.jarvis.gmall.util;


import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

/**
 * gmall : com.jarvis.gmall.util
 *
 * @author jarvis
 * @create 2019-12-19 21:58
 */
public class MyCallback implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        //配置username和password的代码
        WSPasswordCallback wsp = (WSPasswordCallback) callbacks[0];
        String user = wsp.getIdentifier();

        //这里可以私人定制密码的协议
        String password = "";
        if (user.equals("CXF")){
            password = "123";
        }
        //这里可以私人定制密码的协议
        //将密码回传，框架会去校验与传入的密码是否一致
        wsp.setPassword(password);
    }
}
