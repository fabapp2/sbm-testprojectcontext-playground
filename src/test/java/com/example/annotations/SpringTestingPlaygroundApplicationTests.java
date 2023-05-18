package com.example.annotations;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
class SpringTestingPlaygroundApplicationTests {

    @MockBean
    private ApplicationEventPublisher eventPublisher;

//    @Autowired
//    private BeanFactory beanFactory;

    @Autowired
    private TheBean myBeanAutowired;

    @Test
    void contextLoads() {
//        TheBean bean = beanFactory.getBean(TheBean.class);
        ApplicationEvent applicationEvent = new ApplicationEvent("message");
        myBeanAutowired.publishEvent(applicationEvent);
        assertThat(myBeanAutowired.getApplicationEventPublisher()).isSameAs(eventPublisher);
        ArgumentCaptor<Object> objectArgumentCaptor = ArgumentCaptor.forClass(Object.class);
        verify(eventPublisher).publishEvent(objectArgumentCaptor.capture());
        assertThat(objectArgumentCaptor.getValue()).isSameAs(applicationEvent);
    }


    private record ApplicationEvent(String message) {}
}



