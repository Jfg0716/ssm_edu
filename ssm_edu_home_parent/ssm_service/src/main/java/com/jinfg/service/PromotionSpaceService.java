package com.jinfg.service;

import com.jinfg.domain.PromotionSpace;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/2 18:17
 */
public interface PromotionSpaceService {

    /* 获取所有的广告位 */
    public List<PromotionSpace> findAllPromotionSpace();

    /*
        添加广告位
     */
    public void savePromotionSpace(PromotionSpace promotionSpace);

    /*
         根据Id查询广告位信息
    */
    public PromotionSpace findPromotionSpaceById(int id);

    /*
         更新广告位名称
     */
    public void updatePromotionSpace(PromotionSpace promotionSpace);
}
