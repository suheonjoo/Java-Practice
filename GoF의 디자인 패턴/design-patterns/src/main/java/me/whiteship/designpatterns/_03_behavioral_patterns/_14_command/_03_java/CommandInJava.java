package me.whiteship.designpatterns._03_behavioral_patterns._14_command._03_java;

import me.whiteship.designpatterns._03_behavioral_patterns._14_command._01_before.Game;
import me.whiteship.designpatterns._03_behavioral_patterns._14_command._01_before.Light;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommandInJava {

    public static void main(String[] args) {
        Light light = new Light();
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(light::on);//여기 람다 안에 new Runnable 이 있고 Runnable 자체를 Command 로 보는 것임
        executorService.submit(game::start);
        executorService.submit(game::end);
        executorService.submit(light::off);
        executorService.shutdown();
    }
}













