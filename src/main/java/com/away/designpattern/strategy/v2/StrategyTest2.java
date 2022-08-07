package com.away.designpattern.strategy.v2;


/**
 * 《策略模式》
 * 应用：JDK 中 Comparator
 *
 * @author away
 * @date 2022/8/7
 */
public class StrategyTest2 {
    public static void main(String[] args) {
        Zombie zombie = new NormalZombie();
        zombie.display();
        zombie.attack();
        zombie.move();

        System.out.println("====================");

        Zombie flagZombie = new FlagZombie();
        // 切换攻击方式
        flagZombie.setAttackable(new HitAttack());
        flagZombie.display();
        flagZombie.attack();
        flagZombie.move();
    }
}

interface Moveable {
    void move();
}

interface Attackable {
    void attack();
}

abstract class Zombie{
    abstract public void display();
    Moveable moveable;
    Attackable attackable;
    abstract void move();
    abstract void attack();

    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public Attackable getAttackable() {
        return attackable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }
}

/**
 * 自定义移动方式:一步步移动
 */
class StepByStepMove implements Moveable {
    @Override
    public void move() {
        System.out.println("一步步移动...");
    }
}

/**
 * 自定义攻击方式:咬...
 */
class BiteAttack implements Attackable{
    @Override
    public void attack() {
        System.out.println("咬...");
    }
}
/**
 * 自定义攻击方式:打...
 */
class HitAttack implements Attackable{
    @Override
    public void attack() {
        System.out.println("打...");
    }
}

/**
 * 普通僵尸
 */
class NormalZombie extends Zombie {

    public NormalZombie() {
        super(new StepByStepMove(), new BiteAttack());
    }

    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是普通僵尸...");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}

/**
 * 旗手僵尸
 */
class FlagZombie extends Zombie {
    public FlagZombie() {
        super(new StepByStepMove(), new BiteAttack());
    }

    public FlagZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("旗手僵尸...");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}