package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.service.api.RoleService;
import com.atguigu.crowd.util.ResultEntity;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@Controller
public class RoleHandler {
    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/role/remove/by/role/id/array.json")
    public ResultEntity<String> removeByRoleIdArray(@RequestBody List<Integer> roleIdList){
        roleService.removeRole(roleIdList);
        //System.out.println(1/0);
        return ResultEntity.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("/role/update.json")
    public ResultEntity<String> updateRole(Role role){
        roleService.updateRole(role);
        return ResultEntity.successWithoutData();
    }


    @ResponseBody
    @RequestMapping("/role/save.json")
    public ResultEntity<String> saveRole(Role role){
        roleService.saveRole(role);
        //如果注解方式没有声明异常机制 使用xml注册的异常并走ajax中的error
        //注解方式声明异常机制 则使用注解方式的异常并走ajax中的success 需要判断一下返回来的值
        //System.out.println(1/0);
        return ResultEntity.successWithoutData();
    }

    @PreAuthorize("hasRole('部长')")
    @ResponseBody
    @RequestMapping("/role/get/page/info.json")
    public ResultEntity<PageInfo<Role>> getPageInfo(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
            @RequestParam(value = "keyword",defaultValue = "") String keyword
    ) {
        PageInfo<Role> pageInfo = roleService.getPageInfo(pageNum, pageSize, keyword);

        //封装到ResultEntity对象中返回（如果上面的操作抛出异常，交给异常映射机制处理）
        return ResultEntity.successWithData(pageInfo);
    }
}
