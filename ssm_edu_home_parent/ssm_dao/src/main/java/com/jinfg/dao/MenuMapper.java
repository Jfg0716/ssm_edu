package com.jinfg.dao;

import com.jinfg.domain.Menu;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 15:23
 */
public interface MenuMapper {
    /* 查询全部的父子菜单信息 */
    public List<Menu> findSubMenuListByPid(int pid);

    /* 查询菜单列表 */
    public List<Menu> findAllMenu();

    Menu findMenuById(Integer id);

    public void saveMenu(Menu menu);
    public void updateMenu(Menu menu);

}
