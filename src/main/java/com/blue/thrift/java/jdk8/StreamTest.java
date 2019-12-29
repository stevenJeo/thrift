package com.blue.thrift.java.jdk8;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by zhouzhishuai on 2017/7/20.
 */
public class StreamTest {


    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        list.add("123456");
//        list.add("123456");
//
//        System.out.print(list.stream().filter(p -> p.equals("222")).findFirst());
//
//        List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
//        System.out.println("sum is:" + nums.stream().filter(num -> num != null)
//                .distinct()
//                .mapToInt(num -> num * 2)
//                .peek(System.out::println)
//                .skip(2)
//                .limit(4)
//                .sum());

//abcabc new fixed


        //将集合中数据分组
//        etLParamList.stream().collect(groupingBy(StatisticCheckETLParam::getShopCode,
//                averagingInt(StatisticShopOperatorStocktakingData::getLittleProductNum)));


        List<TestBean> listTest = initList();

//        List<Integer> wl = listTest.stream().map(TestBean::getNum).collect(Collectors.toList());
        Optional<String> w = listTest.stream().map(TestBean::getName).reduce((sum, it) -> sum + it);


        int s = listTest.stream().mapToInt(TestBean::getNum).sum();//转化为int的流

//        int w = wl.stream().reduce(0, (sum, it) -> sum + it);

//        .reduce(2,(sum, item) -> sum + item);

        System.out.println("s="+s+", w=" + w);

        int value = Stream.of(1, 2, 3, 4).reduce(100, (sum, item) -> sum + item);
        System.out.println(value);
//        Assert.assertSame(value, 110);

//        listTest.stream().reduce(::sum).orElse(null);


    }


    public static List<TestBean> initList() {
        List<TestBean> listTest = Lists.newArrayList();
//        TestBean b1 = new TestBean();
//        b1.setName("b1");
//        b1.setNum(1);
//        listTest.add(b1);
//
//        TestBean b2 = new TestBean();
//        b2.setName("b2");
//        b2.setNum(6);
//        listTest.add(b2);
//
//        TestBean b3 = new TestBean();
//        b3.setName("b3");
//        b3.setNum(7);
//        listTest.add(b3);
//
//        TestBean b4 = new TestBean();
//        b4.setName("b4");
//        b4.setNum(2);
//        listTest.add(b4);
//
//        TestBean b5 = new TestBean();
//        b5.setName("b5");
//        b5.setNum(5);
//        listTest.add(b5);

        return listTest;
    }

}
