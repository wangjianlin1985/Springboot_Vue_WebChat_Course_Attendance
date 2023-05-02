package com.bs.community.service.impl;

import java.util.List;
import com.bs.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bs.community.mapper.SysCourseMapper;
import com.bs.community.domain.SysCourse;
import com.bs.community.service.ISysCourseService;

/**
 * 课程信息Service业务层处理
 * 
 * @author bs
 * @date 2021-03-19
 */
@Service
public class SysCourseServiceImpl implements ISysCourseService 
{
    @Autowired
    private SysCourseMapper sysCourseMapper;

    /**
     * 查询课程信息
     * 
     * @param courseId 课程信息ID
     * @return 课程信息
     */
    @Override
    public SysCourse selectSysCourseById(Long courseId)
    {
        return sysCourseMapper.selectSysCourseById(courseId);
    }

    /**
     * 查询课程信息列表
     * 
     * @param sysCourse 课程信息
     * @return 课程信息
     */
    @Override
    public List<SysCourse> selectSysCourseList(SysCourse sysCourse)
    {
        return sysCourseMapper.selectSysCourseList(sysCourse);
    }

    /**
     * 新增课程信息
     * 
     * @param sysCourse 课程信息
     * @return 结果
     */
    @Override
    public int insertSysCourse(SysCourse sysCourse)
    {
        sysCourse.setCreateTime(DateUtils.getNowDate());
        return sysCourseMapper.insertSysCourse(sysCourse);
    }

    /**
     * 修改课程信息
     * 
     * @param sysCourse 课程信息
     * @return 结果
     */
    @Override
    public int updateSysCourse(SysCourse sysCourse)
    {
        return sysCourseMapper.updateSysCourse(sysCourse);
    }

    /**
     * 批量删除课程信息
     * 
     * @param courseIds 需要删除的课程信息ID
     * @return 结果
     */
    @Override
    public int deleteSysCourseByIds(Long[] courseIds)
    {
        return sysCourseMapper.deleteSysCourseByIds(courseIds);
    }

    /**
     * 删除课程信息信息
     * 
     * @param courseId 课程信息ID
     * @return 结果
     */
    @Override
    public int deleteSysCourseById(Long courseId)
    {
        return sysCourseMapper.deleteSysCourseById(courseId);
    }
}
