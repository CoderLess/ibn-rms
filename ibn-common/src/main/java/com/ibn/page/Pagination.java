package com.ibn.page;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.page
 * @author： RenBin
 * @createTime：2020/8/11 14:43
 */
@Data
public class Pagination<E> implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<E> list = new ArrayList<>();

    private int pageNum;

    private int pageSize;

    private long total;

    private int pages;

    public Pagination(int pageNum, int pageSize, long total, int pages) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
    }
}
