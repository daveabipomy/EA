package edu.mum.cs544;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LogAspect {

//    -- A --
//    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(..))")
//    public void log(JoinPoint joinpoint) {
//        System.out.println(new Date() + " method= "+ joinpoint.getSignature().getName() );
//    }
//    -- B --
//    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(..)) && args(email, message)")
//    public void log(JoinPoint joinpoint, String email, String message) {
//        System.out.println(new Date() + " method= "+ joinpoint.getSignature().getName() + " email address= "+ email + " message= " + message);
//        }

    //    -- C --
    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(..)) && args(email, message)")
    public void log(JoinPoint joinpoint, String email, String message) {
        System.out.println(new Date() + " method= "+ joinpoint.getSignature().getName() + " email address= "+ email + " message= " + message);
        IEmailSender emailSender = (IEmailSender) joinpoint.getTarget();
        System.out.println("outgoing mail server = "+emailSender.getOutgoingMailServer());
    }
}
