package com.jinfg.service.impl;

import com.jinfg.dao.RoleMapper;
import com.jinfg.domain.Role;
import com.jinfg.domain.RoleMenuVo;
import com.jinfg.domain.Role_menu_relation;
import com.jinfg.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author jinfg
 * @date 2021/6/3 11:49
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    Date date = new Date();

    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> roles = roleMapper.findAllRole(role);
        return roles;
    }

    @Override
    public List<String> findMenuByRoleId(Integer roleId) {
        List<String> byRoleId = roleMapper.findMenuByRoleId(roleId);
        return byRoleId;
    }

    @Override
    public void roleContextMenu(RoleMenuVo roleMenuVo) {
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());
        //2. 为角色分配菜单
        for (Integer mid : roleMenuVo.getMenuIdList()) {

            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setRoleId(roleMenuVo.getRoleId());

            //封装数据
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");


            roleMapper.roleContextMenu(role_menu_relation);
        }
    }

    @Override
    public void deleteRole(Integer id) {
        // 清空中间表
        roleMapper.deleteRoleContextMenu(id);
        roleMapper.deleteRole(id);
    }

    @Override
    public void saveRole(Role role) {
        //补全数据
        role.setCreatedTime(date);
        role.setUpdatedTime(date);
        role.setCreatedBy("system");
        role.setUpdatedBy("system");
        roleMapper.saveRole(role);
    }

    @Override
    public void updateRole(Role role) {
        //补全数据
        role.setUpdatedTime(date);
        role.setUpdatedBy("system");
        roleMapper.updateRole(role);
    }
}
