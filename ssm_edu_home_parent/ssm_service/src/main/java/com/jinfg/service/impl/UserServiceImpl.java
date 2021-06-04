package com.jinfg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinfg.dao.UserMapper;
import com.jinfg.domain.*;
import com.jinfg.service.UserService;
import com.jinfg.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author jinfg
 * @date 2021/6/3 11:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUserByPage(UserVo userVo) {
        PageHelper.startPage(userVo.getCurrentPage(),userVo.getPageSize());
        List<User> allUserByPage = userMapper.findAllUserByPage(userVo);
        PageInfo<User> pageInfo = new PageInfo<>(allUserByPage);
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示长度："+pageInfo.getPageSize());
        System.out.println("是否第一页："+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+pageInfo.isIsLastPage());
        return pageInfo;
    }

    @Override
    public User login(User user) throws Exception {
        User login = userMapper.login(user);
        if (login != null && Md5.verify(user.getPassword(),"jinfg",login.getPassword())){
            return login;
        } else {
            return null;
        }
    }

    @Override
    public List<Role> findUserRelationRoleById(Integer id) {
        List<Role> list = userMapper.findUserRelationRoleById(id);

        return list;
    }

    @Override
    public void userContextRole(UserVo userVo) {
        // 1.根据用户ID清空中间表关联关系
        userMapper.deleteUserContextRole(userVo.getUserId());

        // 2.再从新建立关联关系
        for (Integer roleid : userVo.getRoleIdList()) {

            // 封装数据
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUserId(userVo.getUserId());
            user_role_relation.setRoleId(roleid);

            Date date = new Date();
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);

            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedby("system");

            userMapper.userContextRole(user_role_relation);

        }
    }

    @Override
    public ResponseResult getUserPermissions(Integer id) {
        // 1. 获取当前用户拥有的角色
        List<Role> roleList = userMapper.findUserRelationRoleById(id);
        // 2. 获取角色ID，保存到List集合中
        ArrayList<Integer> roleIds = new ArrayList<>();
        for (Role role : roleList) {
            roleIds.add(role.getId());
        }
        // 3.根据角色ID查询父菜单
        List<Menu> parentMenu = userMapper.findParentMenuByRoleId(roleIds);
        // 4.查封封装父菜单关联的子菜单
        for (Menu menu : parentMenu) {
            List<Menu> subMenu = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenu);
        }
        // 5.获取资源信息
        List<Resource> resourceList = userMapper.findResourceByRoleId(roleIds);
        // 6. 封装数据并返回
        Map<String, Object> map = new HashMap<>();
        map.put("menuList",parentMenu);
        map.put("resourceList",resourceList);

        return new ResponseResult(true,200,"获取用户权限信息成功",map);
    }
}
