package com.blue.thrift.tst;

/**
 * Created by zhouzhishuai on 2017/5/11.
 */
public class TestBean {

    public int e = 3;
    public int f;
    private String s;



    public static void main(String[] args){
        double a1 = 0.1;
        double da = 3;
        double aa = 3*0.1;
        System.out.print(a1+aa+"aa .. \n");

        System.out.print(3*0.1);
        System.out.print(3*0.1==0.3);


        TestBean.builder()
                .setE(1)
                .setF(2)
                .setS("");

    }

    public static TestBean builder(){
        return new TestBean();
    }

    public int getE() {
        return e;
    }

    public TestBean setE(int e) {
        this.e = e;
        return this;
    }

    public int getF() {
        return f;
    }

    public TestBean setF(int f) {
        this.f = f;
        return this;
    }

    public String getS() {
        return s;
    }

    public TestBean setS(String s) {
        this.s = s;
        return this;
    }
}
