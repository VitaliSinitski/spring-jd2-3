package org.spring;

public class TelegramSender implements ISender {
    private int count = 0;

    @Override
    public void send(String message) {
        System.out.println("TelegramSender " + message);
        System.out.println(count);
        count++;
    }
}
