package com.bs.community.service.impl;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.bs.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bs.community.mapper.SysClockinMapper;
import com.bs.community.domain.SysClockin;
import com.bs.community.service.ISysClockinService;

/**
 * 学生考勤Service业务层处理
 * 
 * @author bs
 * @date 2021-03-19
 */
@Service
public class SysClockinServiceImpl implements ISysClockinService 
{
    @Autowired
    private SysClockinMapper sysClockinMapper;

    /**
     * 查询学生考勤
     * 
     * @param clockinId 学生考勤ID
     * @return 学生考勤
     */
    @Override
    public SysClockin selectSysClockinById(Long clockinId)
    {
        return sysClockinMapper.selectSysClockinById(clockinId);
    }

    /**
     * 首页统计
     * @return
     */
    public Map statisticsIndex(){
        return sysClockinMapper.statisticsIndex();
    }

    public JSONObject clockinCount(){
        JSONObject json=new JSONObject();
        json.put("clockinCount",sysClockinMapper.clockinCount());
        json.put("clockinByCource",sysClockinMapper.clockinByCource());
        json.put("clockinByDept",sysClockinMapper.clockinByDept());

        return json;
    }

    /**
     * 查询学生考勤列表
     * 
     * @param sysClockin 学生考勤
     * @return 学生考勤
     */
    @Override
    public List<SysClockin> selectSysClockinList(SysClockin sysClockin)
    {
        return sysClockinMapper.selectSysClockinList(sysClockin);
    }

    /**
     * 新增学生考勤
     * 
     * @param sysClockin 学生考勤
     * @return 结果
     */
    @Override
    public int insertSysClockin(SysClockin sysClockin)
    {
        sysClockin.setCreateTime(DateUtils.getNowDate());
        return sysClockinMapper.insertSysClockin(sysClockin);
    }

    /**
     * 修改学生考勤
     * 
     * @param sysClockin 学生考勤
     * @return 结果
     */
    @Override
    public int updateSysClockin(SysClockin sysClockin)
    {
        return sysClockinMapper.updateSysClockin(sysClockin);
    }

    /**
     * 批量删除学生考勤
     * 
     * @param clockinIds 需要删除的学生考勤ID
     * @return 结果
     */
    @Override
    public int deleteSysClockinByIds(Long[] clockinIds)
    {
        return sysClockinMapper.deleteSysClockinByIds(clockinIds);
    }

    /**
     * 删除学生考勤信息
     * 
     * @param clockinId 学生考勤ID
     * @return 结果
     */
    @Override
    public int deleteSysClockinById(Long clockinId)
    {
        return sysClockinMapper.deleteSysClockinById(clockinId);
    }
}
