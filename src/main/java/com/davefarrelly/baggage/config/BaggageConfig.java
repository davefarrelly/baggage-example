package com.davefarrelly.baggage.config;

import brave.baggage.BaggageField;
import brave.baggage.CorrelationScopeConfig;
import brave.context.slf4j.MDCScopeDecorator;
import brave.propagation.CurrentTraceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaggageConfig {

    public static final String USER_ID_KEY = "USER_ID";

    @Bean
    BaggageField userNameField() {
        return BaggageField.create(USER_ID_KEY);
    }

    @Bean
    public CurrentTraceContext.ScopeDecorator mdcScopeDecorator(BaggageField userNameField) {
        return MDCScopeDecorator.newBuilder()
                .clear()
                .add(CorrelationScopeConfig.SingleCorrelationField.newBuilder(userNameField).flushOnUpdate().build())
                .build();
    }
}
