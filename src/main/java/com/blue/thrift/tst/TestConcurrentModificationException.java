package com.blue.thrift.tst;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhouzhishuai on 2017/4/28.
 */
public class TestConcurrentModificationException {

    public static void main(String[] args){

        List<String> ls = new ArrayList<String>();
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("4");
        ls.add("5");

        Iterator<String> it = ls.iterator();
        List<String> deleteList = new ArrayList<String>();
        while (it.hasNext()){
            String v = it.next();
            if(v.equals("3")||v.equals("5")){
//                ls.remove(v);
                deleteList.add(v);
//                it.remove();//用迭代器删除
            }
        }

        System.out.print(deleteList);
        ls.removeAll(deleteList);//将需要删除的节点
        System.out.print(ls);




        //subList 只是subList生成的子列表只是原列表的一个视图而已，如果我们操作子列表它产生的作用都会在原列表上面表现，修改原列表就会报错concurrentModifyexcption

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        //通过构造函数新建一个包含list1的列表 list2
        List<Integer> list2 = new ArrayList<Integer>(list1);

        //通过subList生成一个与list1一样的列表 list3
        List<Integer> list3 = list1.subList(0, list1.size());

        //修改list3
        list3.add(99);
        list1.add(3);

        //list设置为只读
//        list1 = Collections.unmodifiableList(list1);
//        list1.add(9);


//        list1.subList(3, 5).clear();

//        System.out.println("list1 == list2：" + list1.equals(list2)+"\n");
//        System.out.println("list1 == list3：" + list1.equals(list3)+"\n");

        System.out.println("list1 ==：" + list1+"\n");
        System.out.println("list2 ==：" + list2+"\n");
        System.out.println("list3 ==：" + list3+"\n");


    }



}
