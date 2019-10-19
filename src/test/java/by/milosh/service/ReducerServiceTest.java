package by.milosh.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReducerServiceTest {

    private ReducerService reducerService = new ReducerService();

    @Test
    public void testReducerService1() {
        String raw = "1";
        String actual = reducerService.reduce(raw);
        String expected = "1";
        assertEquals(actual, expected);
    }

    @Test
    public void testReducerService2() {
        String raw = "1,2";
        String actual = reducerService.reduce(raw);
        String expected = "1,2";
        assertEquals(actual, expected);
    }


    @Test
    public void testReducerService3() {
        String raw = "1,2,3";
        String actual = reducerService.reduce(raw);
        String expected = "1-3";
        assertEquals(actual, expected);
    }

    @Test
    public void testReducerService4() {
        String raw = "1,3";
        String actual = reducerService.reduce(raw);
        String expected = "1,3";
        assertEquals(actual, expected);
    }

    @Test
    public void testReducerService5() {
        String raw = "1,3,4";
        String actual = reducerService.reduce(raw);
        String expected = "1,3-4";
        assertEquals(actual, expected);
    }

    @Test
    public void testReducerService6() {
        String raw = "1,3,4,5";
        String actual = reducerService.reduce(raw);
        String expected = "1,3-5";
        assertEquals(actual, expected);
    }

    @Test
    public void testReducerService7() {
        String raw = "1,2,5";
        String actual = reducerService.reduce(raw);
        String expected = "1-2,5";
        assertEquals(actual, expected);
    }

    @Test
    public void testReducerService8() {
        String raw = "1,2,5,6";
        String actual = reducerService.reduce(raw);
        String expected = "1-2,5-6";
        assertEquals(actual, expected);
    }

    @Test
    public void testReducerService9() {
        String raw = "1,2,5,6,7";
        String actual = reducerService.reduce(raw);
        String expected = "1-2,5-7";
        assertEquals(actual, expected);
    }

    @Test
    public void testReducerService10() {
        String raw = "1,3,4";
        String actual = reducerService.reduce(raw);
        String expected = "1,3-4";
        assertEquals(actual, expected);
    }

    @Test
    public void testReducerService11() {
        String raw = "1,3,4,5";
        String actual = reducerService.reduce(raw);
        String expected = "1,3-5";
        assertEquals(actual, expected);
    }

    @Test
    public void testReducerService12() {
        String raw = "1,2,3,6";
        String actual = reducerService.reduce(raw);
        String expected = "1-3,6";
        assertEquals(actual, expected);
    }

    @Test
    public void testReducerService13() {
        String raw = "1,2,3,6,7";
        String actual = reducerService.reduce(raw);
        String expected = "1-3,6-7";
        assertEquals(actual, expected);
    }

    @Test
    public void testReducerService14() {
        String raw = "1,3,32,5,11,7,6,19,2,21,4,8,22,23";
        String actual = reducerService.reduce(raw);
        String expected = "1-8,11,19,21-23,32";
        assertEquals(actual, expected);
    }

    @Test
    public void testReducerService15() {
        String raw = "9,1,15,4,13,5,19,14,16,3,17";
        String actual = reducerService.reduce(raw);
        String expected = "1,3-5,9,13-17,19";
        assertEquals(actual, expected);
    }
}
