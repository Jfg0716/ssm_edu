package com.jinfg.dao;

import com.jinfg.domain.PromotionAd;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 9:55
 */
public interface PromotionAdMapper {
    /* 分页获取所有的广告列表 */
    public List<PromotionAd> findAllAdByPage();

    //新建、更新广告
    void savePromotionAd(PromotionAd promotionAd);
    void updatePromotionAd(PromotionAd promotionAd);

    /*** 根据id查询广告信息 * */
    PromotionAd findPromotionAdById(int id);

    /*
        广告动态上下线
     */
    void updatePromotionAdStatus(PromotionAd promotionAd);
}
