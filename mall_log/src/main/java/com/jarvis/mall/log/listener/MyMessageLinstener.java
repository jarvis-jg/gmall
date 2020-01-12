package com.jarvis.mall.log.listener;

import com.jarvis.mall.log.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * gmall : com.jarvis.mall.log.listener
 *
 * @author jarvis
 * @create 2020-01-12 17:23
 */
public class MyMessageLinstener implements MessageListener {

    @Autowired
    IndexMapper indexMapper;

    @Override
    public void onMessage(Message message) {

        //1、判断是什么消息
        TextMessage textMessage = (TextMessage) message;
        try {
            String text = textMessage.getText();
            //2、根据消息内容执行对应任务
            indexMapper.log(text);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
