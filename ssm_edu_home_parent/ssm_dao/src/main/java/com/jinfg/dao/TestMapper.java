package com.jinfg.dao;

import com.jinfg.domain.Test;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/5/31 16:10
 */
public interface TestMapper {
    /*
    *   对test表进行测试
    * */

    public List<Test> findAllTest();
}
