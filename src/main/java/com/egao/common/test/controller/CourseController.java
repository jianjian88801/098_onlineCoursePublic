package com.egao.common.test.controller;

import com.egao.common.core.utils.FileUploadUtil;
import com.egao.common.core.web.*;
import com.egao.common.test.entity.Course;
import com.egao.common.test.service.ClassifyService;
import com.egao.common.test.service.CourseService;
import com.egao.common.test.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.List;

/**
 * 管理
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@Controller
@RequestMapping("/course/course")
public class CourseController extends BaseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private ClassifyService classifyService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping()
    public String view(Model model) {
    	model.addAttribute("classifyList", classifyService.list());
    	model.addAttribute("teacherList", teacherService.list());
        return "course/course.html";
    }
    
    @RequestMapping("/ggkc")
    public String ggkc() {
        return "course/ggkc.html";
    }
    
    @RequestMapping("/zykc")
    public String zykc() {
        return "course/zykc.html";
    }
    
    @RequestMapping("/mfkc")
    public String mfkc() {
        return "course/mfkc.html";
    }

    /**
     * 分页查询
     */
    @ResponseBody
    @RequestMapping("/page")
    public PageResult<Course> page(HttpServletRequest request) {
        PageParam<Course> pageParam = new PageParam<>(request);
        return new PageResult<>(courseService.page(pageParam, pageParam.getWrapper()).getRecords(), pageParam.getTotal());
    }

    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        PageParam<Course> pageParam = new PageParam<>(request);
        return JsonResult.ok().setData(courseService.list(pageParam.getOrderWrapper()));
        //List<Course> records = courseService.listAll(pageParam.getNoPageParam());  // 使用关联查询
        //return JsonResult.ok().setData(pageParam.sortRecords(records));
    }

    /**
     * 根据id查询
     */
    @ResponseBody
    @RequestMapping("/get")
    public JsonResult get(Integer id) {
        return JsonResult.ok().setData(courseService.getById(id));
		// 使用关联查询
        //PageParam<Course> pageParam = new PageParam<>();
		//pageParam.put("id", id);
        //List<Course> records = courseService.listAll(pageParam.getNoPageParam());
        //return JsonResult.ok().setData(pageParam.getOne(records));
    }

    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(Course course) {
    	course.setCreateTime(new Date());
        if (courseService.save(course)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(Course course) {
        if (courseService.updateById(course)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }
    
    
    @ResponseBody
    @RequestMapping("/updateggkc")
    public JsonResult updateggkc(Integer id,String type) {
    	Course course = courseService.getById(id);
    	if(type.equals("add")) {
    		course.setGgkc(1);
    	}else {
    		course.setGgkc(0);
    	}
        if (courseService.updateById(course)) {
        	if(type.equals("add")) {
        		return JsonResult.ok("添加成功");
        	}else {
        		return JsonResult.ok("移除成功");
        	}
        }
        if(type.equals("add")) {
        	return JsonResult.error("添加失败");
    	}else {
    		return JsonResult.error("移除失败");
    	}
        
    }
    
    @ResponseBody
    @RequestMapping("/updatezykc")
    public JsonResult updatezykc(Integer id,String type) {
    	Course course = courseService.getById(id);
    	if(type.equals("add")) {
    		course.setZykc(1);
    	}else {
    		course.setZykc(0);
    	}
        if (courseService.updateById(course)) {
        	if(type.equals("add")) {
        		return JsonResult.ok("添加成功");
        	}else {
        		return JsonResult.ok("移除成功");
        	}
        }
        if(type.equals("add")) {
        	return JsonResult.error("添加失败");
    	}else {
    		return JsonResult.error("移除失败");
    	}
    }
    
    @ResponseBody
    @RequestMapping("/updatemfkc")
    public JsonResult updatemfkc(Integer id,String type) {
    	Course course = courseService.getById(id);
    	if(type.equals("add")) {
    		course.setMfkc(1);
    	}else {
    		course.setMfkc(0);
    	}
        if (courseService.updateById(course)) {
        	if(type.equals("add")) {
        		return JsonResult.ok("添加成功");
        	}else {
        		return JsonResult.ok("移除成功");
        	}
        }
        if(type.equals("add")) {
        	return JsonResult.error("添加失败");
    	}else {
    		return JsonResult.error("移除失败");
    	}
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/remove")
    public JsonResult remove(Integer id) {
        if (courseService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 批量添加
     */
    @ResponseBody
    @RequestMapping("/saveBatch")
    public JsonResult saveBatch(@RequestBody List<Course> list) {
        if (courseService.saveBatch(list)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 批量修改
     */
    @ResponseBody
    @RequestMapping("/updateBatch")
    public JsonResult updateBatch(@RequestBody BatchParam<Course> batchParam) {
        if (batchParam.update(courseService, "id")) {
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
        if (courseService.removeByIds(ids)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }
    
    @ResponseBody
    @PostMapping("/edit_upload")
    public JsonResult edit_upload(@RequestParam MultipartFile file) {
        return FileUploadUtil.edit_upload(file);
    }

}
