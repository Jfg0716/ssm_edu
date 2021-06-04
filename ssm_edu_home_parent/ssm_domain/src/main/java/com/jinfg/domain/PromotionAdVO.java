package com.jinfg.domain;

/**
 * @author jinfg
 * @date 2021/6/3 9:55
 */
public class PromotionAdVO {
    //当前页
    private Integer currentPage;

    //每页显示的条数
    private Integer pageSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
