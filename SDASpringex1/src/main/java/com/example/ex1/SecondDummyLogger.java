package com.example.ex1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)@Component
@Slf4j
public class SecondDummyLogger implements DummyLogger {

    @Override
    public void sayHello() {
        log.info("From from SecondDummyLogger");
    }
}