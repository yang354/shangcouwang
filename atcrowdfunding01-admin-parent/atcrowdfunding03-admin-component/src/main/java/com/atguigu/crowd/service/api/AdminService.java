package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {

    //新增
    void saveAdmin(Admin admin);

    //测试时使用了一下
    Admin getId();

    //登录验证
    Admin getAdminByLoginAcct(String loginAcct, String userPswd);

    //无参查询   关键字查询   翻页查询
    PageInfo<Admin> getPageInfo(String keyword,Integer pageNum,Integer pageSize);

    //删除
    void remove(Integer adminId);

    //为了编辑时，回显数据
    Admin getAdminById(Integer adminId);

    //更新
    void update(Admin admin);

    void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList);

    Admin getAdminByLoginAcct(String username);
}
