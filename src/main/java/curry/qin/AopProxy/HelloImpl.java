package curry.qin.AopProxy;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.AopProxy
 * @date 2020/3/4 9:59
 * @Copyright © 2019-2020 yamibuy
 */
public class HelloImpl implements IHello {
    @Override
    public void sayHello(String name) {
        System.out.println("执行say Hello");
    }
}
