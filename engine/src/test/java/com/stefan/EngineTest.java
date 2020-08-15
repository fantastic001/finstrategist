package com.stefan;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import com.google.common.annotations.VisibleForTesting;
import com.stefan.main.Configuration;
import com.stefan.main.Engine;
import com.stefan.main.MockTimeProvider;
import com.stefan.main.TimeProvider;
import com.stefan.model.Portfolio;
import com.stefan.model.Stock;

import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.Before;
import org.junit.Test;

public class EngineTest {

    private LocalDate now;
    TimeProvider mockTime;
    @Before
    public void setup() {
        now = LocalDate.ofYearDay(2020, 1);
        mockTime = new MockTimeProvider(now);
    }

    @Test 
    public void testOnlyCash() {
        Configuration.getInstance().setProperty("expected_growth", 0);
        Configuration.getInstance().setProperty("expected_risk", 10000000);
        Portfolio portfolio = new Portfolio(new ArrayList<>(), 1000000);
        ArrayList<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("APPL", now.minusDays(6), 5, 7, 20, 1, 543543543, 500));
        stocks.add(new Stock("APPL", now.minusDays(5), 5, 70, 200, 1, 543543543, 500));       
        stocks.add(new Stock("APPL", now.minusDays(4), 5, 700, 2000, 1, 543543543, 500));       
        stocks.add(new Stock("APPL", now.minusDays(3), 5, 7000, 20000, 1, 543543543, 500));       
        stocks.add(new Stock("APPL", now.minusDays(2), 5, 7000, 200000, 1, 543543543, 500));       
        stocks.add(new Stock("APPL", now.minusDays(1), 5, 70000, 20000000, 1, 543543543, 500));       
        Engine engine = new Engine(stocks, portfolio, new ArrayList<>());
        engine.setTimeProvider(new MockTimeProvider(now));
        Portfolio result = engine.decideOnStock(new Stock("APPL", now, 5, 70000, 20000000, 1, 543543543, 500));
        assertEquals(0, result.getCash(), 0.1);
        // engine.decideOnStock(new Stock());
    }
}