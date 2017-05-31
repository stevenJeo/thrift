package com.blue.thrift.bench;

/**
 * Created by zhouzhishuai on 2017/4/20.
 */
public class DeadLockTest {
    public static void main(String[] args){
        Resource r1 = new Resource();
        Resource r2 = new Resource();

        LockThrea1 t1 = new LockThrea1(r1, r2);
        t1.setName("deadLockThread-1");
        LockThrea2 t2 = new LockThrea2(r1, r2);
        t2.setName("deadLockThread-2");

        t1.start();
        t2.start();
    }

}
class Resource{
    private int i;

    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
}
class LockThrea1 extends Thread{
    private Resource r1, r2;
    LockThrea1(Resource r1, Resource r2){
        this.r1 = r1;
        this.r2 = r2;
    }
    @Override
    public void run(){
        int j = 0;
        while (true){
            synchronized (r1){
                System.out.print("The first thread got r1's lock " + j +"\n");
                synchronized (r2){
                    System.out.println("The first thread got r2's lock  " + j +"\n");
                }
            }
            j++;
        }
    }
}
class LockThrea2 extends Thread{
    private Resource r1, r2;
    LockThrea2(Resource r1, Resource r2){
        this.r1 = r1;
        this.r2 = r2;
    }
    @Override
    public void run(){
        int j = 0;
        while (true){
            synchronized (r2){
                System.out.print("The second thread got r2's lock " + j +"\n");
                synchronized (r1){
                    System.out.println("The second thread got r1's lock  " + j +"\n");
                }
            }
            j++;
        }
    }
}