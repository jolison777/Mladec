package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedClass;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("MLA JUNIT TEST")
@SelectClasses({
	TestCalculator.class
})
public class TestCalculator {
    Calculatorex obj;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all the test cases");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each test method");
        obj = new Calculatorex(); // initialize before each test
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all test cases");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each test method");
        obj=null;
    }

    @Test
    @Timeout(value=5,unit=TimeUnit.SECONDS)
    public void testAdd() {
        System.out.println("test add method");
        assertEquals(5, obj.add(2,3));
    }

    @Test
    public void testSub() {
        System.out.println("test Sub method");
        assertEquals(1, obj.sub(3,2));
    }

    @Test
    public void testMul() {
        System.out.println("test mul method");
        assertEquals(6, obj.mul(2,3));
    }

    @Test
    public void testListNames() {
        System.out.println("test list data");
        List<String> names=Arrays.asList("rohit","dhoni","kholi","sky");
        assertEquals(4, obj.listNames(names).size());
    }

    @Test
    public void testGreetUser() {
        System.out.println("test GreetUser method");
        assertEquals("hello, hi bye",obj.greetUser("hello, hi bye"));
    }
    @ParameterizedTest
    @ValueSource(strings= {"",""})
    public void testIsEmpty(String str) {
    	Assertions.assertTrue(obj.isEmpty(str));
    }
    
    @Test
    public void testAge() {
    	IllegalArgumentException excp=assertThrows(IllegalArgumentException.class,()->obj.checkAge(-5));
    	assertEquals("age must be greater than zero", excp.getMessage());}
   
}
