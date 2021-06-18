package com.jinfg.controller;

import com.jinfg.domain.PromotionSpace;
import com.jinfg.domain.ResponseResult;
import com.jinfg.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/2 18:18
 */
@RestController
@RequestMapping("/promotionSpace")
public class PromotionSpaceController {
    @Autowired
    private PromotionSpaceService promotionSpaceService;

    /*广告位列表查询*/
    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){
        List<PromotionSpace> allPromotionSpace =
                promotionSpaceService.findAllPromotionSpace();
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",allPromotionSpace);
        return responseResult;
    }

    /*添加&修改广告位*/
    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace){
        if(promotionSpace.getId() == null){
            //新增
            promotionSpaceService.savePromotionSpace(promotionSpace);
            return  new ResponseResult(true,200,"新增广告位成功",null);
        }else {
            promotionSpaceService.updatePromotionSpace(promotionSpace);
            return  new ResponseResult(true,200,"更新广告位名称成功",null);
        }
    }

    /* 回显广告位名称 */
    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(int id){
        PromotionSpace promotionSpace = promotionSpaceService.findPromotionSpaceById(id);
        return  new ResponseResult(true,200,"查询具体广告位成功",promotionSpace);
    }

}
