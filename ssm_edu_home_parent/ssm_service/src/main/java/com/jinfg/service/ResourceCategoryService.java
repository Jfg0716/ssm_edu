package com.jinfg.service;

import com.jinfg.domain.ResourceCategory;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 16:59
 */
public interface ResourceCategoryService {
    /*
    查询所有资源分类
    */
    public List<ResourceCategory> findAllResourceCategory();
}
