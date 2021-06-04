package com.jinfg.service.impl;

import com.jinfg.dao.ResourceCategoryMapper;
import com.jinfg.domain.ResourceCategory;
import com.jinfg.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 17:00
 */
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {
    @Autowired
    private ResourceCategoryMapper mapper;

    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        List<ResourceCategory> list = mapper.findAllResourceCategory();
        return list;
    }
}
