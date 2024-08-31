package com.ubuntu_assist.dataprocessor.controller;

import com.ubuntu_assist.dataprocessor.model.DataPoint;
import com.ubuntu_assist.dataprocessor.model.DatabaseIdentifier;
import com.ubuntu_assist.dataprocessor.model.ModeIdentifier;
import com.ubuntu_assist.dataprocessor.processor.Processor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("processor")
public class ProcessorController {
    private final Processor processor;

    public ProcessorController(Processor processor) {
        this.processor = processor;
    }

    @PostMapping("configure")
    public String configure(@RequestParam ModeIdentifier mode, @RequestParam DatabaseIdentifier database) {
        processor.configure(mode, database);
        return "Processor configured to " + mode + " mode with " + database + " database.";
    }

    @PostMapping("process")
    public String process(@RequestBody DataPoint data) {
        processor.process(data);
        return "Processing complete for data: " + data.getData();
    }
}
