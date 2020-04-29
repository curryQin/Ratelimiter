package curry.qin.ThreadStudy;


import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private int n;
    private ReentrantLock lock = new ReentrantLock(true);
    public FooBar(int n) {
        this.n = n;
    }
    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
             // printFoo.run() outputs "foo". Do not change or remove this line.
             printFoo.run();
             lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printBar.run();
            lock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}