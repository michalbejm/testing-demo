package com.capgemini.training.testing.logic.impl;

import com.capgemini.training.testing.logic.InjectedUc;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class InjectedUcImpl implements InjectedUc {
    @Override
    public String doSomethingInjected() {
        return "Hello from Injected Use Case!";
    }

    @Override
    public int rollDieInjected() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
