package com.ubuntu_assist.dataprocessor.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataPoint {
    private String data;

    public DataPoint(String data) {
        this.data = data;
    }
}
