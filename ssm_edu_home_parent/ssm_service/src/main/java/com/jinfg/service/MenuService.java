package com.jinfg.service;

import com.jinfg.domain.Menu;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 15:30
 */
public interface MenuService {

    /*
        查询所有父子菜单信息
     */

    public List<Menu> findSubMenuListByPid(int pid);

    public List<Menu> findAllMenu();

    Menu findMenuById(Integer id);

    void saveMenu(Menu menu);
    void updateMenu(Menu menu);
}
