package com.away.designpattern.adapter.v1;

/**
 * 对象适配器模式
 * @author away
 * @date 2022/7/31
 */
public class AdapterTest1 {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.output5v();
    }
}

/**
 * 适配前
 */
class Adaptee{
    int output220v(){
        return 220;
    }
}

/**
 * 目标接口
 * 转为5v的方法
 */
interface Target{
    int output5v();
}

/**
 * 适配器：目标接口的具体适配
 * 实现方法（对象适配器 构造值并实现转换）
 */
class Adapter implements Target {
    private Adaptee adaptee;
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        // 拿到220v
        int i = adaptee.output220v();
        // TODO 转化
        System.out.println(String.format("原始电压：%d v  ->  输出电压：%d v", i, 5));
        return 5;
    }
}