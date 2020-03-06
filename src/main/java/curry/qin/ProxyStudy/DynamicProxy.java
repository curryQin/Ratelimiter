package curry.qin.ProxyStudy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.ProxyStudy
 * @date 2020/3/6 10:02
 * @Copyright © 2019-2020 yamibuy
 */
public class DynamicProxy<T> {

    //注入目标真正的实现类
    private T target;
    public DynamicProxy(T target){
        this.target = target;
    };
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理前执行操作");
                Object obj = method.invoke(target,args);
                System.out.println("动态代理后执行操作");
                return obj;
            }
        });
    }
}
