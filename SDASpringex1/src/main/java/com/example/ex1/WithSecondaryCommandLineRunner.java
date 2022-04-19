package com.example.ex1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
@Slf4j
@Component
public class WithSecondaryCommandLineRunner implements CommandLineRunner {

    private final DummyLogger dummyLogger;

    public WithSecondaryCommandLineRunner(@Qualifier("secondDummyLogger") final DummyLogger dummyLogger) {
        this.dummyLogger = dummyLogger;
    }

    @Override
    public void run(final String... args) throws Exception {
        log.info("lol");
        dummyLogger.sayHello();
    }
}