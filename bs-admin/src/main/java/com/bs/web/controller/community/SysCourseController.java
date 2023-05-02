package com.bs.web.controller.community;

import java.util.List;
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
import com.bs.community.domain.SysCourse;
import com.bs.community.service.ISysCourseService;
import com.bs.common.utils.poi.ExcelUtil;
import com.bs.common.core.page.TableDataInfo;

/**
 * 课程信息Controller
 * 
 * @author bs
 * @date 2021-03-19
 */
@RestController
@RequestMapping("/community/course")
public class SysCourseController extends BaseController
{
    @Autowired
    private ISysCourseService sysCourseService;

    /**
     * 查询课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('community:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysCourse sysCourse)
    {
        startPage();
        List<SysCourse> list = sysCourseService.selectSysCourseList(sysCourse);
        return getDataTable(list);
    }


    /**
     * 导出课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('community:course:export')")
    @Log(title = "课程信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysCourse sysCourse)
    {
        List<SysCourse> list = sysCourseService.selectSysCourseList(sysCourse);
        ExcelUtil<SysCourse> util = new ExcelUtil<SysCourse>(SysCourse.class);
        return util.exportExcel(list, "course");
    }

    /**
     * 获取课程信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('community:course:query')")
    @GetMapping(value = "/{courseId}")
    public AjaxResult getInfo(@PathVariable("courseId") Long courseId)
    {
        return AjaxResult.success(sysCourseService.selectSysCourseById(courseId));
    }

    /**
     * 新增课程信息
     */
    @PreAuthorize("@ss.hasPermi('community:course:add')")
    @Log(title = "课程信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCourse sysCourse)
    {
        return toAjax(sysCourseService.insertSysCourse(sysCourse));
    }

    /**
     * 修改课程信息
     */
    @PreAuthorize("@ss.hasPermi('community:course:edit')")
    @Log(title = "课程信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCourse sysCourse)
    {
        return toAjax(sysCourseService.updateSysCourse(sysCourse));
    }

    /**
     * 删除课程信息
     */
    @PreAuthorize("@ss.hasPermi('community:course:remove')")
    @Log(title = "课程信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{courseIds}")
    public AjaxResult remove(@PathVariable Long[] courseIds)
    {
        return toAjax(sysCourseService.deleteSysCourseByIds(courseIds));
    }
}
