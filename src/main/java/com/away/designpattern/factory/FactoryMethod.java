package com.away.designpattern.factory;

/**
 * @author away
 * @date 2023/2/14
 */
public class FactoryMethod {
    public static void main(String[] args) {
        // Application application = new ConcreteProductA();
        Application application = new ConcreteProductA1();
        Product product = application.getObject();
        product.method1();
    }
}

    /**
     * 稳定接口
     */
    interface Product{
        void method1();
    }

    /**
     * 具体实现
     */
    class ProductA implements Product {
        @Override
        public void method1() {
            System.out.println("ProductA.method1 executed.");
        }
    }

    class ProductA1 implements Product {
        @Override
        public void method1() {
            System.out.println("ProductA1.method1 executed.");
        }
    }

    abstract class Application {
        /** 变化的 */
        abstract Product createProduct();
         Product getObject() {
             Product product = createProduct();
             // ... 业务逻辑
             // ...
             return product;
         }
    }

    /**
     * 工厂方法具体实现类
     */
    class ConcreteProductA extends Application {
        @Override
        Product createProduct() {
            return new ProductA();
        }
    }

    class ConcreteProductA1 extends Application {
        @Override
        Product createProduct() {
            return new ProductA1();
        }
    }
