package com.away.designpattern.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * 《观察者模式》
 * 定义：定义了对象之间的一对多依赖，让多个观察者对象同时监听同一个主题对象，当主题对象发生变化时，它的所有的依赖者都会收到通知并更新。
 * 优点：1 符合开闭原则
 *      2 可以在运行时建立对象之间的关系（添加/删除观察者）
 * JDK & Spring中的应用：
 * @see     java.util.Observable
 * @see     org.springframework.context.ApplicationListener
 *
 * @author away
 * @date 2022/8/7
 */
public class ObserverTest {
    public static void main(String[] args) {

        Subject subject = new Subject();
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        subject.addObserver(task1);
        subject.addObserver(task2);
        // 测试发布事件
        subject.notifyObserver("=== 发布事件1 ===");

        System.out.println("======= 分隔符 =======");
        // 移除一个观察者进行测试
        subject.removeObserver(task1);
        subject.notifyObserver("=== 发布事件2 ===");

    }
}

class Subject {

    /**
     * 容器
     */
    private List<Observer> container = new LinkedList<>();

    /**
     * add
     * @param observer  具体观察者
     */
    public void addObserver(Observer observer) {
        container.add(observer);
    }

    /**
     * remove
     * @param observer  具体观察者
     */
    public void removeObserver(Observer observer) {
        container.remove(observer);
    }

    /**
     * 通知/发布
     * @param arg  发送给具体观察者的内容
     */
    public void notifyObserver(Object arg) {
        container.forEach(item -> item.update(arg));
    }

}

/**
 * 观察者接口
 */
interface Observer {
    /**
     * 也可以在此添加/删除观察者
     * @param arg 参数
     */
    void update(Object arg);
}

/**
 * 观察者1
 */
class Task1 implements Observer {
    @Override
    public void update(Object object) {
        System.out.println("task1 -> receiver: " + object);
    }
}

/**
 * 观察者2
 */
class Task2 implements Observer {
    @Override
    public void update(Object object) {
        System.out.println("task2 -> receiver: " + object);
    }
}