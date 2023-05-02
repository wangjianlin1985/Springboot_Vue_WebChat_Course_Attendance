package com.bs.community.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bs.common.annotation.Excel;
import com.bs.common.core.domain.BaseEntity;

/**
 * 学生考勤对象 sys_clockin
 * 
 * @author bs
 * @date 2021-03-19
 */
public class SysClockin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 考勤ID */
    private Long clockinId;

    /** 课程安排ID */
    @Excel(name = "课程安排ID")
    private Long arrangeId;

    /** 打卡人ID */
    @Excel(name = "打卡人ID")
    private Long userId;

    private Long deptId;

    private String nickName;
    private String courseName;

    public void setClockinId(Long clockinId) 
    {
        this.clockinId = clockinId;
    }

    public Long getClockinId() 
    {
        return clockinId;
    }
    public void setArrangeId(Long arrangeId) 
    {
        this.arrangeId = arrangeId;
    }

    public Long getArrangeId() 
    {
        return arrangeId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clockinId", getClockinId())
            .append("arrangeId", getArrangeId())
            .append("userId", getUserId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
