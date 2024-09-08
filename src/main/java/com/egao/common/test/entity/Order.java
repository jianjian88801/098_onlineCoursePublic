package com.egao.common.test.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@TableName("t_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer userId;

    /**
     * 备注
     */
    private String orderNo;
    
    private String type;
    
    private Date createTime;
    
    private String jine;
    
    private Integer courseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getJine() {
        return jine;
    }

    public void setJine(String jine) {
        this.jine = jine;
    }
    
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Classify{" +
        ", id=" + id +
        ", name=" + name +
        ", userId=" + userId +
        ", orderNo=" + orderNo +
        ", type=" + type +
        ", createTime=" + createTime +
        ", jine=" + jine +
        ", courseId=" + courseId +
        "}";
    }

}
