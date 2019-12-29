package com.blue.thrift.page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zs on 2018/5/28.
 */
public class IdPager<T> {
    private PageData page;
    private List<T> data;

    public PageData getPage() {
        return page;
    }

    public void setPage(PageData page) {
        this.page = page;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static class PageData implements Serializable {

        private int curPage;

        private int pageSize;

        private int totalSize;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(int totalSize) {
            this.totalSize = totalSize;
        }
    }

}
