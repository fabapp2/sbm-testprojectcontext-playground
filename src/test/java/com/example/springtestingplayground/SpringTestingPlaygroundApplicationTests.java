package com.example.springtestingplayground;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest
class SpringTestingPlaygroundApplicationTests {

    @MockBean
    private ApplicationEventPublisher eventPublisher;

    @Test
    void contextLoads() {

    }

}
