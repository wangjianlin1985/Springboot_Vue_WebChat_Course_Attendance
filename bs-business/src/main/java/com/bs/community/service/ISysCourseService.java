package com.bs.community.service;

import java.util.List;
import com.bs.community.domain.SysCourse;

/**
 * 课程信息Service接口
 * 
 * @author bs
 * @date 2021-03-19
 */
public interface ISysCourseService 
{
    /**
     * 查询课程信息
     * 
     * @param courseId 课程信息ID
     * @return 课程信息
     */
    public SysCourse selectSysCourseById(Long courseId);

    /**
     * 查询课程信息列表
     * 
     * @param sysCourse 课程信息
     * @return 课程信息集合
     */
    public List<SysCourse> selectSysCourseList(SysCourse sysCourse);

    /**
     * 新增课程信息
     * 
     * @param sysCourse 课程信息
     * @return 结果
     */
    public int insertSysCourse(SysCourse sysCourse);

    /**
     * 修改课程信息
     * 
     * @param sysCourse 课程信息
     * @return 结果
     */
    public int updateSysCourse(SysCourse sysCourse);

    /**
     * 批量删除课程信息
     * 
     * @param courseIds 需要删除的课程信息ID
     * @return 结果
     */
    public int deleteSysCourseByIds(Long[] courseIds);

    /**
     * 删除课程信息信息
     * 
     * @param courseId 课程信息ID
     * @return 结果
     */
    public int deleteSysCourseById(Long courseId);
}
