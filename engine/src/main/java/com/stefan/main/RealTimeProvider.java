package com.stefan.main;

import java.time.LocalDate;

public class RealTimeProvider implements TimeProvider {

    @Override
    public LocalDate getToday() {
        return LocalDate.now();
    }
    
}