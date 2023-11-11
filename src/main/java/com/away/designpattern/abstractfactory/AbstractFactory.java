package com.away.designpattern.abstractfactory;

/**
 * 抽象工厂模式
 *
 * @author wei.guo
 * @date 2023/2/14
 */
public class AbstractFactory {
}

interface IConnection {
    void connect();
}
interface ICommand {
    void command();
}

interface IDatabaseUtils {
    IConnection getConnection();
    ICommand getCommand();
}
