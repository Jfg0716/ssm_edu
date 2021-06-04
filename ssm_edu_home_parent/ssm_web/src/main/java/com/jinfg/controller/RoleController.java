package com.jinfg.controller;

import com.jinfg.domain.Menu;
import com.jinfg.domain.ResponseResult;
import com.jinfg.domain.Role;
import com.jinfg.domain.RoleMenuVo;
import com.jinfg.service.MenuService;
import com.jinfg.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 11:51
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){
        try {
            List<Role> allRole = roleService.findAllRole(role);
            ResponseResult result = new ResponseResult(true, 200, "响应成功！", allRole);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> listByPid = menuService.findSubMenuListByPid(-1);
        HashMap<String, Object> map = new HashMap<>();
        map.put("parentMenuList",listByPid);
        ResponseResult result = new ResponseResult(true, 200, "响应成功！查询所有的父子菜单信息！", map);
        return result;
    }

    /*** 查询角色关联菜单列表ID * */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){
        List<String> list = roleService.findMenuByRoleId(roleId);
        return new ResponseResult(true, 200, "响应成功！", list);
    }

    /*
    * 用户关联菜单 {roleId: 4, menuIdList: [19, 20, 7, 8, 9, 15, 16, 17, 18]}
    */
    @RequestMapping("/roleContextMenu")
    public ResponseResult roleContextMenu(@RequestBody RoleMenuVo roleMenuVo){
        roleService.roleContextMenu(roleMenuVo);
        return new ResponseResult(true,200,"响应成功！",null);
    }

    /** * 删除角色 * */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){
        roleService.deleteRole(id);
        return new ResponseResult(true,200,"删除成功！",null);
    }
}
