package com.egao.common.test.controller;

import com.egao.common.core.web.*;
import com.egao.common.test.entity.Menur;
import com.egao.common.test.service.MenurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 管理
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@Controller
@RequestMapping("/course/menu")
public class MenurController extends BaseController {
    @Autowired
    private MenurService menurService;

    @RequestMapping()
    public String view() {
        return "course/menu.html";
    }

    /**
     * 分页查询
     */
    @ResponseBody
    @RequestMapping("/page")
    public PageResult<Menur> page(HttpServletRequest request) {
        PageParam<Menur> pageParam = new PageParam<>(request);
        return new PageResult<>(menurService.page(pageParam, pageParam.getWrapper()).getRecords(), pageParam.getTotal());
        //return menuService.listPage(pageParam);  // 使用关联查询
    }

    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        PageParam<Menur> pageParam = new PageParam<>(request);
        return JsonResult.ok().setData(menurService.list(pageParam.getOrderWrapper()));
        //List<Menu> records = menuService.listAll(pageParam.getNoPageParam());  // 使用关联查询
        //return JsonResult.ok().setData(pageParam.sortRecords(records));
    }

    /**
     * 根据id查询
     */
    @ResponseBody
    @RequestMapping("/get")
    public JsonResult get(Integer id) {
        return JsonResult.ok().setData(menurService.getById(id));
		// 使用关联查询
        //PageParam<Menu> pageParam = new PageParam<>();
		//pageParam.put("id", id);
        //List<Menu> records = menuService.listAll(pageParam.getNoPageParam());
        //return JsonResult.ok().setData(pageParam.getOne(records));
    }

    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(Menur menu) {
        if (menurService.save(menu)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(Menur menu) {
        if (menurService.updateById(menu)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/remove")
    public JsonResult remove(Integer id) {
        if (menurService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 批量添加
     */
    @ResponseBody
    @RequestMapping("/saveBatch")
    public JsonResult saveBatch(@RequestBody List<Menur> list) {
        if (menurService.saveBatch(list)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 批量修改
     */
    @ResponseBody
    @RequestMapping("/updateBatch")
    public JsonResult updateBatch(@RequestBody BatchParam<Menur> batchParam) {
        if (batchParam.update(menurService, "id")) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    /**
     * 批量删除
     */
    @ResponseBody
    @RequestMapping("/removeBatch")
    public JsonResult removeBatch(@RequestBody List<Integer> ids) {
        if (menurService.removeByIds(ids)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

}
