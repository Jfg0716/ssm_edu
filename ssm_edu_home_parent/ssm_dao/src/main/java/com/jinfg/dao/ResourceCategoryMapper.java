package com.jinfg.dao;

import com.jinfg.domain.ResourceCategory;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 16:57
 */
public interface ResourceCategoryMapper {
    /*
        查询所有资源分类
     */
    public List<ResourceCategory> findAllResourceCategory();
}
