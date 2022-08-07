package com.away.designpattern.strategy.v1;

/**
 * 《策略模式》
 * 定义：定义了算法族，分别封装起来，让他们之间可以相互替换，此模式的变化独立于算法的使用者。
 *
 *
 * @author away
 * @date 2022/8/7
 */
public class StrategyTest {
    public static void main(String[] args) {
        NormalZombie normalZombie = new NormalZombie();
        FlagZombie flagZombie = new FlagZombie();

        normalZombie.display();
        normalZombie.attack();
        normalZombie.move();

        System.out.println("===================");

        flagZombie.display();
        flagZombie.attack();
        flagZombie.move();

    }
}

abstract class AbstractZombie {
    public abstract void display();

    public void attack() {
        System.out.println("咬...");
    }

    public void move() {
        System.out.println("一步步移动...");
    }
}

class NormalZombie extends AbstractZombie {

    @Override
    public void display() {
        System.out.println("我是普通僵尸...");
    }
}
class FlagZombie extends AbstractZombie {

    @Override
    public void display() {
        System.out.println("我是旗手僵尸...");
    }
}

class BigHeadZombie extends AbstractZombie {
    @Override
    public void display() {
        System.out.println("我是大头僵尸...");
    }

    @Override
    public void attack() {
        // ...
        System.out.println("头撞...");
    }
}

class XxxZombie extends BigHeadZombie {

    @Override
    public void move() {
        super.move();
    }
}
