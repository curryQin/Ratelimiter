package curry.qin.ProxyStudy;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.ProxyStudy
 * @date 2020/3/6 10:26
 * @Copyright © 2019-2020 yamibuy
 */
public class HelloStaticProxy implements IHello {
    private IHello iHello;

    public HelloStaticProxy(IHello iHello) {
        this.iHello = iHello;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("静态代理，代理前操作");
        iHello.sayHello(name);
        System.out.println("静态代理，代理后操作");
    }
}
