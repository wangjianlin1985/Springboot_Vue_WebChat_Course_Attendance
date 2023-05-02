package com.bs.community.service;

import java.util.List;
import com.bs.community.domain.SysCourseArrange;

/**
 * 课程安排Service接口
 * 
 * @author bs
 * @date 2021-03-19
 */
public interface ISysCourseArrangeService 
{
    /**
     * 查询课程安排
     * 
     * @param arrangeId 课程安排ID
     * @return 课程安排
     */
    public SysCourseArrange selectSysCourseArrangeById(Long arrangeId);

    /**
     * 查询课程安排列表
     * 
     * @param sysCourseArrange 课程安排
     * @return 课程安排集合
     */
    public List<SysCourseArrange> selectSysCourseArrangeList(SysCourseArrange sysCourseArrange);

    public List<SysCourseArrange> selectTodayCourseArrangeList(SysCourseArrange sysCourseArrange);

    public List<SysCourseArrange> selectClockHistory(SysCourseArrange sysCourseArrange);
    /**
     * 新增课程安排
     * 
     * @param sysCourseArrange 课程安排
     * @return 结果
     */
    public int insertSysCourseArrange(SysCourseArrange sysCourseArrange);

    /**
     * 修改课程安排
     * 
     * @param sysCourseArrange 课程安排
     * @return 结果
     */
    public int updateSysCourseArrange(SysCourseArrange sysCourseArrange);

    /**
     * 批量删除课程安排
     * 
     * @param arrangeIds 需要删除的课程安排ID
     * @return 结果
     */
    public int deleteSysCourseArrangeByIds(Long[] arrangeIds);

    /**
     * 删除课程安排信息
     * 
     * @param arrangeId 课程安排ID
     * @return 结果
     */
    public int deleteSysCourseArrangeById(Long arrangeId);
}
