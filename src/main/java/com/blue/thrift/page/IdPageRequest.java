package com.blue.thrift.page;


import java.io.Serializable;

/**
 * Created by zhishuai.zhou on 2018/5/28.
 */
public class IdPageRequest {
    private Page page = new Page(15, 1);

    private int curId;


    public int getIdOffset() {
//        curId;
        return 0;
    }


    public static class Page implements Serializable {

        int pageSize = 15;

        int pageNo = 1;

        public Page(int pageSize, int pageNo) {
            this.pageSize = pageSize;
            this.pageNo = pageNo;
        }


    }
}
