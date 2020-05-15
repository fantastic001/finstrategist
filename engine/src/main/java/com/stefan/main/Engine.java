package com.stefan.main;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.time.LocalDate;
import java.util.ArrayList;

import com.stefan.model.*;

public class Engine {

	public static final void main(String[] args) {
		try {
			System.out.println("Starting application....");
			KieServices ks = KieServices.Factory.get();
			System.out.println("Getting classpath container....");
			KieContainer kContainer = ks.getKieClasspathContainer();
			System.out.println("Creating session....");
			KieSession kSession = kContainer.newKieSession("ksession-rule");
			kSession.setGlobal("logger", new Logger());

			FactHandle fact1;
			System.out.println("Inserting object into session");
			if (kSession == null) System.out.println("kSession is null!");
			fact1 = kSession.insert(new Stock("AAPL", LocalDate.now(), 10,12,15,2,523543253, 44));
			fact1 = kSession.insert(new Stock("AAPL", LocalDate.now().minusDays(1), 10,12,15,2,523543253, 44));
			fact1 = kSession.insert(new Stock("AAPL", LocalDate.now().minusDays(2), 10,13,15,2,523543253, 44));
			fact1 = kSession.insert(new Stock("AAPL", LocalDate.now().minusDays(3), 10,14,15,2,523543253, 44));
			fact1 = kSession.insert(new Stock("AAPL", LocalDate.now().minusDays(4), 10,15,15,2,523543253, 44));


			System.out.println("Firing rules");
			kSession.getAgenda().getAgendaGroup( "portfolio").setFocus();
			kSession.getAgenda().getAgendaGroup( "decide").setFocus();
			kSession.getAgenda().getAgendaGroup( "estimate").setFocus();
			kSession.getAgenda().getAgendaGroup( "collect").setFocus();
			kSession.getAgenda().getAgendaGroup( "preprocess").setFocus();
			kSession.fireAllRules();



		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
