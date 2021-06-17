package com.vickllny.metro.prompt.controller;

import com.vickllny.metro.prompt.entity.TrainDataVo;
import com.vickllny.metro.prompt.service.TrainDataService;
import com.vickllny.metro.prompt.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/data")
public class DataController {

    @Autowired
    private TrainDataService trainDataService;

    @PostMapping(value = "/train")
    public JsonResult<String> train(@RequestBody TrainDataVo vo){
        try {
            trainDataService.save(vo);
            return new JsonResult<String>().success();
        }catch(Exception e){
            log.error("存储数据异常!",e );
            return new JsonResult<String>().error();
        }
    }
}
