package org.example;

import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTestClass {

    public MathService mathService;

    @BeforeEach
    public void setUp(){
        mathService = new MathService();
    }
}
