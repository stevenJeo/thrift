package com.blue.thrift.aop;

/**
 * Created by zhishuai.zhou on 2019/12/27.
 */
public class Player implements Play {

    private String name;


    public Player(String name) {
        this.name = name;
    }


    @Override
    public String playBall(String ball) {
        System.out.println(name + "play ..." + ball);
        return null;
    }

    @Override
    public void playHappy() {
        System.out.println(name + "..playHappy");
    }

//    @Override
//    public void run() {
//        System.out.println(name + "..run");
//    }
}
