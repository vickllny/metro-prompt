package com.vickllny.metro.prompt.service;

import com.alibaba.fastjson.JSONObject;
import com.vickllny.metro.prompt.config.CustomerConfig;
import com.vickllny.metro.prompt.entity.TrainDataVo;
import com.vickllny.metro.prompt.utils.DateUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Service
public class TrainDataService {

    @Autowired
    private CustomerConfig customerConfig;

    public void save(TrainDataVo vo) throws IOException {
        final long timestamp = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        String id = String.valueOf(timestamp);
        vo.setId(id);
        final String dateHash = DateUtil.dateHash();
        final StringBuilder pathBuilder = new StringBuilder(customerConfig.getTrainFilePrefix()).append(File.separator).append(dateHash).append(File.separator).append(id).append(".json");
        final String path = pathBuilder.toString();
        final File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        vo.setFileAbsolutePath(path);
        final String jsonString = JSONObject.toJSONString(vo);
        FileUtils.writeStringToFile(file, jsonString, StandardCharsets.UTF_8, false);
    }

    public void update(TrainDataVo vo) throws IOException {
        final String fileAbsolutePath = vo.getFileAbsolutePath();
        Objects.requireNonNull(fileAbsolutePath, "fileAbsolutePath 不能为null");
        final File file = new File(fileAbsolutePath);
        final String jsonString = JSONObject.toJSONString(vo);
        FileUtils.writeStringToFile(file, jsonString, StandardCharsets.UTF_8, false);
    }
}
