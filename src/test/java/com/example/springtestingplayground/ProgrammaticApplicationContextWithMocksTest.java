/*
 * Copyright 2021 - 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.springtestingplayground;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Fabian Krüger
 */
public class ProgrammaticApplicationContextWithMocksTest {

    private ApplicationEventPublisher eventPublisher;

    @Test
    void test_renameMe() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(beanFactory);
        Field field = ReflectionUtils.findField(ProgrammaticApplicationContextWithMocksTest.class, "eventPublisher");
        MockDefinition mockDefinition = new MockDefinition("applicationEventPublisher", ResolvableType.forClass(
                ApplicationEventPublisher.class), new Class[0], null, false, MockReset.NONE, new QualifierDefinition(field,
                                                                                                            Set.of()));
        applicationContext.addBeanFactoryPostProcessor(new MockitoPostProcessor(Set.of(mockDefinition)));
        applicationContext.register(MyBean.class);
        applicationContext.refresh();

        ApplicationEventPublisher bean = applicationContext.getBean(ApplicationEventPublisher.class);
        MyBean myBean = applicationContext.getBean(MyBean.class);
        assertThat(myBean.getEventPublisher()).isSameAs(bean);
    }
}
