package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MathServiceTest extends AbstractTestClass{

    @ParameterizedTest
    @ValueSource(ints = {0, -12, -27, 4})
    public void testGetD(int expected){
        if (expected == 0){
            int actual = mathService.getD(0, 0, 0);
            Assertions.assertEquals(expected, actual);
        }
        if (expected == -12){
            int actual = mathService.getD(-2, -2, -2);
            Assertions.assertEquals(expected, actual);
        }
        if (expected == -27){
            int actual = mathService.getD(3, 3, 3);
            Assertions.assertEquals(expected, actual);
        }
        if (expected == 4){
            int actual = mathService.getD(0, -2, 3);
            Assertions.assertEquals(expected, actual);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void testGetAnswer(int testNumber) throws Exception {
        if (testNumber == 1){
            Pair result = mathService.getAnswer(1, 10, 10);
            Assertions.assertEquals(-0.751344435861722, result.first);
            Assertions.assertEquals(-5.915322230804944, result.second);
        }
        if (testNumber == 2){
            Pair result = mathService.getAnswer(0, 10, -10);
            Assertions.assertEquals(0.0, result.first);
            Assertions.assertEquals(-10.0, result.second);
        }

    }

    @Test
    public void testGetNotFoundAnswerException(){
        Assertions.assertThrows(NotFoundAnswerException.class, () -> mathService.getAnswer(1, 2, 3));
    }

    @Test
    public void testGetArithmeticException(){
        Assertions.assertThrows(ArithmeticException.class, () -> mathService.getAnswer(0, 0, 0));
    }
}
