package com.bs.web.controller.community;

import java.util.List;

import com.bs.common.utils.SecurityUtils;
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
import com.bs.community.domain.SysCourseArrange;
import com.bs.community.service.ISysCourseArrangeService;
import com.bs.common.utils.poi.ExcelUtil;
import com.bs.common.core.page.TableDataInfo;

/**
 * 课程安排Controller
 * 
 * @author bs
 * @date 2021-03-19
 */
@RestController
@RequestMapping("/community/arrange")
public class SysCourseArrangeController extends BaseController
{
    @Autowired
    private ISysCourseArrangeService sysCourseArrangeService;

    /**
     * 查询课程安排列表
     */
    @PreAuthorize("@ss.hasPermi('community:arrange:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysCourseArrange sysCourseArrange)
    {
        startPage();
        List<SysCourseArrange> list = sysCourseArrangeService.selectSysCourseArrangeList(sysCourseArrange);
        return getDataTable(list);
    }

    @GetMapping("/listbydept")
    public AjaxResult listbydept(SysCourseArrange sysCourseArrange)
    {
        sysCourseArrange.setDeptId(SecurityUtils.getLoginUser().getUser().getDeptId());
        return AjaxResult.success(sysCourseArrangeService.selectSysCourseArrangeList(sysCourseArrange));
    }

    @GetMapping("/todayCourses")
    public AjaxResult todayCourses(SysCourseArrange sysCourseArrange)
    {
        sysCourseArrange.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        sysCourseArrange.setDeptId(SecurityUtils.getLoginUser().getUser().getDeptId());
        return AjaxResult.success(sysCourseArrangeService.selectTodayCourseArrangeList(sysCourseArrange));
    }

    @GetMapping("/selectClockHistory")
    public AjaxResult selectClockHistory(SysCourseArrange sysCourseArrange)
    {
        sysCourseArrange.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        return AjaxResult.success(sysCourseArrangeService.selectClockHistory(sysCourseArrange));
    }


    /**
     * 导出课程安排列表
     */
    @PreAuthorize("@ss.hasPermi('community:arrange:export')")
    @Log(title = "课程安排", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysCourseArrange sysCourseArrange)
    {
        List<SysCourseArrange> list = sysCourseArrangeService.selectSysCourseArrangeList(sysCourseArrange);
        ExcelUtil<SysCourseArrange> util = new ExcelUtil<SysCourseArrange>(SysCourseArrange.class);
        return util.exportExcel(list, "arrange");
    }

    /**
     * 获取课程安排详细信息
     */
    @PreAuthorize("@ss.hasPermi('community:arrange:query')")
    @GetMapping(value = "/{arrangeId}")
    public AjaxResult getInfo(@PathVariable("arrangeId") Long arrangeId)
    {
        return AjaxResult.success(sysCourseArrangeService.selectSysCourseArrangeById(arrangeId));
    }

    /**
     * 新增课程安排
     */
    @PreAuthorize("@ss.hasPermi('community:arrange:add')")
    @Log(title = "课程安排", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCourseArrange sysCourseArrange)
    {
        return toAjax(sysCourseArrangeService.insertSysCourseArrange(sysCourseArrange));
    }

    /**
     * 修改课程安排
     */
    @PreAuthorize("@ss.hasPermi('community:arrange:edit')")
    @Log(title = "课程安排", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCourseArrange sysCourseArrange)
    {
        return toAjax(sysCourseArrangeService.updateSysCourseArrange(sysCourseArrange));
    }

    /**
     * 删除课程安排
     */
    @PreAuthorize("@ss.hasPermi('community:arrange:remove')")
    @Log(title = "课程安排", businessType = BusinessType.DELETE)
	@DeleteMapping("/{arrangeIds}")
    public AjaxResult remove(@PathVariable Long[] arrangeIds)
    {
        return toAjax(sysCourseArrangeService.deleteSysCourseArrangeByIds(arrangeIds));
    }
}
