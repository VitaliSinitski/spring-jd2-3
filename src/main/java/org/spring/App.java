package org.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

//        SenderService  senderService = context.getBean("senderService", SenderService.class);
//        senderService.sendMessage("sendMessage");

        Person person = context.getBean("person", Person.class);
        person.perform();



/*
        ISender sender = new EmailSender();
        SenderService senderService = new SenderService(sender);
        senderService.sendMessage("Send message");
*/
    }
}
