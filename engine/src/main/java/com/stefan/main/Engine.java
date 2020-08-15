package com.stefan.main;

import org.drools.core.event.DebugAgendaEventListener;
import org.kie.api.KieServices;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
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
	private TimeProvider timeProvider;

	private KieSession getSession() {
		try {
			System.out.println("Starting application....");
			KieServices ks = KieServices.Factory.get();
			System.out.println("Getting classpath container....");
			KieContainer kContainer = ks.getKieClasspathContainer();
			System.out.println("Creating session....");
			KieSession kSession = kContainer.newKieSession("ksession-rule");
			kSession.setGlobal("logger", new Logger());
			kSession.setGlobal("timeProvider", timeProvider);
			kSession.setGlobal("config", Configuration.getInstance());
			kSession.getAgenda().getAgendaGroup("portfolio").setFocus();
			kSession.getAgenda().getAgendaGroup("decide").setFocus();
			kSession.getAgenda().getAgendaGroup("estimate").setFocus();
			kSession.getAgenda().getAgendaGroup("collect").setFocus();
			kSession.getAgenda().getAgendaGroup("preprocess").setFocus();
			kSession.addEventListener(new AgendaEventListener(){

				@Override
				public void matchCreated(MatchCreatedEvent event) {
					// TODO Auto-generated method stub

				}

				@Override
				public void matchCancelled(MatchCancelledEvent event) {
					// TODO Auto-generated method stub

				}

				@Override
				public void beforeMatchFired(BeforeMatchFiredEvent event) {
					System.out.println("MATCH: "+ event.getMatch().getRule().getName());

				}

				@Override
				public void afterMatchFired(AfterMatchFiredEvent event) {
					// TODO Auto-generated method stub

				}

				@Override
				public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
					// TODO Auto-generated method stub

				}

				@Override
				public void agendaGroupPushed(AgendaGroupPushedEvent event) {
					// TODO Auto-generated method stub

				}

				@Override
				public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
					// TODO Auto-generated method stub

				}

				@Override
				public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
					// TODO Auto-generated method stub

				}

				@Override
				public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
					// TODO Auto-generated method stub

				}

				@Override
				public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
					// TODO Auto-generated method stub

				}
				
			});
			return kSession;
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}

	public Engine(Collection<Stock> stocks, Portfolio portfolio, Collection<CompanyInfo> infos) {
		timeProvider = new RealTimeProvider();
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
			result.setId(null);
			return result;
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return null;
	}

	public void setTimeProvider(TimeProvider timeProvider) {
		this.timeProvider = timeProvider;
		session.setGlobal("timeProvider", timeProvider);
	}
}
