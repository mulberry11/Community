package com.ygj.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 十一
 * @date 2020-04-01 00:54
 */
@Data
public class PaginationDTO {
    /**
     * 页面扎展示数据
     */
    private List<QuestionDTO> questions;
    /*
     *是否有上一页按钮
     */
    private boolean showPrevious;
    /**
     * 是否有回到第一页按钮
     */
    private boolean showFirstPage;
    /**
     * 是否有下一页按钮
     */
    private boolean showNext;
    /**
     * 是否有最后一页按钮
     */
    private boolean showEndPage;
    private Integer page;
    private Integer size;
    private List<Integer> pages=new ArrayList<Integer>();;
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        //总页数
        this.totalPage = (int) Math.ceil((double) totalCount / size);
        if (page<1){
            page=1;
        }
        if (page>totalPage){
            page=totalPage;
        }
        this.page=page;
        /**
         * 计算展示的页数
         */
        for (int i = 1; i <= 3; i++) {
            //添加左边页码
            if (page - i >= 0) {
                this.pages.add(0,page-i+1);
            }
            //添加右边页码
            if (page + i <= totalPage) {
                this.pages.add(page + i);
            }
        }
        //判断是否有上一页按钮
        if (page == 1) {
            this.showPrevious = false;
        } else {
            this.showPrevious = true;
        }
        //是否有下一页按钮
        if (page == totalPage) {
            this.showNext = false;
        } else {
            this.showNext = true;
        }
        //判断是否有回到最后一页
        if (pages.contains(totalPage)) {
            this.showEndPage = false;
        } else {
            this.showEndPage = true;
        }
        //判断是否有第一页
        if (pages.contains(1)) {
            this.showFirstPage = false;
        } else {
            this.showFirstPage = true;
        }
    }
}
