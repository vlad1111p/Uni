package com.example.ex1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
@Slf4j
public class FirstDummyLogger implements DummyLogger {

    @Override
    public void sayHello() {
        log.info("From from first");
    }
}