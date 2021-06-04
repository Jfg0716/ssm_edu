package com.jinfg.service;

import com.github.pagehelper.PageInfo;
import com.jinfg.domain.PromotionAd;
import com.jinfg.domain.PromotionAdVO;

/**
 * @author jinfg
 * @date 2021/6/3 10:12
 */
public interface PromotionAdService {
    /* 分页获取所有的广告列表 */
    public PageInfo findAllAdByPage(PromotionAdVO adVo);

    /*增加、更新广告*/
    void savePromotionAd(PromotionAd promotionAd);
    void updatePromotionAd(PromotionAd promotionAd);

    /* 回显广告信息 */
    PromotionAd findPromotionAdById(int id);

    /*
         广告动态上下线
     */
    public void  updatePromotionAdStatus(int id,int status);
}
