package com.jinfg.service;

import com.github.pagehelper.PageInfo;
import com.jinfg.domain.Resource;
import com.jinfg.domain.ResourceVo;

/**
 * @author jinfg
 * @date 2021/6/3 16:32
 */
public interface ResourceService {
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo);
    void saveResource(Resource resource);
    void updateResource(Resource resource);
}
