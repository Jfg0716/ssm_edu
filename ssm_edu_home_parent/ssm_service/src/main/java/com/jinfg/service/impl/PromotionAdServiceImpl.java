package com.jinfg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinfg.dao.PromotionAdMapper;
import com.jinfg.domain.PromotionAd;
import com.jinfg.domain.PromotionAdVO;
import com.jinfg.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/3 10:17
 */
@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper adMapper;

    @Override
    public PageInfo findAllAdByPage(PromotionAdVO adVo) {
        PageHelper.startPage(adVo.getCurrentPage(),adVo.getPageSize());
        List<PromotionAd> allPromotionAdByPage = adMapper.findAllAdByPage();
        PageInfo<PromotionAd> pageInfo = new PageInfo<>(allPromotionAdByPage);
        return pageInfo;
    }

    @Override
    public void savePromotionAd(PromotionAd promotionAd) {
        adMapper.savePromotionAd(promotionAd);
    }

    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {
        adMapper.updatePromotionAd(promotionAd);
    }

    @Override
    public PromotionAd findPromotionAdById(int id) {
        PromotionAd promotionAd = adMapper.findPromotionAdById(id);
        return promotionAd;
    }

    @Override
    public void updatePromotionAdStatus(int id, int status) {
        // 封装数据
        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(new Date());

        // 调用mapper
        adMapper.updatePromotionAdStatus(promotionAd);

    }
}
