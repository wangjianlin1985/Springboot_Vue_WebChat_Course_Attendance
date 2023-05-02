package com.bs.community.service.impl;

import java.util.List;
import com.bs.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bs.community.mapper.SysCourseArrangeMapper;
import com.bs.community.domain.SysCourseArrange;
import com.bs.community.service.ISysCourseArrangeService;

/**
 * 课程安排Service业务层处理
 * 
 * @author bs
 * @date 2021-03-19
 */
@Service
public class SysCourseArrangeServiceImpl implements ISysCourseArrangeService 
{
    @Autowired
    private SysCourseArrangeMapper sysCourseArrangeMapper;

    /**
     * 查询课程安排
     * 
     * @param arrangeId 课程安排ID
     * @return 课程安排
     */
    @Override
    public SysCourseArrange selectSysCourseArrangeById(Long arrangeId)
    {
        return sysCourseArrangeMapper.selectSysCourseArrangeById(arrangeId);
    }

    /**
     * 查询课程安排列表
     * 
     * @param sysCourseArrange 课程安排
     * @return 课程安排
     */
    @Override
    public List<SysCourseArrange> selectSysCourseArrangeList(SysCourseArrange sysCourseArrange)
    {
        return sysCourseArrangeMapper.selectSysCourseArrangeList(sysCourseArrange);
    }

    @Override
    public List<SysCourseArrange> selectTodayCourseArrangeList(SysCourseArrange sysCourseArrange)
    {
        return sysCourseArrangeMapper.selectTodayCourseArrangeList(sysCourseArrange);
    }

    @Override
    public List<SysCourseArrange> selectClockHistory(SysCourseArrange sysCourseArrange){
        return sysCourseArrangeMapper.selectClockHistory(sysCourseArrange);
    }

    /**
     * 新增课程安排
     * 
     * @param sysCourseArrange 课程安排
     * @return 结果
     */
    @Override
    public int insertSysCourseArrange(SysCourseArrange sysCourseArrange)
    {
        sysCourseArrange.setCreateTime(DateUtils.getNowDate());
        return sysCourseArrangeMapper.insertSysCourseArrange(sysCourseArrange);
    }

    /**
     * 修改课程安排
     * 
     * @param sysCourseArrange 课程安排
     * @return 结果
     */
    @Override
    public int updateSysCourseArrange(SysCourseArrange sysCourseArrange)
    {
        return sysCourseArrangeMapper.updateSysCourseArrange(sysCourseArrange);
    }

    /**
     * 批量删除课程安排
     * 
     * @param arrangeIds 需要删除的课程安排ID
     * @return 结果
     */
    @Override
    public int deleteSysCourseArrangeByIds(Long[] arrangeIds)
    {
        return sysCourseArrangeMapper.deleteSysCourseArrangeByIds(arrangeIds);
    }

    /**
     * 删除课程安排信息
     * 
     * @param arrangeId 课程安排ID
     * @return 结果
     */
    @Override
    public int deleteSysCourseArrangeById(Long arrangeId)
    {
        return sysCourseArrangeMapper.deleteSysCourseArrangeById(arrangeId);
    }
}
