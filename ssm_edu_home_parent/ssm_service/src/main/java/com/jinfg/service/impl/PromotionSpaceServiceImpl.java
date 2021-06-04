package com.jinfg.service.impl;

import com.jinfg.dao.PromotionSpaceMapper;
import com.jinfg.domain.PromotionSpace;
import com.jinfg.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author jinfg
 * @date 2021/6/2 18:17
 */
@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {
    @Autowired
    private PromotionSpaceMapper mapper;

    @Override
    public List<PromotionSpace> findAllPromotionSpace() {
        List<PromotionSpace> allPromotionSpace = mapper.findAllPromotionSpace();
        return allPromotionSpace;
    }

    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {
        // 1.封装数据
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        Date date = new Date();
        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        promotionSpace.setIsDel(0);

        // 2.调用mapper方法
        mapper.savePromotionSpace(promotionSpace);
    }

    @Override
    public PromotionSpace findPromotionSpaceById(int id) {
        PromotionSpace promotionSpaceById = mapper.findPromotionSpaceById(id);
        return promotionSpaceById;

    }

    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        // 封装数据
        promotionSpace.setUpdateTime(new Date());

        // 调用mapper
        mapper.updatePromotionSpace(promotionSpace);
    }
}
