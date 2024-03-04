package com.capgemini.training.testing.logic.impl;

import com.capgemini.training.testing.logic.InjectedUc;
import com.capgemini.training.testing.logic.MainUc;
import org.springframework.stereotype.Component;

@Component
public class MainUcImpl implements MainUc {

    private InjectedUc injectedUc;

    public MainUcImpl(InjectedUc injectedUc) {

        this.injectedUc = injectedUc;
    }

    @Override
    public String doSomethingMain() {

        String mainGreeting = "Hello from Main Use Case!";
        String injectedGreeting = this.injectedUc.doSomethingInjected();

        return injectedGreeting != null ? mainGreeting + " " + injectedGreeting : mainGreeting;
    }

    @Override
    public int rollDieMain(boolean shouldUseInjectedUc) {

        if (shouldUseInjectedUc) {
            return this.injectedUc.rollDieInjected();
        }
        return 4;
    }
}
