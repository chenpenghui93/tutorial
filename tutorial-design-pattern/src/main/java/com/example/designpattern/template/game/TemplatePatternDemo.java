package com.example.designpattern.template.game;

/**
 * @Description
 * @Author cph
 * @Date 2020/3/28
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
