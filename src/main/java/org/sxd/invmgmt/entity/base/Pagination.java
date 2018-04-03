package org.sxd.invmgmt.entity.base;

/**
 * Created by eddie on 2018/2/4.
 */
public class Pagination extends Entity {
    private Integer page = 1;

    private Integer pageSize = 10;

    private Integer start = 0;

    private static Pagination pagination = new Pagination(0, 10);

    public static Pagination getDefaultPagination() {
        return pagination;
    }

    public Pagination() {
    }

    public Pagination(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        setStart((page - 1) * pageSize);
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public boolean isValid() {
        return page > 0 && pageSize > 0;
    }
}
