package com.example.designpattern.flyweight.ticket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenpenghui
 * @date 2021-3-27
 */
public class TicketFactory {

    private static Map<String, ITicket> ticketPool = new ConcurrentHashMap<>();

    public static ITicket queryTicket(String from, String to) {
        String key = from + "->" + to;
        if (ticketPool.containsKey(key)) {
            System.out.println("缓存：" + key);
            return ticketPool.get(key);
        }
        System.out.println("首次查询，创建对象：" + key);
        TrainTicket trainTicket = new TrainTicket(from, to);
        ticketPool.put(key, trainTicket);
        return trainTicket;
    }
}
