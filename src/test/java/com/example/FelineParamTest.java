package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class FelineParamTest {
    int kittensCount;

    public FelineParamTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }
    @Parameterized.Parameters
    public static Object[][] getKittensCount() {
        return new Object[][] {
                {0},
                {3},
                {-4}
        };
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
        Assert.assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
