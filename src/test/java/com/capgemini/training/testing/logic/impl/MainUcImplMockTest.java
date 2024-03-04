package com.capgemini.training.testing.logic.impl;

import com.capgemini.training.testing.logic.InjectedUc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MainUcImplMockTest {

    @InjectMocks
    private MainUcImpl mainUc;

    @Mock
    private InjectedUc injectedUc;

    @Test
    void doSomethingWithMocking() {

        // given
        String mainResponse = "Hello from Main Use Case!";
        String mockedResponse = "Mocked Response";

        when(this.injectedUc.doSomethingInjected()).thenReturn(mockedResponse);

        // when
        String result = this.mainUc.doSomethingMain();

        // then
        // assertEquals(mainResponse + " " + mockedResponse, result);
        assertThat(result).isEqualTo(mainResponse + " " + mockedResponse);
    }

    @Test
    void doSomethingWithMockingReturnNull() {

        // given
        String mainResponse = "Hello from Main Use Case!";

        when(this.injectedUc.doSomethingInjected()).thenReturn(null);

        // when
        String result = this.mainUc.doSomethingMain();

        // then
        // assertEquals(mainResponse, result);
        assertThat(result).isEqualTo(mainResponse);
    }

    @Test
    void rollDieShouldUseInjectedUc() {

        // given
        boolean shouldUseInjectedUc = true;

        when(this.injectedUc.rollDieInjected()).thenReturn(0);

        // when
        int result = this.mainUc.rollDieMain(shouldUseInjectedUc);

        // then
        // assertEquals(0, result);
        assertThat(result).isEqualTo(0);
        verify(this.injectedUc, times(1)).rollDieInjected();
    }

    @Test
    void rollDieShouldUseMainUc() {

        // given
        boolean shouldUseInjectedUc = false;

        // when
        int result = this.mainUc.rollDieMain(shouldUseInjectedUc);

        // then
        // assertEquals(4, result);
        assertThat(result).isEqualTo(4);
        verify(this.injectedUc, never()).rollDieInjected();
    }
}