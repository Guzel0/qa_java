package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {
    int kittensCount;

    public FelineTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }
    @Parameterized.Parameters
    public static Object[][] getKittensCount() {
        return new Object[][] {
                {2},
                {3},
                {4}
        };
    }

    @Test
    public void test() throws Exception {
        getKittensTest();
        eatMeatTest();
        getFamilyTest();
    }

    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    public void getFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    public void getKittensTest() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
        Assert.assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
