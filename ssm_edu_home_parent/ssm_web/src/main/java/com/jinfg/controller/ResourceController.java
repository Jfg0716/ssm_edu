package com.jinfg.controller;

import com.github.pagehelper.PageInfo;
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

    /*分页与条件查询*/
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVo resourceVo){
        PageInfo<Resource> info = resourceService.findAllResource(resourceVo);
        return new ResponseResult(true,200,"响应成功！",info);
    }
}
