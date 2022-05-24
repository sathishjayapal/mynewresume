package me.sathish.resumemaker.service;

import org.junit.jupiter.api.*;

class WordResumeMakerServiceTest {


    @BeforeAll
    public static void beforeClass() {
        // This method will be executed once on initialization time
    }

    @AfterAll
    public static void afterClass() {
        // This method will be executed once when all test are executed
    }

    @BeforeEach
    public void before() {

    }

    @AfterEach
    public void after() {
        // This method will be executed once after each test execution
    }


    @Test
    void makeResume() {
        Assertions.assertTrue(1 == 1);
    }
}
