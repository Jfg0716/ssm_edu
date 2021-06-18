package com.jinfg.dao;

import com.jinfg.domain.*;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 11:22
 */
public interface UserMapper {
    /* 查询所有用户 */
    public List<User> findAllUserByPage(UserVo userVo);

    /* 用户登陆 */
    public User login(User user);

    /*
        根据用户ID清空中间表
     */
    public void deleteUserContextRole(Integer userId);

    /*
        分配角色
     */
    public void userContextRole(User_Role_relation user_role_relation);


    /*1、根据ID查询用户当前角色*/
    public List<Role> findUserRelationRoleById(int id);

    /*
       2. 根据角色ID，查询角色所拥有的顶级菜单（-1）
     */
    public List<Menu> findParentMenuByRoleId(List<Integer> ids);

    /*
       3. 根据PID，查询子菜单信息
     */
    public List<Menu> findSubMenuByPid(Integer pid);

    /*
        4.获取用户拥有的资源权限信息
     */
    public List<Resource> findResourceByRoleId(List<Integer> ids);

    /* 用户状态设置 */
    public void updateUserStatus(User user);
}
