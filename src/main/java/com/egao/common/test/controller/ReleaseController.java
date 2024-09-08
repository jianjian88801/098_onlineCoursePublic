package com.egao.common.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.egao.common.core.web.*;
import com.egao.common.system.entity.User;
import com.egao.common.system.entity.UserTwo;
import com.egao.common.system.service.UserTwoService;
import com.egao.common.test.entity.Release;
import com.egao.common.test.service.ReleaseService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
@RequestMapping("/course/release")
public class ReleaseController extends BaseController {
    @Autowired
    private ReleaseService releaseService;
    @Autowired
    private UserTwoService userTwoService;

    @RequestMapping()
    public String view() {
        return "course/release.html";
    }

    /**
     * 分页查询
     */
    @ResponseBody
    @RequestMapping("/page")
    public PageResult<Release> page(HttpServletRequest request) {
        // 获取当前Subject对象
        Subject subject = SecurityUtils.getSubject();
        // 获取当前用户的信息
        Object principal = subject.getPrincipal();
        int userId = 0;
        if (principal != null){
            String s = JSON.toJSONString(principal);
            JSONObject jsonObject = JSON.parseObject(s);
            userId = jsonObject.getInteger("userId");
        }
        PageParam<Release> pageParam = new PageParam<>(request);
        QueryWrapper<Release> wrapper = pageParam.getWrapper();
        if(userId !=1){
            wrapper.eq("user_id",userId);
        }
        return new PageResult<>(releaseService.page(pageParam, wrapper).getRecords(), pageParam.getTotal());
        //return classifyService.listPage(pageParam);  // 使用关联查询
    }

    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        PageParam<Release> pageParam = new PageParam<>(request);
        return JsonResult.ok().setData(releaseService.list(pageParam.getOrderWrapper()));
        //List<Classify> records = classifyService.listAll(pageParam.getNoPageParam());  // 使用关联查询
        //return JsonResult.ok().setData(pageParam.sortRecords(records));
    }

    /**
     * 根据id查询
     */
    @ResponseBody
    @RequestMapping("/get")
    public JsonResult get(Integer id) {
        return JsonResult.ok().setData(releaseService.getById(id));
		// 使用关联查询
        //PageParam<Classify> pageParam = new PageParam<>();
		//pageParam.put("id", id);
        //List<Classify> records = classifyService.listAll(pageParam.getNoPageParam());
        //return JsonResult.ok().setData(pageParam.getOne(records));
    }
    
    @ResponseBody
    @RequestMapping("/shenhe")
    public JsonResult ShenHe(Integer id,Integer state,Integer present,Integer userId) {
    	Release release = releaseService.getById(id);
    	UserTwo usertwo = userTwoService.getById(userId);
    	release.setState(state);
    	if (releaseService.updateById(release)) {
    	    int fenzhi = usertwo.getPresent() + present;
    	    usertwo.setPresent(fenzhi);
    	    if(userTwoService.updateById(usertwo)) {
    	    	return JsonResult.ok("审核成功");
    	    }
            
        }
    	return JsonResult.error("审核失败");
    }


    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(Release release) {
        if (releaseService.save(release)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(Release release) {
        if (releaseService.updateById(release)) {
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
        if (releaseService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 批量添加
     */
    @ResponseBody
    @RequestMapping("/saveBatch")
    public JsonResult saveBatch(@RequestBody List<Release> list) {
        if (releaseService.saveBatch(list)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 批量修改
     */
    @ResponseBody
    @RequestMapping("/updateBatch")
    public JsonResult updateBatch(@RequestBody BatchParam<Release> batchParam) {
        if (batchParam.update(releaseService, "id")) {
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
        if (releaseService.removeByIds(ids)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

}
