package com.capgemini.training.testing.logic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MainUcTest {

    @Autowired
    private MainUc mainUc;

    @Test
    void doSomething() throws Exception {

        // when
        String result = this.mainUc.doSomethingMain();

        // then
        // assertEquals("Hello from Main Use Case! Hello from Injected Use Case!", result);
        assertThat(result).isEqualTo("Hello from Main Use Case! Hello from Injected Use Case!");
    }

    @Test
    void rollDieShouldUseInjectedUc() throws Exception {

        // given
        boolean shouldUseInjectedUc = true;

        // when
        int result = this.mainUc.rollDieMain(shouldUseInjectedUc);

        // then
        // assertTrue(result >= 1 && result <= 6);
        assertThat(result).isBetween(1, 6);
    }

    @Test
    void rollDieShouldUseMainUc() throws Exception {

        // given
        boolean shouldUseInjectedUc = false;

        // when
        int result = this.mainUc.rollDieMain(shouldUseInjectedUc);

        // then
        assertThat(result).isEqualTo(4);
    }
}