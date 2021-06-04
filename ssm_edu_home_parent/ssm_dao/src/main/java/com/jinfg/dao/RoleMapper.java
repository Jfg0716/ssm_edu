package com.jinfg.dao;

import com.jinfg.domain.PromotionAd;
import com.jinfg.domain.Role;
import com.jinfg.domain.Role_menu_relation;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 11:45
 */
public interface RoleMapper {
    /* 查询角色列表(条件) */
    public List<Role> findAllRole(Role role);

    //新增、修改
    /*void saveRole(Role role);
    void updateRole(Role role);*/

    /* 根据角色ID查询菜单信息 */
    List<String> findMenuByRoleId(Integer roleId);

    /*
        根据roleid清空中间表的关联关系
     */
    public void deleteRoleContextMenu(Integer rid);

    /* 角色菜单关联 */
    void roleContextMenu(Role_menu_relation role_menu_relation);

    /* 删除角色 */
    void deleteRole(Integer id);

}
