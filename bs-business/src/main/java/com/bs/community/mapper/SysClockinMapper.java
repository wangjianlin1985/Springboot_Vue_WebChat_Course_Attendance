package com.bs.community.mapper;

import java.util.List;
import java.util.Map;

import com.bs.community.domain.SysClockin;

/**
 * 学生考勤Mapper接口
 * 
 * @author bs
 * @date 2021-03-19
 */
public interface SysClockinMapper 
{
    /**
     * 查询学生考勤
     * 
     * @param clockinId 学生考勤ID
     * @return 学生考勤
     */
    public SysClockin selectSysClockinById(Long clockinId);

    /**
     * 首页统计
     * @return
     */
    public Map statisticsIndex();


    public Map clockinCount();

    public List<Map> clockinByCource();

    public List<Map> clockinByDept();




    /**
     * 查询学生考勤列表
     * 
     * @param sysClockin 学生考勤
     * @return 学生考勤集合
     */
    public List<SysClockin> selectSysClockinList(SysClockin sysClockin);

    /**
     * 新增学生考勤
     * 
     * @param sysClockin 学生考勤
     * @return 结果
     */
    public int insertSysClockin(SysClockin sysClockin);

    /**
     * 修改学生考勤
     * 
     * @param sysClockin 学生考勤
     * @return 结果
     */
    public int updateSysClockin(SysClockin sysClockin);

    /**
     * 删除学生考勤
     * 
     * @param clockinId 学生考勤ID
     * @return 结果
     */
    public int deleteSysClockinById(Long clockinId);

    /**
     * 批量删除学生考勤
     * 
     * @param clockinIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysClockinByIds(Long[] clockinIds);
}
