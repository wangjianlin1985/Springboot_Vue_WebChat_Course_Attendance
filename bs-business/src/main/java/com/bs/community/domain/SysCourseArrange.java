package com.bs.community.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bs.common.annotation.Excel;
import com.bs.common.core.domain.BaseEntity;

/**
 * 课程安排对象 sys_course_arrange
 * 
 * @author bs
 * @date 2021-03-19
 */
public class SysCourseArrange extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程安排ID */
    private Long arrangeId;

    /** 班级ID */
    @Excel(name = "班级ID")
    private Long deptId;

    private Long userId;

    /** 课程ID */
    @Excel(name = "课程ID")
    private Long courseId;

    private String credit;

    private Integer minute;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date courseDate;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String beginTime;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endTime;

    /** 开课地点 */
    @Excel(name = "开课地点")
    private String address;

    /** 开课老师 */
    @Excel(name = "开课老师")
    private String teacher;

    private Integer dk;

    public void setArrangeId(Long arrangeId) 
    {
        this.arrangeId = arrangeId;
    }

    public Long getArrangeId() 
    {
        return arrangeId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setCourseDate(Date courseDate) 
    {
        this.courseDate = courseDate;
    }

    public Date getCourseDate() 
    {
        return courseDate;
    }
    public void setBeginTime(String beginTime) 
    {
        this.beginTime = beginTime;
    }

    public String getBeginTime() 
    {
        return beginTime;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setTeacher(String teacher) 
    {
        this.teacher = teacher;
    }

    public String getTeacher() 
    {
        return teacher;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDk() {
        return dk;
    }

    public void setDk(Integer dk) {
        this.dk = dk;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("arrangeId", getArrangeId())
            .append("deptId", getDeptId())
            .append("courseId", getCourseId())
            .append("courseName", getCourseName())
            .append("courseDate", getCourseDate())
            .append("beginTime", getBeginTime())
            .append("endTime", getEndTime())
            .append("address", getAddress())
            .append("teacher", getTeacher())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
