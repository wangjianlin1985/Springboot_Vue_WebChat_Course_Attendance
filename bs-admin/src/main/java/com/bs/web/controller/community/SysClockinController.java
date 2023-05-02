package com.bs.web.controller.community;

import java.util.List;
import java.util.Map;

import com.bs.common.utils.SecurityUtils;
import com.bs.common.utils.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bs.common.annotation.Log;
import com.bs.common.core.controller.BaseController;
import com.bs.common.core.domain.AjaxResult;
import com.bs.common.enums.BusinessType;
import com.bs.community.domain.SysClockin;
import com.bs.community.service.ISysClockinService;
import com.bs.common.utils.poi.ExcelUtil;
import com.bs.common.core.page.TableDataInfo;

/**
 * 学生考勤Controller
 * 
 * @author bs
 * @date 2021-03-19
 */
@RestController
@RequestMapping("/community/clockin")
public class SysClockinController extends BaseController
{
    @Autowired
    private ISysClockinService sysClockinService;

    /**
     * 查询学生考勤列表
     */
    @PreAuthorize("@ss.hasPermi('community:clockin:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysClockin sysClockin)
    {
        startPage();
        List<SysClockin> list = sysClockinService.selectSysClockinList(sysClockin);
        return getDataTable(list);
    }

    @GetMapping("/statistics")
    public AjaxResult statisticsIndex()
    {
        return AjaxResult.success(sysClockinService.statisticsIndex());
    }

    @GetMapping("/clockinCount")
    public AjaxResult clockinCount()
    {
        return AjaxResult.success(sysClockinService.clockinCount());
    }


    /**
     * 导出学生考勤列表
     */
    @PreAuthorize("@ss.hasPermi('community:clockin:export')")
    @Log(title = "学生考勤", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysClockin sysClockin)
    {
        List<SysClockin> list = sysClockinService.selectSysClockinList(sysClockin);
        ExcelUtil<SysClockin> util = new ExcelUtil<SysClockin>(SysClockin.class);
        return util.exportExcel(list, "clockin");
    }

    /**
     * 获取学生考勤详细信息
     */
    @PreAuthorize("@ss.hasPermi('community:clockin:query')")
    @GetMapping(value = "/{clockinId}")
    public AjaxResult getInfo(@PathVariable("clockinId") Long clockinId)
    {
        return AjaxResult.success(sysClockinService.selectSysClockinById(clockinId));
    }

    /**
     * 新增学生考勤
     */
    @PreAuthorize("@ss.hasPermi('community:clockin:add')")
    @Log(title = "学生考勤", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysClockin sysClockin)
    {
        if(StringUtils.isNull(sysClockin.getUserId())){
            sysClockin.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        }
        return toAjax(sysClockinService.insertSysClockin(sysClockin));
    }

    /**
     * 修改学生考勤
     */
    @PreAuthorize("@ss.hasPermi('community:clockin:edit')")
    @Log(title = "学生考勤", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysClockin sysClockin)
    {
        return toAjax(sysClockinService.updateSysClockin(sysClockin));
    }

    /**
     * 删除学生考勤
     */
    @PreAuthorize("@ss.hasPermi('community:clockin:remove')")
    @Log(title = "学生考勤", businessType = BusinessType.DELETE)
	@DeleteMapping("/{clockinIds}")
    public AjaxResult remove(@PathVariable Long[] clockinIds)
    {
        return toAjax(sysClockinService.deleteSysClockinByIds(clockinIds));
    }
}
