package com.hht.interceptor;

import java.util.List;

/**
 * 分页属性实体Bean
 *
 * @author panghui
 * @version 1.0
 * @since 2016/7/28
 */
public class Page<T, P> {

    private int pageNum;
    // 查询条件
    private P params;
    // 查询结果集
    private List<T> list;
    // 总记录条数
    private int totalRecord;
    // 总页数
    private int totalPageCount;
    // 首页
    private int viewFirstPageNum;
    // 末页
    private int viewLastPageNum;
    public int pageRecordCount = 5;
    public static final int displayPageCount = 5;

    public Page() {
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public P getParams() {
        return params;
    }

    public void setParams(P params) {
        this.params = params;
    }

    public List<T> getList() {
        return this.list;
    }

    public int getTotalRecord() {
        return this.totalRecord;
    }

    public int getTotalPageCount() {
        return this.totalPageCount;
    }

    public int getViewFirstPageNum() {
        return this.viewFirstPageNum;
    }

    public int getViewLastPageNum() {
        return this.viewLastPageNum;
    }

    public int getPageRecordCount() {
        return this.pageRecordCount;
    }

    public void setPageRecordCount(int pageRecordCount) {
        this.pageRecordCount = pageRecordCount;
    }

    public static int getDisplaypagecount() {
        return 5;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        this.setTotalPageCount((totalRecord + this.pageRecordCount - 1) / this.pageRecordCount);
        if (this.pageNum < 1 || this.pageNum > this.totalPageCount) {
            this.pageNum = 1;
        }

        if (this.totalPageCount <= 5) {
            this.viewFirstPageNum = 1;
            this.viewLastPageNum = this.totalPageCount;
        } else {
            this.viewFirstPageNum = this.pageNum - 2;
            this.viewLastPageNum = this.pageNum + 2;
            if (this.viewFirstPageNum < 1) {
                this.viewFirstPageNum = 1;
                this.viewLastPageNum = 5;
            }

            if (this.viewLastPageNum > this.totalPageCount) {
                this.viewLastPageNum = this.totalPageCount;
                this.viewFirstPageNum = this.totalPageCount - 5 + 1;
            }
        }

        this.setViewFirstPageNum(this.viewFirstPageNum);
        this.setViewLastPageNum(this.viewLastPageNum);
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public void setViewFirstPageNum(int viewFirstPageNum) {
        this.viewFirstPageNum = viewFirstPageNum;
    }

    public void setViewLastPageNum(int viewLastPageNum) {
        this.viewLastPageNum = viewLastPageNum;
    }

}
