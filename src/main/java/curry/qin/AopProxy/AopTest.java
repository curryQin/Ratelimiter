package curry.qin.AopProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.AopProxy
 * @date 2020/3/4 9:59
 * @Copyright © 2019-2020 yamibuy
 */
public class AopTest {
    public static void main(String[] args)  {
        IHello target = new HelloImpl();
        //真正执行操作的类
        InvocationHandler helloHandler = new HelloInvocationHandler(target);
        //产生代理增强类
        IHello helloProxy = (IHello) Proxy.newProxyInstance(helloHandler.getClass().getClassLoader(), target.getClass().getInterfaces(), helloHandler);
        //代理增强类执行
        helloProxy.sayHello("hello");
    }
}
