package com.jinfg.controller;

import com.jinfg.service.TestService;

import com.jinfg.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/5/31 16:28
 */
@RestController //@Controller + @ResponseBody
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    //查询test

    @RequestMapping("/findAllTest")
    public List<Test> findAllTest(){
        List<Test> list = testService.findAllTest();
        return list;
    }

}
