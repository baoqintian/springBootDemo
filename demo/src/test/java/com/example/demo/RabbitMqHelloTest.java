package com.example.demo;

import com.example.demo.dao.Book;
import com.example.demo.rabbitmq.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RabbitMqHelloTest {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    //创建、Exchange、队列、绑定关系
    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * 单播：点对点
     */
    @Test
    public void hello()  {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 1, 2, 3, true));
       rabbitTemplate.convertAndSend("amq.direct","hello",map);
    }

    /**
     * 广播
     */
    @Test
    public void hello2()  {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 1, 2, 3, true));
        rabbitTemplate.convertAndSend("amq.fanout","",map);
    }

    /**
     * 单播：点对点
     */
    @Test
    public void hello3()  {

        rabbitTemplate.convertAndSend("amq.direct","hello",new Book("zhangsan", "红楼梦"));
    }

    @Test
    public void receice () {
       Object o = rabbitTemplate.receiveAndConvert("hello");
        System.out.println("***********************");
       System.out.println(o);
    }

    @Test
    public void createExchange() {
        //创建exchange
//        amqpAdmin.declareExchange(new DirectExchange("AmqpAdmin.exchange"));

        //创建queue
        //amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));

        //创建绑定关系
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue",Binding.DestinationType.QUEUE,"AmqpAdmin.exchange","queue",null));

    }
}



