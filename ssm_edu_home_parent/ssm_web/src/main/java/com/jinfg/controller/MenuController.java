package com.jinfg.controller;

import com.jinfg.domain.Menu;
import com.jinfg.domain.ResponseResult;
import com.jinfg.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jinfg
 * @date 2021/6/3 16:13
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    //查询菜单列表信息
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> list = menuService.findAllMenu();
        return new ResponseResult(true,200,"响应成功！",list);
    }

    /* 查询菜单信息(回显) */
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(Integer id){
        // 根据id的值判断当前是更新还是添加操作 判断id的值是否为-1
        if(id == -1){
            // 添加 回显信息中不需要查询menu信息
            List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(-1);
            // 封装数据
            Map<String, Object> map = new HashMap<>();
            map.put("menuInfo",null);
            map.put("parentMenuList",subMenuListByPid);
            return new ResponseResult(true,200,"添加回显成功",map);
        }else {
            //修改操作 回显所有menu信息
            Menu menu =  menuService.findMenuById(id);
            List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(-1);
            // 封装数据
            Map<String, Object> map = new HashMap<>();
            map.put("menuInfo",menu);
            map.put("parentMenuList",subMenuListByPid);
            return new ResponseResult(true,200,"修改回显成功",map);
        }

    }

    /*  添加&修改菜单 saveOrUpdateMenu */
    @RequestMapping("/saveOrUpdateMenu")
    public ResponseResult saveOrUpdateMenu(@RequestBody Menu menu){

        ResponseResult result = null;
        if (menu.getId() == null){
            //新增
            menuService.saveMenu(menu);
            result = new ResponseResult(true,200,"响应成功",null);

        } else {
            //修改
            menuService.updateMenu(menu);
            result = new ResponseResult(true,200,"响应成功",null);

        }
        return result;
    }


}
