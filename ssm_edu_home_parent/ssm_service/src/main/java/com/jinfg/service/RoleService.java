package com.jinfg.service;

import com.jinfg.domain.Role;
import com.jinfg.domain.RoleMenuVo;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 11:49
 */
public interface RoleService {
    /*
        查询所有角色（条件）
     */
    public List<Role> findAllRole(Role role);

    /*** 根据ID查询角色关联菜单 * */
    List<String> findMenuByRoleId(Integer roleId);

    void roleContextMenu(RoleMenuVo roleMenuVo);

    void deleteRole(Integer id);

    void saveRole(Role role);
    void updateRole(Role role);
}
