package com.jarvis.gmall.test;

/**
 * gmall : com.jarvis.gmall.test
 *
 * @author jarvis
 * @create 2019-12-15 22:00
 */
public class Test {

    public static void main(String[] args) {
        TestServiceImplService service = new TestServiceImplService();

        TestServiceImpl testServiceImplPort = service.getTestServiceImplPort();

        String ping = testServiceImplPort.ping("你好");

        System.out.println(ping);
    }
}
