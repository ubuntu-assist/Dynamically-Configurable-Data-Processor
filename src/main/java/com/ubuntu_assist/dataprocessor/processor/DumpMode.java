package com.ubuntu_assist.dataprocessor.processor;

import com.ubuntu_assist.dataprocessor.model.DataPoint;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DumpMode extends Mode {
    public DumpMode() {
        super(null); // No database required for dumping
    }

    @Override
    public void process(DataPoint data) {
        log.info("Data dumped: {}", data.getData());
    }
}
