package curry.qin.AopProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.AopProxy
 * @date 2020/3/4 10:34
 * @Copyright © 2019-2020 yamibuy
 */
public class HelloInvocationHandler implements InvocationHandler {
    private Object target;

    public HelloInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前操作。。");
        method.invoke(target,args);
        System.out.println("代理后操作。。");
        return null;
    }
}


