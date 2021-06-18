package com.jinfg.controller;

import com.github.pagehelper.PageInfo;
import com.jinfg.domain.ResponseResult;
import com.jinfg.domain.Role;
import com.jinfg.domain.User;
import com.jinfg.domain.UserVo;
import com.jinfg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author jinfg
 * @date 2021/6/3 11:27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /* 用户分页&条件查询 */
    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo){
        PageInfo pageInfo = userService.findAllUserByPage(userVo);
        ResponseResult responseResult = new ResponseResult(true,200,"响应成 功",pageInfo);
        List<User> list = pageInfo.getList();
        System.out.println(list);
        return responseResult;
    }

    /* 用户登录 */
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User login = userService.login(user);
        ResponseResult result = null;
        if (login != null){
            //保存access_token
            Map<String,Object> map = new HashMap<>();
            String access_token = UUID.randomUUID().toString();
            map.put("access_token",access_token);
            map.put("user_id",login.getId());

            HttpSession session = request.getSession();
            session.setAttribute("user_id",login.getId());
            session.setAttribute("access_token",access_token);

            map.put("user",user);
            result = new ResponseResult(true,1,"响应成功",map);
        } else {
            result = new ResponseResult(true,1,"用户名密码错误",null);
        }
        return result;
    }

    /* 分配角色（回显） */
    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRelationRoleById(Integer id){
        List<Role> roleList = userService.findUserRelationRoleById(id);
        return  new ResponseResult(true,200,"分配角色回显成功",roleList);
    }


    /* 分配角色  */
    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVo userVo){
        userService.userContextRole(userVo);
        return new ResponseResult(true,200,"分配角色成功",null);
    }

    /*  获取用户权限，进行菜单动态展示 */
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request){
        // 1.获取请求头中的token
        String header_token = request.getHeader("Authorization");
        // 2.获取session中token
        String session_token = (String) request.getSession().getAttribute("access_token");
        // 3.判断token是否一致
        if(header_token.equals(session_token)){
            // 获取用户id
            Integer user_id = (Integer) request.getSession().getAttribute("user_id");
            // 调用service,进行菜单信息查询
            ResponseResult responseResult = userService.getUserPermissions(user_id);
            return responseResult;
        }else {
            ResponseResult responseResult = new ResponseResult(false, 400, "获取菜单信息失败", null);
            return responseResult;
        }
    }

    /* 用户状态设置 */
    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(@RequestParam int id, @RequestParam String status){

        try {
            userService.updateUserStatus(id,status);
            //设置数据响应
            Map<String,Object> map = new HashMap<>();
            map.put("status",status);
            ResponseResult result = new ResponseResult(true,200,"响应成功",map);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
