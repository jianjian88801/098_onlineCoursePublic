package com.egao.common.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;

/**
 * 
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@TableName("t_course")
public class Course implements Serializable {
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
     * 缩略图
     */
    private String imageUrl;

    /**
     * 类别
     */
    private String type;

    /**
     * 内容
     */
    private String content;

    /**
     * 教师id
     */
    private Integer teacherId;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 分类id
     */
    private Integer classifyId;

    private Integer ggkc;
    
    private Integer zykc;
    
    private Integer mfkc;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Integer getGgkc() {
        return ggkc;
    }

    public void setGgkc(Integer ggkc) {
        this.ggkc = ggkc;
    }
    
    public Integer getZykc() {
        return zykc;
    }

    public void setZykc(Integer zykc) {
        this.zykc = zykc;
    }
    
    public Integer getMfkc() {
        return mfkc;
    }

    public void setMfkc(Integer mfkc) {
        this.mfkc = mfkc;
    }


    @Override
    public String toString() {
        return "Course{" +
        ", id=" + id +
        ", name=" + name +
        ", imageUrl=" + imageUrl +
        ", type=" + type +
        ", content=" + content +
        ", teacherId=" + teacherId +
        ", createTime=" + createTime +
        ", classifyId=" + classifyId +
        ", ggkc=" + ggkc +
        ", zykc=" + zykc +
        ", mfkc=" + mfkc +
        "}";
    }

}
