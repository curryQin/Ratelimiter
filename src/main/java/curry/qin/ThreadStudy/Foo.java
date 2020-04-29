package curry.qin.ThreadStudy;

import java.util.concurrent.CountDownLatch;

class Foo {

    private static CountDownLatch second = new CountDownLatch(1);
    private static CountDownLatch third = new CountDownLatch(1);
    public Foo() {
        
    }

    public static void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            second.countDown();
    }

    public static void second(Runnable printSecond) throws InterruptedException {
            second.await();
            printSecond.run();
            third.countDown();
    }

    public static void third(Runnable printThird) throws InterruptedException {
            printThird.run();
    }

    public static void main(String[] args) {

    }
}