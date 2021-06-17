package com.vickllny.metro.prompt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TrainData implements Serializable {
    private String address;
    private String time;
    private String train;

}
