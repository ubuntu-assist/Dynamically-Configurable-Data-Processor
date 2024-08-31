package com.ubuntu_assist.dataprocessor.processor;

import com.ubuntu_assist.dataprocessor.database.DatabaseConnector;
import com.ubuntu_assist.dataprocessor.model.DataPoint;

public abstract class Mode {
    protected DatabaseConnector databaseConnector;

    Mode(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public abstract void process(DataPoint data);
}


