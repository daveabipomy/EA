package edu.mum.main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

import javax.persistence.EntityManager;

public class Main {

    public static void main(String[] args) throws ParseException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userServiceImpl");

        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2010");
        User user=new User("Abeba","yimer","abeba.ibrahim@gmail.com", date1);
        userService.save(user);

        User user1=userService.findByEmail("abeba.ibrahim@gmail.com");

        System.out.println("************** USER **************");
        System.out.println("User Name: " +user1.getFirstName()+" "+user1.getLastName());

        user1.setLastName("Ibrahim");
        User user2=userService.update(user1);

        System.out.println("************** USER **************");
        System.out.println("User Name: " +user2.getFirstName()+" "+user2.getLastName());

        userService.clear();

        user1.setLastName("David...");
        User newUser2 = userService.update(user1);

    }
  
 }