package com.egao.common.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.egao.common.core.utils.FileUploadUtil;
import com.egao.common.core.web.*;
import com.egao.common.system.entity.User;
import com.egao.common.system.entity.UserRole;
import com.egao.common.system.service.UserRoleService;
import com.egao.common.system.service.UserService;
import com.egao.common.test.entity.Teacher;
import com.egao.common.test.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 管理
 * Created by AutoGenerator on 2020-08-13 09:08:35
 */
@Controller
@RequestMapping("/course/teacher")
public class TeacherController extends BaseController {
	
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;

    @RequestMapping()
    public String view() {
        return "course/teacher.html";
    }

    /**
     * 分页查询
     */
    @ResponseBody
    @RequestMapping("/page")
    public PageResult<Teacher> page(HttpServletRequest request) {
        PageParam<Teacher> pageParam = new PageParam<>(request);
        return new PageResult<>(teacherService.page(pageParam, pageParam.getWrapper()).getRecords(), pageParam.getTotal());
        //return teacherService.listPage(pageParam);  // 使用关联查询
    }

    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping("/list")
    public JsonResult list(HttpServletRequest request) {
        PageParam<Teacher> pageParam = new PageParam<>(request);
        return JsonResult.ok().setData(teacherService.list(pageParam.getOrderWrapper()));
        //List<Teacher> records = teacherService.listAll(pageParam.getNoPageParam());  // 使用关联查询
        //return JsonResult.ok().setData(pageParam.sortRecords(records));
    }
    
    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping("/listuser")
    public JsonResult listuser() {
    	List<UserRole> userRoles = userRoleService.list(new QueryWrapper<UserRole>().eq("role_id", 2));
    	String ids = "";
    	for(UserRole userrole : userRoles) {
    		ids += userrole.getUserId()+",";
    	}
    	ids = ids.substring(0,ids.length() - 1);
    	List<User> users = userService.list(new QueryWrapper<User>().in("user_id", ids).eq("state", 0).eq("deleted", 0));
        return JsonResult.ok().setData(users);
   }

    /**
     * 根据id查询
     */
    @ResponseBody
    @RequestMapping("/get")
    public JsonResult get(Integer id) {
        return JsonResult.ok().setData(teacherService.getById(id));
		// 使用关联查询
        //PageParam<Teacher> pageParam = new PageParam<>();
		//pageParam.put("id", id);
        //List<Teacher> records = teacherService.listAll(pageParam.getNoPageParam());
        //return JsonResult.ok().setData(pageParam.getOne(records));
    }
    
    /**
     * 根据id查询
     */
    @ResponseBody
    @RequestMapping("/getById")
    public String getById(Integer id) {
    	Teacher teacher = teacherService.getById(id);
        return teacher.getNickName();
    }
    
    /**
     * 根据id查询
     */
    @ResponseBody
    @RequestMapping("/userId")
    public String userId(Integer userId) {
    	User user = userService.getById(userId);
        return user.getUsername();
    }
    
    
    @ResponseBody
    @RequestMapping("/updateByuserId")
    public JsonResult updateByuserId(Integer id,Integer userId) {
    	Teacher teacher = teacherService.getById(id);
    	teacher.setUserId(userId);
    	if (teacherService.updateById(teacher)) {
            return JsonResult.ok("授权成功");
        }
        return JsonResult.error("授权失败");
    	
    }

    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping("/save")
    public JsonResult save(Teacher teacher) {
        if (teacherService.save(teacher)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public JsonResult update(Teacher teacher) {
        if (teacherService.updateById(teacher)) {
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
        if (teacherService.removeById(id)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }

    /**
     * 批量添加
     */
    @ResponseBody
    @RequestMapping("/saveBatch")
    public JsonResult saveBatch(@RequestBody List<Teacher> list) {
        if (teacherService.saveBatch(list)) {
            return JsonResult.ok("添加成功");
        }
        return JsonResult.error("添加失败");
    }

    /**
     * 批量修改
     */
    @ResponseBody
    @RequestMapping("/updateBatch")
    public JsonResult updateBatch(@RequestBody BatchParam<Teacher> batchParam) {
        if (batchParam.update(teacherService, "id")) {
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
        if (teacherService.removeByIds(ids)) {
            return JsonResult.ok("删除成功");
        }
        return JsonResult.error("删除失败");
    }
    
    @ResponseBody
    @PostMapping("/upload")
    public JsonResult upload(@RequestParam MultipartFile file) {
        return FileUploadUtil.upload(file);
    }

}
