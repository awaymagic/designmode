package com.away.designpattern.adapter.v2;


/**
 * 类的适配器模式
 * 区别：类的适配器模式不会污染接口
 * @author away
 * @date 2022/7/31
 */
public class AdapterTest2 {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.output5v();
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
 * 类的适配器模式
 */
class Adapter extends Adaptee implements Target{
    @Override
    public int output5v() {
        // 拿到220v
        int i = output220v();
        // TODO 转化
        System.out.println(String.format("原始电压：%d v  ->  输出电压：%d v", i, 5));
        return 5;
    }
}
