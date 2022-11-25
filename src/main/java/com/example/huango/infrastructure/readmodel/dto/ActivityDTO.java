package com.example.huango.infrastructure.readmodel.dto;

import java.util.Date;

public class ActivityDTO {

    private Long id;
    /**
     * 活动编码
     */
    private String code;
    /**
     * 活动名称
     */
    private String name;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 开始时间
     */
    private Date startTime;


    /**
     * 结束时间
     */
    private Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
