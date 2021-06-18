package com.jinfg.controller;

import com.github.pagehelper.PageInfo;
import com.jinfg.dao.ResourceMapper;
import com.jinfg.domain.Resource;
import com.jinfg.domain.ResourceVo;
import com.jinfg.domain.ResponseResult;
import com.jinfg.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinfg
 * @date 2021/6/3 16:40
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    /* 资源信息分页&条件查询 */
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVo resourceVo){
        PageInfo<Resource> info = resourceService.findAllResource(resourceVo);
        return new ResponseResult(true,200,"响应成功！",info);
    }

    /* 添加&更新资源信息 */
    @RequestMapping("/saveOrUpdateResource")
    public ResponseResult saveOrUpdateResource(@RequestBody Resource resource){
        ResponseResult result = null;
        if (resource.getId() == null){
            resourceService.saveResource(resource);
            result = new ResponseResult(true,200,"响应成功！",null);
        } else {
            resourceService.updateResource(resource);
            result = new ResponseResult(true,200,"响应成功！",null);
        }
        return result;
    }
}
