package com.ubuntu_assist.dataprocessor.processor;

import com.ubuntu_assist.dataprocessor.database.DatabaseConnector;
import com.ubuntu_assist.dataprocessor.model.DataPoint;

public class PassThroughMode extends Mode {
    public PassThroughMode(DatabaseConnector databaseConnector) {
        super(databaseConnector);
    }

    @Override
    public void process(DataPoint data) {
        databaseConnector.insert(data);
    }
}
