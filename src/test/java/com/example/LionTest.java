package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    String sex;
    boolean hasMane;

    public LionTest(
            String sex,
            boolean hasMane
    ) {
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Parameterized.Parameters
    public static Object[][] getGenders() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Feline feline;

    @Test
    public void test() throws Exception {
        getKittensTest();
        doesHaveManeTest();
        getFoodTest();
    }

    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Mockito.lenient().when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(hasMane, lion.doesHaveMane());
    }

    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Mockito.lenient().when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
