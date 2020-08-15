package com.stefan.main;

import java.time.LocalDate;

public class MockTimeProvider implements TimeProvider {

    private LocalDate valueDate;
    public MockTimeProvider(LocalDate valueDate) {
        this.valueDate = valueDate;
    }
    @Override
    public LocalDate getToday() {
        return this.valueDate;
    }
    
}