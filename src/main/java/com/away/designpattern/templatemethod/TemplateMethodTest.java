package com.away.designpattern.templatemethod;

/**
 * 《模版方法模式》
 * 定义：定义一个操作的算法骨架，而将一些步骤延迟到子类中。Template Method 使得子类可以不改变一个算法的结构即可重定义某些特定步骤。
 * 应用：
 * @see         javax.servlet.http.HttpServlet
 * @see         org.springframework.web.servlet.mvc.AbstractController
 *

 * @author away
 * @date 2022/8/7
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        AbstractClass subClass1 = new SubClass1();
        subClass1.operation();

        System.out.println("-------------");

        AbstractClass subClass2 = new SubClass2();
        subClass2.operation();
    }
}

abstract class AbstractClass{
    public void operation() {
        // open
        System.out.println("pre ...");
        System.out.println("step1 ...");
        System.out.println("step2 ...");

        // 用户/子类扩展点
        templateMethod();

        // close
        System.out.println("close ...");
    }

    abstract protected void templateMethod();
}

class SubClass1 extends AbstractClass {

    @Override
    protected void templateMethod() {
        System.out.println("SubClass1 executed ...");
    }
}

class SubClass2 extends AbstractClass {

    @Override
    protected void templateMethod() {
        System.out.println("SubClass2 executed ...");
    }
}