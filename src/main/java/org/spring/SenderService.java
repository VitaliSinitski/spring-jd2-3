package org.spring;

import lombok.Setter;

@Setter
public class SenderService {
    private ISender sender;

    private String name;
    private Double pi;

    public SenderService() {
    }

    public SenderService(ISender sender) {
        this.sender = sender;
    }

    public void sendMessage(String message) {
        sender.send(message);
        System.out.println(name);
        System.out.println(pi);
    }

    public void setSender(ISender sender) {
        this.sender = sender;
    }
}
