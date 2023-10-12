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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

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
    public void createLionObjectTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        boolean isLionObject = lion instanceof Lion;
        Assert.assertEquals(true, isLionObject);
    }
    @Test
    public void createLionExceptionObjectTest() throws Exception {
        Throwable thrown = assertThrows(Exception.class, () -> {
            new Lion(feline, "");
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Mockito.lenient().when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        List<String> foodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.lenient().when(feline.getFood("Хищник")).thenReturn(foodList);
        Assert.assertEquals(foodList, lion.getFood());
    }
}
