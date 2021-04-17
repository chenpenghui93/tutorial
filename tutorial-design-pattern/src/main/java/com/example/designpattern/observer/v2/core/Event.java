package com.example.designpattern.observer.v2.core;

import java.lang.reflect.Method;

public class Event {
    private Object source;
    private Object target;
    private Method callback;
    private String trigger;
    private long time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public long getTime() {
        return time;
    }

    public Event setTime(long time) {
        this.time = time;
        return this;
    }

    public Object getTarget() {
        return target;
    }

    public Method getCallback() {
        return callback;
    }

    @Override
    public String toString() {
        return "Event{" + "\n" +
                "\tsource=" + source.getClass() + ",\n" +
                "\ttarget=" + target.getClass() + ",\n" +
                "\tcallback=" + callback + ",\n" +
                "\ttrigger='" + trigger + "',\n" +
                "\ttime=" + time + "'\n" +
                '}';
    }
}
