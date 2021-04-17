package com.example.designpattern.flyweight.ticket;

import java.util.Random;

/**
 * @author chenpenghui
 * @date 2021-3-27
 */
public class TrainTicket implements ITicket {
    private String from;
    private String to;
    private int price;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showInfo(String bunk) {
        this.price = new Random().nextInt(500);
        System.out.println(String.format("%s->%s %s %s", this.from, this.to, bunk, this.price));
    }
}
