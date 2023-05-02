package com.bs.community.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.bs.community.domain.SysClockin;

/**
 * 学生考勤Service接口
 * 
 * @author bs
 * @date 2021-03-19
 */
public interface ISysClockinService 
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

    public JSONObject clockinCount();

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
     * 批量删除学生考勤
     * 
     * @param clockinIds 需要删除的学生考勤ID
     * @return 结果
     */
    public int deleteSysClockinByIds(Long[] clockinIds);

    /**
     * 删除学生考勤信息
     * 
     * @param clockinId 学生考勤ID
     * @return 结果
     */
    public int deleteSysClockinById(Long clockinId);
}
