package com.stefan;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import com.google.common.annotations.VisibleForTesting;
import com.stefan.main.Engine;
import com.stefan.main.MockTimeProvider;
import com.stefan.model.Portfolio;
import com.stefan.model.Stock;

import org.junit.Before;
import org.junit.Test;

public class EngineTest {

    private Engine engine;

    @Before
    public void setup() {
        engine = new Engine(new ArrayList<>(), new Portfolio(new ArrayList<>(), 0), new ArrayList<>());
        LocalDate now = LocalDate.ofYearDay(2020, 1);
        engine.setTimeProvider(new MockTimeProvider(now));
    }

    @Test 
    public void testBasic() {
        // engine.decideOnStock(new Stock());
    }
}