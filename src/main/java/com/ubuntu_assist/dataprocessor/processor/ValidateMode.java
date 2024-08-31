package com.ubuntu_assist.dataprocessor.processor;

import com.ubuntu_assist.dataprocessor.database.DatabaseConnector;
import com.ubuntu_assist.dataprocessor.model.DataPoint;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidateMode extends Mode {
    public ValidateMode(DatabaseConnector databaseConnector) {
        super(databaseConnector);
    }

    @Override
    public void process(DataPoint data) {
        if (databaseConnector.validate(data)) {
            databaseConnector.insert(data);
        } else {
            log.info("Validation failed: {}", data.getData());
        }
    }
}