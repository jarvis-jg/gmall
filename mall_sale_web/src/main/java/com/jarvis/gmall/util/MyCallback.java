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
        //客户端传用户名，密码
        wsp.setIdentifier("CXF");
        wsp.setPassword("123");
    }
}
