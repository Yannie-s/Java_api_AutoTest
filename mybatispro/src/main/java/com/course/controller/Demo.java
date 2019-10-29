package com.course.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Log4j
@RestController
@Api(value="v1",description="this is my first demo")
@RequestMapping("v1")
public class Demo {
    @Autowired
    private SqlSessionTemplate template;
    @RequestMapping(value="/getUserCount",method= RequestMethod.GET)
    @ApiOperation(value="the number of users can get",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }

}
