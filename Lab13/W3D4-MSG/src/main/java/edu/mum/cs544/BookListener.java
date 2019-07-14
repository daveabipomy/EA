package edu.mum.cs544;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

@Component
@RabbitListener(queues = "book")
public class BookListener {

    @Autowired
    private BookService bookService;

    @RabbitHandler
    public void add(Book book){
        try{
            if(bookService.get(book.getId())==null){
                bookService.add(book);
            }else {
                bookService.update(book);
            }
        }catch (ConstraintViolationException e){
            System.out.println(e);
        }catch (NoSuchElementException el){
            bookService.add(book);
        }
    }

    @RabbitHandler
    public  void delete(Integer id){
        bookService.delete(id);
    }

}
