package com.blue.thrift.java.collection;

import com.alibaba.fastjson.JSON;

/**
 * Created by zs on 2020/1/5.
 */
public class TBScheduleTest {


    public static int[] assignTaskNumber(int serverNum, int taskItemNum, int maxNumOfOneServer) {

        int[] taskNums = new int[serverNum];
        int numOfSingle = taskItemNum / serverNum;
        int otherNum = taskItemNum % serverNum;

        //20150323 删除, 任务分片保证分配到所有的线程组数上。 开始
//    if (maxNumOfOneServer >0 && numOfSingle >= maxNumOfOneServer) {
//      numOfSingle = maxNumOfOneServer;
//      otherNum = 0;
//    }
        //20150323 删除, 任务分片保证分配到所有的线程组数上。 结束
        for (int i = 0; i < taskNums.length; i++) {
            if (i < otherNum) {
                taskNums[i] = numOfSingle + 1;
            } else {
                taskNums[i] = numOfSingle;
            }
        }
        return taskNums;
    }


    public static void main(String[] ss) {
        int serverNum = 3;
        int taskItemNum = 10;
        int maxNumOfOneServer = 1;

        int[] item = assignTaskNumber(serverNum, taskItemNum, maxNumOfOneServer);

        System.out.println(JSON.toJSONString(item));

    }


}
