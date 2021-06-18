package com.jinfg.dao;

import com.jinfg.domain.Resource;
import com.jinfg.domain.ResourceVo;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 16:28
 */
public interface ResourceMapper {
    /* 查询 */
    public List<Resource> findAllResource(ResourceVo resourceVo);
    /* 新增*/
    public void saveResource(Resource resource);
    /* 修改*/
    void updateResource(Resource resource);

}
