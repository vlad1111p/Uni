package com.example.ex1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class CommandLineRunnerWithSetterInjection implements CommandLineRunner {

    private DummyLogger dummyLogger;

    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunnerWithSetterInjection");
        dummyLogger.sayHello();
    }
    @Autowired
    public CommandLineRunnerWithSetterInjection setDummyLogger(DummyLogger dummyLogger) {
        this.dummyLogger = dummyLogger;
        return this;
    }
}
