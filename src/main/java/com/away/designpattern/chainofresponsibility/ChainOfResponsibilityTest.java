package com.away.designpattern.chainofresponsibility;

/**
 * 《责任链模式》
 * 场景：一个请求的处理需要多个对象当中的一个或几个协助处理。
 * 优点：1 请求的发送者和接受者解耦
 *      2 可以控制执行顺序
 *      3 符合开闭原则和单一指责
 *
 * @author away
 * @date 2022/8/7
 */
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {

        Request request = new Request.RequestBuilder().frequentOk(true).loggedOn(true).build();
        RequestFrequentHandler requestFrequentHandler = new RequestFrequentHandler(new LoggingHandler(null));
        if (requestFrequentHandler.process(request)) {
            System.out.println("正常业务处理");
        } else {
            System.out.println("访问异常");
        }

    }
}

class Request{
    private boolean loggedOn;
    private boolean frequentOk;
    private boolean isPermits;
    private boolean containsSensitiveWords;
    private String requestBody;

    public Request(boolean loggedOn, boolean frequentOk, boolean isPermits, boolean containsSensitiveWords) {
        this.loggedOn = loggedOn;
        this.frequentOk = frequentOk;
        this.isPermits = isPermits;
        this.containsSensitiveWords = containsSensitiveWords;
    }

    static final class RequestBuilder{
        private boolean loggedOn;
        private boolean frequentOk;
        private boolean isPermits;
        private boolean containsSensitiveWords;
        RequestBuilder loggedOn(boolean loggedOn) {
            this.loggedOn = loggedOn;
            return this;
        }
        RequestBuilder frequentOk(boolean frequentOk) {
            this.frequentOk = frequentOk;
            return this;
        }
        RequestBuilder isPermits(boolean isPermits) {
            this.isPermits = isPermits;
            return this;
        }
        RequestBuilder containsSensitiveWords(boolean containsSensitiveWords) {
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }
        Request build() {
            return new Request(loggedOn, frequentOk, isPermits, containsSensitiveWords);
        }
    }

    public boolean isLoggedOn() {
        return loggedOn;
    }

    public boolean isFrequentOk() {
        return frequentOk;
    }

    public boolean isPermits() {
        return isPermits;
    }

    public boolean isContainsSensitiveWords() {
        return containsSensitiveWords;
    }
}

/**
 * handler抽象类
 */
abstract class Handler{
    /**
     * 获取下一个
     */
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    /**
     * 执行方法
     * @param request   请求
     * @return          结果 true/false
     */
    abstract boolean process(Request request);
}

/**
 * 频率访问Handler
 */
class RequestFrequentHandler extends Handler {

    public RequestFrequentHandler(Handler next) {
        // 为空表示可访问到最后
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("访问频率控制...");

        if (request.isFrequentOk()) {
            // 可以获取下一步
            Handler next = getNext();
            if (null == next) {
                // 所有的都已处理完
                return true;
            }
            if (!next.process(request)) {
                // 处理结果失败
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}

/**
 * 登陆handler
 */
class LoggingHandler extends Handler {
    public LoggingHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("登陆访问...");
        if (request.isLoggedOn()) {
            Handler next = getNext();
            if (next == next) {
                return true;
            }
            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
