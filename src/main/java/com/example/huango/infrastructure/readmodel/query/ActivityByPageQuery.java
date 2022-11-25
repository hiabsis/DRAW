package com.example.huango.infrastructure.readmodel.query;

import com.example.huango.infrastructure.spring.query.PageQuery;

import java.util.Date;

public class ActivityByPageQuery extends PageQuery {

    private String code;

    private String name;

    /**
     * 开始时间
     */
    private Date startTime;


    /**
     * 结束时间
     */
    private Date endTime;

    private Long id;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
