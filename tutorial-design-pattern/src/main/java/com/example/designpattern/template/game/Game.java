package com.example.designpattern.template.game;

/**
 * @Description
 * @Author cph
 * @Date 2020/3/28
 */
public abstract class Game {

    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}
