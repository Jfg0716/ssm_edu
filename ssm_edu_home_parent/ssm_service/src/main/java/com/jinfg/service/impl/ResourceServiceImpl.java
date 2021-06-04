package com.jinfg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinfg.dao.ResourceMapper;
import com.jinfg.domain.Resource;
import com.jinfg.domain.ResourceVo;
import com.jinfg.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 16:32
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo) {
        //分页查询
        PageHelper.startPage(resourceVo.getCurrentPage(),resourceVo.getPageSize());
        List<Resource> list = resourceMapper.findAllResource(resourceVo);
        PageInfo<Resource> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
