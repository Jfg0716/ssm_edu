package com.jinfg.service.impl;

import com.jinfg.dao.TestMapper;
import com.jinfg.domain.Test;
import com.jinfg.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/5/31 16:23
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAllTest() {
        List<Test> list = testMapper.findAllTest();
        return list;
    }
}
