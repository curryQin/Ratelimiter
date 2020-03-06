package curry.qin.SingleTon;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.SingleTon
 * @date 2020/3/6 15:42
 * @Copyright © 2019-2020 yamibuy
 * 静态内部类实现单例模式
 */
public class SingleTon {
    private static Object singleTonInstance;

    /***
     * 构造方法私有化，保证外部无法new对象
     */
    private SingleTon() {
    }

    /***
     * 外部在初始化SingleTon的时候，也不会调内部类初始化，只有当执行getInstance的方法的时候才会初始化静态内部类
     * @return
     */
    public static Object getInstance(){
        if(singleTonInstance == null){
            return SingleTonHolder.singleTonInstance;
        }
        return singleTonInstance;
    }

    /***
     * 静态内部类，因为是静态的只会初始化一次
     */
    private static class SingleTonHolder{
        private static final Object singleTonInstance = new Object();
    }
}
