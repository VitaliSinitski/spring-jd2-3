package org.spring;

public class EmailSender implements ISender {
    @Override
    public void send(String message) {
        System.out.println("EmailSender " + message);
    }
}
