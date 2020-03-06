package curry.qin.ProxyStudy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.ProxyStudy
 * @date 2020/3/4 9:59
 * @Copyright © 2019-2020 yamibuy
 */
public class ProxyTest {
    public static void main(String[] args)  {

        //动态代理实际实现invocationhandler接口重写invoke方法增加代理前操作和代理后操作
        //修改了接口只需要修改目标类，代理类不需要修改，因为底层使用反射进行操作的
        //类的数量不会增加，而且是懒加载
        IHello target2 = new HelloImpl();
        IHello helloProxy2 = (IHello)new DynamicProxy(target2).getProxyInstance();
        helloProxy2.sayHello("123");

        //静态代理需要代理和目标类都实现同一个接口，都重写sayhello方法，代理类还是注入目标类操作
        //太死板，如果修改了接口，代理类和目标类都需要修改
        //类的个数会大大增加
        HelloStaticProxy staticProxy = new HelloStaticProxy(target2);
        staticProxy.sayHello("123");
    }
}
