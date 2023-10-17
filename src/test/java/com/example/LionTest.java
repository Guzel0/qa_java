package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void createLionExceptionObjectTest() {
        Throwable thrown = assertThrows(Exception.class, () -> {
            new Lion(feline, "");
        });
        assertNotNull(thrown.getMessage());
    }
}
