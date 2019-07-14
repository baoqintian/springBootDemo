package com.example.demo.serviceImpl;

import com.example.demo.dao.Book;
import com.example.demo.service.BookService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl  implements BookService {

    /**
     * 监听消息队列
     * @param book
     */
    @Override
    @RabbitListener(queues = "hello")
    public void receive(Book book) {
         System.out.println("接受：" + book);
    }
}

