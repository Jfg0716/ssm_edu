package com.jinfg.controller;

import com.jinfg.domain.ResourceCategory;
import com.jinfg.domain.ResponseResult;
import com.jinfg.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 17:01
 */
@RestController
@RequestMapping("/resourceCategory")
public class ResourceCategoryController {
    @Autowired
    private ResourceCategoryService categoryService;

    /* 查询资源分类信息 */
    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> allResourceCategory = categoryService.findAllResourceCategory();
        return  new ResponseResult(true,200,"查询所有分类信息成功",allResourceCategory);
    }
}
