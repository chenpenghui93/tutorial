package com.example.designpattern.flyweight.ticket;

/**
 * 享元模式
 *
 * @author chenpenghui
 * @date 2021-3-27
 */
public class Test {

    public static void main(String[] args) {
        ITicket ticket = TicketFactory.queryTicket("TAO", "BJW");
        ticket.showInfo("1");

        ticket = TicketFactory.queryTicket("TAO", "SJW");
        ticket.showInfo("2");

        ticket = TicketFactory.queryTicket("TAO", "SJW");
        ticket.showInfo("3");
    }
}
