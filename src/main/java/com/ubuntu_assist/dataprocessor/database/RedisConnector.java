package com.ubuntu_assist.dataprocessor.database;

import com.ubuntu_assist.dataprocessor.model.DataPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisConnector implements DatabaseConnector {
    @Override
    public void insert(DataPoint data) {
        log.info("Inserting data into Redis: {}", data.getData());
    }

    @Override
    public boolean validate(DataPoint data) {
        log.info("Validating data against Redis: {}", data.getData());
        return true; // Assume validation is successful
    }
}
