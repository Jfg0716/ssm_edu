package com.jinfg.domain;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 15:53
 */
public class RoleMenuVo {
    private Integer roleId;

    private List<Integer> menuIdList;

    @Override
    public String toString() {
        return "RoleMenuVo{" +
                "roleId=" + roleId +
                ", menuIdList=" + menuIdList +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Integer> menuIdList) {
        this.menuIdList = menuIdList;
    }
}
