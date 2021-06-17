package com.vickllny.metro.prompt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class TrainDataVo implements Serializable {
    private String id;
    private String name;
    private List<TrainData> list;
    /**
     * 1->正常  0->禁用
     */
    private int status;
    /**
     * 文件绝对路径
     */
    private String fileAbsolutePath;
}
