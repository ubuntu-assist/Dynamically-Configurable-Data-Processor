package com.ubuntu_assist.dataprocessor.processor;

import com.ubuntu_assist.dataprocessor.model.DataPoint;
import com.ubuntu_assist.dataprocessor.model.DatabaseIdentifier;
import com.ubuntu_assist.dataprocessor.model.ModeIdentifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Processor {
    private Mode mode;
    private final ModeFactory modeFactory;

    public Processor(ModeFactory modeFactory) {
        this.modeFactory = modeFactory;
    }

    public void configure(ModeIdentifier modeIdentifier, DatabaseIdentifier databaseIdentifier) {
        this.mode = modeFactory.create(modeIdentifier, databaseIdentifier);
    }

    public void process(DataPoint data) {
        if (mode != null) {
            mode.process(data);
        } else {
            log.info("Processor not configured with a mode.");
        }
    }
}