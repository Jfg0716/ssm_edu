package com.jinfg.service;

import com.github.pagehelper.PageInfo;
import com.jinfg.domain.ResponseResult;
import com.jinfg.domain.Role;
import com.jinfg.domain.User;
import com.jinfg.domain.UserVo;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 11:25
 */
public interface UserService {
    /*
        用户分页&多条件查询
     */
    public PageInfo findAllUserByPage(UserVo userVo);

    /*用户登录*/
    public User login(User user) throws Exception;

    /*
        分配角色（回显）
     */
    public List<Role> findUserRelationRoleById(Integer id);

    /*
        用户关联角色
     */
    public void userContextRole(UserVo userVo);

    /*
        获取用户权限，进行菜单动态展示:getUserPermissions
     */
    public ResponseResult getUserPermissions(Integer id);

    /*
    用户状态设置
    */
    public void updateUserStatus(int id, String status);
}
