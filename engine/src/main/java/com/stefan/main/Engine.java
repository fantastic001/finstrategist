package com.stefan.main;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import com.stefan.model.*;

public class Engine {

	private KieSession session;

	private KieSession getSession() {
		try {
			System.out.println("Starting application....");
			KieServices ks = KieServices.Factory.get();
			System.out.println("Getting classpath container....");
			KieContainer kContainer = ks.getKieClasspathContainer();
			System.out.println("Creating session....");
			KieSession kSession = kContainer.newKieSession("ksession-rule");
			kSession.setGlobal("logger", new Logger());
			kSession.setGlobal("config", Configuration.getInstance());
			kSession.getAgenda().getAgendaGroup( "portfolio").setFocus();
			kSession.getAgenda().getAgendaGroup( "decide").setFocus();
			kSession.getAgenda().getAgendaGroup( "estimate").setFocus();
			kSession.getAgenda().getAgendaGroup( "collect").setFocus();
			kSession.getAgenda().getAgendaGroup( "preprocess").setFocus();
			return kSession;
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}

	public Engine(Collection<Stock> stocks, Portfolio portfolio, Collection<CompanyInfo> infos) {
		session = getSession();
		for (Stock stock : stocks) {
			session.insert(stock);
		}
		for (PortfolioAsset asset : portfolio.getAssets()) {
			session.insert(asset);
		}
		for (CompanyInfo info : infos) {
			session.insert(info);
		}
		session.insert(portfolio);
	}

	public Portfolio decideOnStock(Stock stock) {
		try { 
			FactHandle fact1;
			System.out.println("Inserting object into session");
			if (session == null) System.out.println("kSession is null!");
			session.insert(stock);

			session.fireAllRules();

			Collection<PortfolioAsset> assets = session.getObjects(x -> x instanceof PortfolioAsset).stream().map(x -> {
				return (PortfolioAsset) x;
			}).collect(Collectors.toList());

			float cash =  session.getObjects(x -> x instanceof Portfolio).stream().map(x -> {
				return (Portfolio) x;
			}).findFirst().get().getCash();
			Portfolio result = new Portfolio(assets, cash);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return null;
	}

}
