package com.stefan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeNoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.google.common.annotations.VisibleForTesting;
import com.stefan.main.Configuration;
import com.stefan.main.Engine;
import com.stefan.main.MockTimeProvider;
import com.stefan.main.TimeProvider;
import com.stefan.model.Portfolio;
import com.stefan.model.PortfolioAsset;
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
        Configuration.getInstance().setProperty("expected_growth", 0.0);
        Configuration.getInstance().setProperty("expected_risk", 10000000.0);
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
        assertEquals(160000, result.getCash(), 0.1);
        assertEquals(result.getAssets().size(), 1);
    }

    @Test 
    public void testWholePortfolio() {
        Configuration.getInstance().setProperty("expected_growth", 0.0);
        Configuration.getInstance().setProperty("expected_risk", 10000000.0);
        ArrayList<PortfolioAsset> assets = new ArrayList<>();
        assets.add(new PortfolioAsset("APPL", 100));
        Portfolio portfolio = new Portfolio(assets, 1000000);
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
        assertEquals(160000, result.getCash(), 0.1);
        assertEquals(result.getAssets().size(), 1);
    }


    @Test 
    public void testSelling() {
        Configuration.getInstance().setProperty("expected_growth", 0.3);
        Configuration.getInstance().setProperty("expected_risk", 0.5);
        ArrayList<PortfolioAsset> assets = new ArrayList<>();
        assets.add(new PortfolioAsset("APPL", 100));
        Portfolio portfolio = new Portfolio(assets, 0);
        ArrayList<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("APPL", now.minusDays(6), 5, 70000, 200000, 1, 543543543, 500));
        stocks.add(new Stock("APPL", now.minusDays(5), 5, 7000, 200000, 1, 543543543, 50));       
        stocks.add(new Stock("APPL", now.minusDays(4), 5, 7000, 20000, 1, 543543543, 50));       
        stocks.add(new Stock("APPL", now.minusDays(3), 5, 700, 2000, 1, 543543543, 5));       
        stocks.add(new Stock("APPL", now.minusDays(2), 5, 70, 200, 1, 543543543, 0));       
        stocks.add(new Stock("APPL", now.minusDays(1), 5, 7, 20, 1, 543543543, 0));       
        Engine engine = new Engine(stocks, portfolio, new ArrayList<>());
        engine.setTimeProvider(new MockTimeProvider(now));
        Portfolio result = engine.decideOnStock(new Stock("APPL", now, 5, 6, 20, 1, 543543543, 0));
        assertTrue("Cash in portfolio should increase", result.getCash() > 0.0);
    }
}