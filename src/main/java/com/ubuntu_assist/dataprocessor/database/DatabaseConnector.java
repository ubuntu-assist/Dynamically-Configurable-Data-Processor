package com.ubuntu_assist.dataprocessor.database;

import com.ubuntu_assist.dataprocessor.model.DataPoint;

public interface DatabaseConnector {
    void insert(DataPoint data);
    boolean validate(DataPoint data);
}
