package com.away.designpattern.facade;

/**
 * 《门面模式/外观模式》
 * 定义：为子系统中的一组接口提供一个一致的接口，Facade 模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
 * 应用场景： 1 当需要使用复杂子系统的有限但直接的接口时，请使用 Facade 模式。
 *          2 当想要将子系统组织成层时，请使用 Facade 模式。
 * 优点：简化客户端的使用。
 * 应用：经典的服务分层 controller -> service
 *      tomcat 中的 RequestFacade
 *
 * @author away
 * @date 2022/8/7
 */
public class FacadeTest {
    public static void main(String[] args) {
        Client1 client1 = new Client1();
        client1.doSomething1();

    }
}

/**
 * 客户端1
 */
class Client1 {
    Facade facade = new Facade();

    public void doSomething1() {
        facade.doSomethingFacade();
    }
}

/**
 * 客户端2
 */
class Client2 {
    Facade facade = new Facade();

    public void doSomething2() {
        facade.doSomethingFacade();
    }
}

/**
 * 门面
 */
class Facade {
    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();
    public void doSomethingFacade() {
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}

/**
 * 子系统1
 */
class SubSystem1 {
    void method1() {
        System.out.println("SubSystem1.method1 executed... ");
    }
}
/**
 * 子系统2
 */
class SubSystem2 {
    void method2() {
        System.out.println("SubSystem1.method2 executed... ");
    }
}
/**
 * 子系统3
 */
class SubSystem3 {
    void method3() {
        System.out.println("SubSystem1.method3 executed... ");
    }
}
